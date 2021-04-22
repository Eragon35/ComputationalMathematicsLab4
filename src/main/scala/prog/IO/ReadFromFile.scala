package prog.IO

import scala.io.Source

object ReadFromFile {

  def read(fileName: String): Array[(Double, Double)] = {
    var array = Array[(Double, Double)]()
    try {
      FileChecker.check(fileName)
      val source = Source.fromFile(fileName)
      val line = source.getLines().next().split(" ").map(x => x.toDouble)
      array = array :+ (line(0), line(1))
      source.close()
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file\n" + e.getMessage)
        e.printStackTrace()
    }
    if (array.length < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }
}
