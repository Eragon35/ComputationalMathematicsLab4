package prog

import scalax.chart.module.Charting._

import scala.collection.mutable

object Graph {
  def show(map: mutable.SortedMap[Double, Double], results: mutable.Map[String, Double => Double]): Unit = {
    val linear : Option[Double => Double] = results.get("Linear")
    val square : Option[Double => Double] = results.get("Square")
    val dataset = Seq(
      ("Выбранная функция", for ((key, value) <- map) yield (key, value)),
      ("Линейная аппроксимация", for ((key, _) <- map) yield (key, linear.get(key))),
      ("Квадратичная аппроксимация", for ((key, _) <- map) yield (key, square.get(key))),
      ("y = 0", for ((key, _) <- map) yield (key, 0.0))
    )
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
