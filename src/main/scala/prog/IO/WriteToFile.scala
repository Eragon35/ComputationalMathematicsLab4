package prog.IO

import java.io.{FileOutputStream, OutputStreamWriter}
import scala.collection.mutable.ArrayBuffer

object WriteToFile {

  def write(filename: String, answer: ArrayBuffer[String]): Unit = {
    try {
      FileChecker.check(filename, full = false)
      val streamWriter = new OutputStreamWriter(new FileOutputStream(filename))
      answer.foreach(x => streamWriter.write(x + "\n")) // Writing to the file each element of collection
      streamWriter.close()
    } catch {
      case e: Throwable => Console.err.println("Problem with writing collection to file\n" + e.getMessage)
    }
  }
}
