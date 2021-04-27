package prog

import prog.ApproximationMethods.Approximation
import scalax.chart.module.Charting._

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

object Graph {
  def show(map: immutable.SortedMap[Double, Double], results: ArrayBuffer[Approximation]): Unit = {
    var dataset = Seq(
      ("Выбранная функция", for ((x, y) <- map) yield (x, y)),
      ("y = 0", for ((x, _) <- map) yield (x, 0.0))
    )
    for (result <- results) dataset = dataset :+ (result.toString, for ((x, _) <- map) yield (x, result.func(x)))
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
