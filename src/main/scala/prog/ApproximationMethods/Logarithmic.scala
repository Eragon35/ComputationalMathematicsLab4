package prog.ApproximationMethods

import prog.ApproximationMethods.MatrixStaff.Cramer

import scala.collection.immutable

object Logarithmic {
  def solve(map: immutable.SortedMap[Double, Double]): Approximation = {
    var LnX: Double = 0.0
    var Ln2X: Double = 0.0
    var SY: Double = 0.0
    var YLnX: Double = 0.0
    for ((x, y) <- map) {
      LnX += Math.log(x)
      Ln2X += Math.pow(Math.log(x), 2)
      SY += y
      YLnX += Math.log(x) * y
    }
    val answer = Cramer.findSolution(LnX, Ln2X, SY, YLnX, map.size)
    val a = answer._2
    val b = answer._1

    val func = (x: Double) => a * Math.log(x) + b
    Approximation("Логарифмическая аппроксимация", func, f"y = $a%1.4f * ln x + $b%1.4f",
      Deviation.find(map, func), Deviation.findSquare(map, func))
  }
}
