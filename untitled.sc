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