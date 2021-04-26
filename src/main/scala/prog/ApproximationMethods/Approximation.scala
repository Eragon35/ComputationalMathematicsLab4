package prog.ApproximationMethods

case class Approximation(name: String, func: Double => Double, deviation: Double, equation: String) {
  override def toString: String = name + ":\n" + equation + f"\nR^2 = $deviation" // %1.6f
}
