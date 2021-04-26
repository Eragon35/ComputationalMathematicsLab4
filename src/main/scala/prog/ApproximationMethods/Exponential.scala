package prog.ApproximationMethods

import prog.ApproximationMethods.MatrixStaff.Cramer

import scala.collection.mutable

object Exponential {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var SX: Double = 0.0
    var SXX: Double = 0.0
    var SY: Double = 0.0
    var SXY: Double = 0.0
    for ((x, y) <- map) {
      SX += x
      SXX += Math.pow(x, 2)
      SY += Math.log(y)
      SXY += x * Math.log(y)
    }
    val answer = Cramer.findSolution(SX, SXX, SY, SXY, map.size)
    val a = Math.pow(Math.E, answer._1)
    val b = answer._2

    val func = (x: Double) => a * Math.pow(Math.E,b * x)
    Approximation("Экспоненциальня аппроксимация", func, f"y = $a%1.4f * e^($b%1.4fx)",
      Deviation.find(map, func), Deviation.findSquare(map, func))
  }
}
