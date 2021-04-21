package prog.IO

import prog.Point

import scala.+:
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ReadFromConsole {

  def read(): Array[(Double, Double)]  = {
    var array = Array[(Double, Double)]()
    var line = ""
    while (line != "end") {
      line = StdIn.readLine()
      val value = line.trim.split(" ").map(x => x.toDouble)
      array = array :+ (value(0), value(1))
    }
    if (array.length < 12) throw new IllegalArgumentException("Кол-во точек должно быть больше либо равно 12")
    array
  }

}
