package prog

import scalax.chart.module.Charting._

import scala.collection.mutable

object Graph {
  def show(map: mutable.SortedMap[Double, Double], results: mutable.Map[String, Double => Double]): Unit = {
    val dataset = Seq(
      ("Выбранная функция", for ((key, value) <- map) yield (key, value)),
      ("0", for ((key, value) <- map) yield (key, 0.0))
    )
//    for ((key,value) <- results) {
//      dataset = dataset :+ (key, for (x <- map.keySet) yield (x, value(x)))
//    }
      XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
