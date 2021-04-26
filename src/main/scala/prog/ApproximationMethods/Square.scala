package prog.ApproximationMethods

import prog.ApproximationMethods.MatrixStaff.Gauss

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Square {
  def solve(map: mutable.SortedMap[Double, Double]): Approximation = {
    var SX: Double = 0.0
    var SX2: Double = 0.0
    var SX3: Double = 0.0
    var SX4: Double = 0.0
    var SY: Double = 0.0
    var SXY: Double = 0.0
    var SX2Y: Double = 0.0
    for ((x, y) <- map) {
      SX += x
      SX2 += Math.pow(x, 2)
      SX3 += Math.pow(x, 3)
      SX4 += Math.pow(x, 4)
      SY += y
      SXY += x * y
      SX2Y += Math.pow(x, 2) * y
    }
    /*   a0  a1  a2
    map.size sx  sx2 | sy
          sx sx2 sx3 | sxy
         sx2 sx3 sx4 | sx2y

         𝝋 = a2 * x^2 + a1 * x + a0  */
    val matrix: ArrayBuffer[ArrayBuffer[Double]] = ArrayBuffer(
      ArrayBuffer(map.size, SX, SX2, SY),
      ArrayBuffer(SX, SX2, SX3, SXY),
      ArrayBuffer(SX2, SX3, SX4, SX2Y)
    )
    val a = Gauss.findSolution(Gauss.findTriangleMatrix(matrix))
    val func = (x: Double) => a(0) + a(1) * x + a(2) * Math.pow(x, 2)
    Approximation("Квадратичная аппроксимация", func, f"y = ${a(2)}%1.4f x^2 + ${a(1)}%1.4f x + ${a(0)}%1.4f",
      Deviation.find(map, func), Deviation.findSquare(map, func))
  }
}
