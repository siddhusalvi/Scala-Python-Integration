import sys.process._
object ScalaExecutor {
  def main(args: Array[String]): Unit = {

    //Using !
//    val numbers = "50_80"
    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/function.py 50_80"

    val result1 = command.!!
    println(result1)

    //
//    val result2 = command +" "+numbers!!
//      println(result1)


  }
}
