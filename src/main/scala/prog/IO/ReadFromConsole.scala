package prog.IO

import scala.io.StdIn

object ReadFromConsole {

  def read(): collection.mutable.SortedMap[Double, Double]  = {
    println("Вводите точки, в конце введите 'end'")
    val array = collection.mutable.SortedMap[Double, Double]()
    var line = StdIn.readLine().trim
    while (line != "end" | line != "конец" | line != "утв") {
      try {
        val value = line.trim.replaceAll(",", ".").split(" ").map(x => x.toDouble)
        array += (value(0) -> value(1))
      } catch {
        case _: Exception => Console.err.println("Problem with parsing numbers from string")
      }
      line = StdIn.readLine().trim.toLowerCase
    }
    if (array.size < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }

}
