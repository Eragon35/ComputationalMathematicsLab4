package prog

import prog.IO.{ReadFromConsole, ReadFromFile}

import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
  private val inputFile = "input"

  @tailrec
  def inputHandler(line: String): collection.mutable.Map[Double, Double] = {
    line.trim.toLowerCase match {
      case "file" | "fiel" | "файл" | "афшл" => ReadFromFile.read(inputFile)
      case "console" | "консоль" | "сонсолу" => ReadFromConsole.read()
      case "1" | "a" => chooseRange(first)
      case "2" | "b"=> chooseRange(second)
      case "3" | "c" => chooseRange(third)
      case "4" | "d" => chooseRange(forth)
      case "5" | "f" => chooseRange(fifth)
      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        collection.mutable.Map[Double, Double]() // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Давай по новой, Миша все х*йня")
        inputHandler(StdIn.readLine())
    }
  }

  private def first(x: Double): Double = x - 2
  private def second(x: Double): Double = Math.cos(x)
  private def third(x: Double): Double = Math.pow(Math.E, x / 2)
  private def forth(x: Double): Double = Math.log(x)
  private def fifth(x: Double): Double = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95

  private def chooseRange(func: Double => Double): collection.mutable.Map[Double, Double] = {
    println("Выберите диапазон для апроксимации функции")
    val line = StdIn.readLine().trim.replaceAll(",", ".").split(" ").map(x => x.toDouble)
    val left = line(0)
    val right = line(1)
    var array = collection.mutable.Map[Double, Double]()
    for (i <- left to right by (right-left)/12) array += (i -> func(i))
    array
  }


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
}
