package prog.ApproximationMethods

import scala.collection.mutable

object Deviation {
  def find(map: mutable.SortedMap[Double, Double], func: Double => Double): Double = {
    var deviation: Double = 0
    for ((x, y) <- map) deviation += Math.pow(func(x) - y, 2)
    deviation
  }
}
