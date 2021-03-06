import scala.collection.mutable.ArrayBuffer

//var array = Array[(Float, Float)]
var v = Array((1.2, 2.2), (2.3, 1.4))
val d = (1.2,3.1) +: v
val w = v :+ (6.9, 9.1)

var array = Array[(Double, Double)]()
for (x <- -6 to 6) {
  println(x + " " + (-1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95))
}
var map = collection.mutable.Map[Double, Double]()
map += (1.2 -> 3.4)
map += (3.0 -> 5.2)
map += (1.2 -> 2.0)

var xVector: ArrayBuffer[Double] = ArrayBuffer.range(0, 3).map(_ => 1.toDouble)

var map = collection.mutable.Map[String, Double => Double]()
val func: Double => Double = (x: Double) => 1.7 * x + 0.2
map += ("Linear" -> func)

case class Approximation(name: String, func: Double => Double, deviation: Double)

val temp = Approximation("Linear", func, 0.311)
temp.name

val a = 2.0
val b = 3.334444
f"y = $a%1.4f * e^($b%1.4fx)"