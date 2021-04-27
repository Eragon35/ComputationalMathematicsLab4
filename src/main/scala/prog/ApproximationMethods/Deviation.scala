package prog.ApproximationMethods

import scala.collection.immutable

object Deviation {
  def find(map: immutable.SortedMap[Double, Double], func: Double => Double): Double = {
    var deviation: Double = 0
    for ((x, y) <- map) deviation += Math.pow(func(x) - y, 2)
    deviation
  }

  def findSquare(map: immutable.SortedMap[Double, Double], func: Double => Double): Double =
    Math.sqrt(find(map, func) / map.size)

}
