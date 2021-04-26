package prog

import prog.ApproximationMethods.Approximation
import scalax.chart.module.Charting._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Graph {
  def show(map: mutable.SortedMap[Double, Double], results: ArrayBuffer[Approximation]): Unit = {
    val dataset = Seq(
      ("Выбранная функция", for ((key, value) <- map) yield (key, value)),
      (results(0).toString, for ((key, _) <- map) yield (key, results(0).func(key))),
      (results(1).toString, for ((key, _) <- map) yield (key, results(1).func(key))),
      ("y = 0", for ((key, _) <- map) yield (key, 0.0))
    )
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
