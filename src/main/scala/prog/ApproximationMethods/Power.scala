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
    val delta = Ln2X * map.size - LnX * LnX
    val delta1 = Ln2X * LnY - LnX * LnYLnX
    val delta2 = LnYLnX * map.size - LnX * LnY
//val answer = Cramer.findSolution(LnX, Ln2X, LnY, LnYLnX, map.size)
//    val a = Math.pow(Math.E, answer._1)
//    val b = answer._2

    val a = Math.pow(Math.E, delta1 / delta)
    val b = delta2 / delta

    val func = (x: Double) => a * Math.pow(x, b)
    Approximation("Степенная аппроксимация", func, f"y = $a%1.4f * x^$b%1.4f",
      Deviation.find(map, func), SquareDeviation.find(map, func))
  }
}
