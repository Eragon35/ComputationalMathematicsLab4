package prog

import prog.IO.WriteToFile
import prog.MathMethod.{BisectionMethod, FixedPointIteration, SecantMethod}

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main {
  var accuracy: Double = 0.01
  var left: Double = -10
  var right: Double = 10
  var step: Double = 0.25
  var func: Double => Double = Math.pow(left, _)
  var funcDerivative: Double => Double = Math.pow(left, _)
  var funcSecondDerivative: Double => Double = Math.pow(left, _)
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
      println("\nВыберите функцию: ")
      val temp = ConsoleHandler.functionHandler(StdIn.readLine())
      func = temp._1
      funcDerivative = temp._2
      funcSecondDerivative = temp._3
      Graph.show()
      ConsoleHandler.confirmGraph()
      val isConsole = ConsoleHandler.outputRoots()

      BisectionMethod.solve() // find right root by 'Метод половинного деления'
      SecantMethod.solve() // find left root by 'Метод секущих'
      FixedPointIteration.solve() // find central root by 'Метод простой итерации'

      println("Начинаем вычислять корни:") // шучу сейчас буду только выводить корни
      if (isConsole) answer.foreach(x => println(x))
      else WriteToFile.write(filename)

      left = -10
      right = 10
      step = 0.25
      answer.clear()
    }
  }
}
