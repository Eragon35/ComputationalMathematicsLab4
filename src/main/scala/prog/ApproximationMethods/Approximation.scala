package prog.ApproximationMethods

case class Approximation(name: String, func: Double => Double, equation: String, deviation: Double, squareDeviation: Double) {
  override def toString: String = name + ":\n" + equation + f"\nS = $deviation\nR^2 = $squareDeviation" // %1.6f
}