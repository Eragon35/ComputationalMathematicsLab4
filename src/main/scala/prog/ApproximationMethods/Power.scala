package prog.ApproximationMethods

import scala.collection.mutable

object Power {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var SX: Double = 0.0
    var SXX: Double = 0.0
    var SY: Double = 0.0
    var SXY: Double = 0.0
    for ((x, y) <- map) {
      SX += Math.log(x)
      SXX += Math.pow(Math.log(x), 2)
      SY += Math.log(y)
      SXY += x * Math.log(y)
    }
    val delta = SXX * map.size - SX * SX
    val delta1 = SXX * SY - SX * SXY
    val delta2 = SXY * map.size - SX * SY
    val a = Math.pow(Math.E, delta1 / delta)
    val b = delta2 / delta

    val func = (x: Double) => a * Math.pow(x, b)
    Approximation("Степенная аппроксимация", func, f"y = $a%1.4f * x^$b%1.4f",
      Deviation.find(map, func), SquareDeviation.find(map, func))
  }
}
