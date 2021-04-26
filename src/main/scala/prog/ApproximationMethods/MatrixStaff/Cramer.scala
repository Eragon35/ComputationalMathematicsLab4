package prog.ApproximationMethods.MatrixStaff

object Cramer {
  def findSolution(SX: Double, SXX: Double, SY: Double, SXY: Double, n: Int): (Double, Double) = {
    val delta = SXX * n - SX * SX
    val delta1 = SXX * SY - SX * SXY
    val delta2 = SXY * n - SX * SY
    (delta1 / delta, delta2 / delta)
  }
}
