package prog.ApproximationMethods

import scala.collection.mutable

object Logarithmic {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var LnX: Double = 0.0
    var Ln2X: Double = 0.0
    var SY: Double = 0.0
    var YLnX: Double = 0.0
    for ((key, value) <- map) {
      LnX += Math.log(key)
      Ln2X += Math.pow(Math.log(key), 2)
      SY += value
      YLnX += Math.log(key) * value
    }
    val delta = Ln2X * map.size - LnX * LnX
    val delta1 = YLnX * map.size - LnX * SY
    val delta2 = Ln2X * SY - LnX * YLnX
    val a = delta1 / delta
    val b = delta2 / delta
    val func = (x: Double) => a * Math.log(x) + b
    Approximation("Логарифмическая аппроксимация", func, f"y = $a%1.4f * ln x + $b%1.4f",
      Deviation.find(map, func), SquareDeviation.find(map, func))
  }
}
