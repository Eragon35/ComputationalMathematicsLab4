package prog.ApproximationMethods

import scala.collection.mutable

object SquareDeviation {
  def find(map: mutable.SortedMap[Double, Double], func: Double => Double): Double = {
    var deviation: Double = 0
    for ((key, value) <- map) deviation += Math.pow(func(key) - value, 2)
    Math.sqrt(deviation / map.size)
  }
}
