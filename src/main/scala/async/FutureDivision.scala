package async
import java.io.FileWriter
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, SECONDS}
import scala.util.{Failure, Success}
object FutureDivision {
  def main(args: Array[String]): Unit = {

    val successExample :Future[Int] = Future{
      4 / 2
    }

    successExample.onComplete{
      case Success(value) => println(value.toString)
      case Failure(failure) =>println(failure.toString)
    }

    val failureExample :Future[Int] = Future{
      4 / 0
    }

    failureExample.onComplete{
      case Success(value) => println(value.toString)
      case Failure(failure) =>println(failure)
    }

  //Waiting till future result gets calculated
  //Blocking the code
  Await.ready(successExample,Duration.Inf)
  Await.ready(failureExample,Duration.Inf)


  }



}
