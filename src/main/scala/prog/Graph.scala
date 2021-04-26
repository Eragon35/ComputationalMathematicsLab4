package prog

import prog.ApproximationMethods.Approximation
import scalax.chart.module.Charting._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Graph {
  def show(map: mutable.SortedMap[Double, Double], results: ArrayBuffer[Approximation]): Unit = {
    val dataset = Seq(
      ("Выбранная функция", for ((x, y) <- map) yield (x, y)),
      (results(0).toString, for ((x, _) <- map) yield (x, results(0).func(x))),
      (results(1).toString, for ((x, _) <- map) yield (x, results(1).func(x))),
      (results(2).toString, for ((x, _) <- map) yield (x, results(2).func(x))),
      (results(3).toString, for ((x, _) <- map) yield (x, results(3).func(x))),
//      (results(4).toString, for ((x, _) <- map) yield (x, results(4).func(x))),
      ("y = 0", for ((x, _) <- map) yield (x, 0.0))
    )
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
