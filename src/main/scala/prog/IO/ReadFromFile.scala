package prog.IO

import scala.io.Source

object ReadFromFile {

  def read(fileName: String): Array[(Double, Double)] = {
    var array = Array[(Double, Double)]()
    try {
      FileChecker.check(fileName)
      val source = Source.fromFile(fileName)
      for (line <- source.getLines()) {
        var value = line.replace(',', '.').split(" ").map(x => x.toDouble)
        array = array :+ (value(0), value(1))
      }
      source.close()
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file\n" + e.getMessage)
        e.printStackTrace()
    }
    println(s"Из файла прочитано ${array.length} точек")
    if (array.length < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }
}
