package basic
import scala.sys.process.ProcessLogger
import sys.process.{ProcessLogger, _}
import scala.io.Source


object ScalaExecutor2 {
  def main(args: Array[String]): Unit = {
    val stdout = new StringBuilder
    val stderr = new StringBuilder

    //Using !
    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/function.py 40_30"
    val result = command.lineStream_!

    val output = result.toList
    println(output.toString())
    println("abc")

  }
}
