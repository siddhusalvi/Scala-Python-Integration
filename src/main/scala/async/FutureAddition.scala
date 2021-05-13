package async

import java.io.FileWriter
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object FutureAddition {
  def main(args: Array[String]): Unit = {


    val producer: Future[Int] = Future {
      val r:Int = 1 + 2
      r
    }

    producer.onComplete{
      case Success(value) => writeFile(value.toString)
      case Failure(failure) =>writeFile(failure.toString)
    }


    Thread.sleep(5000)

  }


  def writeFile(text : String) =  {
    val fw = new FileWriter("D:/IdeaProjects/ScalaPython/src/main/resources/FutureOutput.txt", true)
    try {
      fw.write(text)
      fw.write("\n")
    }
    finally fw.close()
  }

}
