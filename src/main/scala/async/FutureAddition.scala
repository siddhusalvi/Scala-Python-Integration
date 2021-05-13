package async

import java.io.FileWriter
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, SECONDS}
import scala.util.{Failure, Success}
object FutureAddition {
  def main(args: Array[String]): Unit = {


    val producer: Future[Int] = Future {
      val r:Int = 1 + 2
      r
    }

    producer.onComplete{
      case Success(value) => println(value.toString)
      case Failure(failure) =>writeFile(failure.toString)
    }
    val duration = Duration(2,SECONDS)
    Await.result(producer,duration)

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
