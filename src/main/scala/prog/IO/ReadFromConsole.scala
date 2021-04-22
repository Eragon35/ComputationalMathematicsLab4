package prog.IO

import scala.io.StdIn

object ReadFromConsole {

  def read(): Array[(Double, Double)]  = {
    println("Вводите точки, в конце введите 'end'")
    var array = Array[(Double, Double)]()
    var line = ""
    while (line != "end" | line != "конец" | line != "утв") {
      line = StdIn.readLine().trim
      val value = line.trim.replaceAll(",", ".").split(" ").map(x => x.toDouble)
      array = array :+ (value(0), value(1))
    }
    if (array.length < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }

}
