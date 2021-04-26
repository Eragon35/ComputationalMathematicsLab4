package prog.ApproximationMethods

import scala.collection.mutable

object Linear {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var SX: Double = 0.0
    var SXX: Double = 0.0
    var SY: Double = 0.0
    var SXY: Double = 0.0
    for ((x, y) <- map) {
      SX += x
      SXX += Math.pow(x, 2)
      SY += y
      SXY += x * y
    }
    val delta = SXX * map.size - SX * SX
    val delta1 = SXY * map.size - SX * SY
    val delta2 = SXX * SY - SX * SXY
    val a = delta1 / delta
    val b = delta2 / delta
    val func = (x: Double) => a * x + b
    Approximation("Линейная аппроксимация", func, f"y = $a%1.4f * x + $b%1.4f",
      Deviation.find(map, func), SquareDeviation.find(map, func))
  }
}
