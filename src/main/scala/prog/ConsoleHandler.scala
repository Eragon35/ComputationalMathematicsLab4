package prog

import prog.IO.ReadFromFile
import prog.Main._

import scala.io.StdIn

object ConsoleHandler {
  def functionHandler(line: String): Double => Double = {
    line.trim.toLowerCase match {
      case "1" | "a" => first
      case "2" | "b"=> second
      case "3" | "c" => third
      case "4" | "d" => forth
      case "5" | "f" => fifth
      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        Math.pow(2, _) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Такой функции нет, установлена первая функция")
        first
    }
  }

  private def first(x: Double): Double = x - 2
  private def second(x: Double): Double = Math.cos(x)
  private def third(x: Double): Double = Math.pow(Math.E, x / 2)
  private def forth(x: Double): Double = Math.log(x)
  private def fifth(x: Double): Double = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95



  def agreeHandler(line: String): Boolean = {
    line.trim.toLowerCase match {
      case "da" | "yes" | "y" | "+" | "true" | "да" => true
      case a => try {
        if (a.replaceAll(",", ".").toDouble > 0) return true
      } catch { case _: Exception => }
        false
      case _ => false
    }
  }

  def accuracyAgreeHandler(line: String): Double = {
    if (agreeHandler(line)) 0.01
    else {
      println("Введите желаемую точность")
      try {
        val accuracy = StdIn.readDouble()
        accuracy
      } catch {
        case _: Exception => Console.err.println("Ошибка чтения\nточность установлена на значение 0.01")
          0.01
      }
    }
  }

  def confirmGraph(): Unit = {
    var confirmGraph = false
    while (!confirmGraph) {
      println("Хотите ввести данные в консоли?")
      if (agreeHandler(StdIn.readLine())) {
        println("Вас устраивает точность в 0.01 ?")
        accuracy = ConsoleHandler.accuracyAgreeHandler(StdIn.readLine())
        println("Задданая точность = " + accuracy)
        println("Введите начало интервала: ")
        left = StdIn.readDouble()
        println("Введите конец интервала: ")
        right = StdIn.readDouble()
        if (right <= left) {
          Console.err.println("Конец интеравл должен быть больше начала интервала")
          println("устанлвлен интервал [-5, 2]")
          left = -5
          right = 2
        }
        else step = if (right - left < 5) (right - left) / 10 else 0.5
      } else {
        print("Введите имя файла: ")
        ReadFromFile.read(StdIn.readLine().trim)
      }
      Graph.show()
      println("Вас устраивает график? Он содержит корни")
      confirmGraph = ConsoleHandler.agreeHandler(StdIn.readLine())
    }
  }

  def outputRoots(): Boolean = {
    println("Хотите вывести ответы в консоль?")
    if (agreeHandler(StdIn.readLine())) true
    else {
      print("Введите имя файла: ")
      filename = StdIn.readLine().trim
      false
    }
  }
}
