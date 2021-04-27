package prog.ApproximationMethods

import prog.ApproximationMethods.MatrixStaff.Cramer

import scala.collection.immutable

object Linear {
  def solve(map: immutable.SortedMap[Double, Double]): Approximation = {
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
    val answer = Cramer.findSolution(SX, SXX, SY, SXY, map.size)
    val a = answer._2
    val b = answer._1

    val func = (x: Double) => a * x + b
    Approximation("Линейная аппроксимация", func, f"y = $a%1.4f * x + $b%1.4f",
      Deviation.find(map, func), Deviation.findSquare(map, func))
  }
}
