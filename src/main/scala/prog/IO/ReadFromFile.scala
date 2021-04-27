package prog.IO

import scala.io.Source

object ReadFromFile {

  def read(fileName: String): collection.immutable.SortedMap[Double, Double] = {
    var array = collection.immutable.SortedMap[Double, Double]()
    try {
      FileChecker.check(fileName)
      val source = Source.fromFile(fileName)
      for (line <- source.getLines()) {
        val value = line.replace(',', '.').split(" ").map(x => x.toDouble)
        array += (value(0) -> value(1))
      }
      source.close()
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file\n" + e.getMessage)
        e.printStackTrace()
    }
    println(s"Из файла прочитано ${array.size} точек")
    if (array.size < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }
}
