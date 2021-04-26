package prog

import prog.IO.WriteToFile

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import prog.ApproximationMethods.{Deviation, Linear, Square}

object Main {

  var array: mutable.SortedMap[Double, Double] = collection.mutable.SortedMap[Double, Double]()
  var result: mutable.Map[String, Double => Double] = collection.mutable.Map[String, Double => Double]()
  var filename: String = "output"
  var answer: ArrayBuffer[String] = ArrayBuffer[String]()


  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Заданная функция a: x - 2
        | Функция b: cos(x)
        | Функция c: e^(x / 2)
        | Функция d: ln x
        | Функция f: −1,38x^3 − 5,42x^2 + 2,57x + 10,95""".stripMargin)

    while (true) {
      println("\nВыберите функцию или введите точки из файла/консоли: ")
      array = ConsoleHandler.inputHandler(StdIn.readLine())
//      array.foreach(x => println(x._1 + " " + x._2))

      println("Хотите вывести ответы в консоль?")
      val isConsole = ConsoleHandler.agreeHandler(StdIn.readLine())

      result += ("Linear" -> Linear.solve(array)) // added resulting function of linear approximation
      result += ("Square" -> Square.solve(array)) // added resulting function of least squares approximation

      answer += s"Линейная аппроксимация: отклонение = ${Deviation.find(array, result("Linear"))}"
      answer += s"Квадратичная аппроксимация: отклонение = ${Deviation.find(array, result("Square"))}"
      println("Начинаем вычислять корни:") // шучу сейчас буду только выводить корни
      if (isConsole) answer.foreach(x => println(x))
      else WriteToFile.write(filename, answer)

      Graph.show(array, result)


      answer.clear()
    }
  }
}
