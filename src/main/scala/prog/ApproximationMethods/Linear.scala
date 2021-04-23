package prog.ApproximationMethods

import scala.collection.mutable

object Linear {
  def solve(map: mutable.Map[Double, Double]): Double => Double = {
    var SX: Double = 0.0
    var SXX: Double = 0.0
    var SY: Double = 0.0
    var SXY: Double = 0.0
    for ((key, value) <- map) {
      SX += key
      SXX += Math.pow(key, 2)
      SY += value
      SXY += key * value
    }
    var delta = SXX * map.size - SX * SX
    var delta1 = SXY * map.size - SX * SY
    var delta2 = SXX * SY - SX * SXY
    var a = delta1 / delta
    var b = delta2 / delta
    (x: Double) => a * x + b
  }

}
