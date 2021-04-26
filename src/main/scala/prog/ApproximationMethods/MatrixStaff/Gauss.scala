package prog.ApproximationMethods.MatrixStaff

import scala.collection.mutable.ArrayBuffer

object Gauss {
  var order: ArrayBuffer[Int] = ArrayBuffer[Int](1, 2, 3)
  var xVector: ArrayBuffer[Double] = ArrayBuffer.range(0, 3).map(_ => 1.toDouble)

  def findTriangleMatrix(matrix: ArrayBuffer[ArrayBuffer[Double]]): ArrayBuffer[ArrayBuffer[Double]] = {
    val solutionMatrix = matrix.map(_.clone())
    for (i <- 0 until solutionMatrix.size-1){
      val max = solutionMatrix(i).map(x => Math.abs(x)).slice(i, solutionMatrix.size).max
      val index = solutionMatrix(i).map(x => Math.abs(x)).indexOf(max) //finding column with higher abs(element)
      swapColumns(solutionMatrix, i, index)
      val originRow = solutionMatrix(i)
      if (solutionMatrix(i)(i) > 0) solutionMatrix(i) = solutionMatrix(i).map(_ / max)
      else solutionMatrix(i) = solutionMatrix(i).map(_ / -max) //to be honest doesn't know why abs(max) not working
      for (j <- i+1 until solutionMatrix.size){
        val multiply = solutionMatrix(j)(i)
        for (k <- i to solutionMatrix.size) solutionMatrix(j)(k) = solutionMatrix(j)(k) - multiply * solutionMatrix(i)(k)
      }
      solutionMatrix(i) = originRow
    }
    solutionMatrix
  }
  def swapColumns(input: ArrayBuffer[ArrayBuffer[Double]], leftColumn: Int, rightColumn: Int): Unit = {
    val swap = order(leftColumn) // swap columns in order to save the changes
    order(leftColumn) = order(rightColumn)
    order(rightColumn) = swap
    input.foreach(r => { // swap columns in matrix
      val temp = r(leftColumn)
      r(leftColumn) = r(rightColumn)
      r(rightColumn) = temp
    })
  }

  def findSolution(triangleMatrix: ArrayBuffer[ArrayBuffer[Double]]): ArrayBuffer[Double] = {
    for (i <- triangleMatrix.indices.reverse) {
      var sum: Double = triangleMatrix(i)(triangleMatrix.size)
      for (j <- i+1 until triangleMatrix.size) sum -= triangleMatrix(i)(j) * xVector(j)
      xVector(i) = sum / triangleMatrix(i)(i) // use order(i)-1 to put answer on the right place
    }
    val temp = ArrayBuffer.range(0, xVector.size).map(_ => 1.toDouble) // return Xs on the right places
    for (i <-xVector.indices) temp(order(i)-1) = xVector(i)
    temp
  }
}
