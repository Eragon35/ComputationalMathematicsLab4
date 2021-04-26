package prog.ApproximationMethods

import prog.ApproximationMethods.MatrixStaff.Cramer

import scala.collection.mutable

object Power {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var LnX: Double = 0.0
    var Ln2X: Double = 0.0
    var LnY: Double = 0.0
    var LnYLnX: Double = 0.0
    for ((x, y) <- map) {
      LnX += Math.log(x)
      Ln2X += Math.pow(Math.log(x), 2)
      LnY += Math.log(y)
      LnYLnX += Math.log(x) * Math.log(y)
    }
    val answer = Cramer.findSolution(LnX, Ln2X, LnY, LnYLnX, map.size)
    val a = Math.pow(Math.E, answer._1)
    val b = answer._2

    val func = (x: Double) => a * Math.pow(x, b)
    Approximation("Степенная аппроксимация", func, f"y = $a%1.4f * x^$b%1.4f",
      Deviation.find(map, func), Deviation.findSquare(map, func))
  }
}
