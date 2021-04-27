package prog

import prog.IO.WriteToFile

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import prog.ApproximationMethods.{Approximation, Exponential, Linear, Logarithmic, Power, Square}

object Main {

  var array: immutable.SortedMap[Double, Double] = immutable.SortedMap[Double, Double]()
  var result: ArrayBuffer[Approximation] = ArrayBuffer[Approximation]()
  var outputFilename: String = "output"

  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Заданная функция a: x - 2
        | Функция b: cos(x)
        | Функция c: e^(x / 2)
        | Функция d: ln x
        | Функция f: 1,38x^3 − 5,42x^2 + 2,57x + 10,95""".stripMargin)

    while (true) {
      println("\nВыберите функцию или введите точки из файла/консоли: ")
      array = ConsoleHandler.inputHandler(StdIn.readLine())

      println("Хотите вывести ответы в консоль?")
      val isConsole = ConsoleHandler.agreeHandler(StdIn.readLine())

      result += Linear.solve(array)
      result += Square.solve(array)
      result += Logarithmic.solve(array)
      result += Exponential.solve(array)
      result += Power.solve(array)

      result = result.sortWith(_.squareDeviation > _.squareDeviation)
      result = result.filter(x => !x.deviation.isNaN) // filter if approximation exists
      println("Начинаем вычислять корни:") // шучу сейчас буду только выводить корни
      if (isConsole) result.foreach(x => println(x))
      else WriteToFile.write(outputFilename, result)

      Graph.show(array, result)
      result.clear()
    }
  }
}
