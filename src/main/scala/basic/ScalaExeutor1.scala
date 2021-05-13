import sys.process.{ProcessLogger, _}
import scala.io.Source
object ScalaExeutor1 {
  def main(args: Array[String]): Unit = {
    val stdout = new StringBuilder
    val stderr = new StringBuilder

    //Using !
    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/function.py 50_80"
    val result = command !! ProcessLogger(stdout append _, stderr append _)

    println(result)
    println("stdout: " + stdout)
    println("stderr: " + stderr)


  }
}
