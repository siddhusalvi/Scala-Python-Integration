package async

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, SECONDS}
import scala.util.{Failure, Success}
object PromiseDivision extends App {


//Success Example
val successPromise = Promise[Int]()

  val successFuture :Future[Int] = Future{
    4 / 2
  }
  successPromise completeWith successFuture

  successPromise.future.onComplete {
        case Success(value) => println(value.toString)
        case Failure(failure) =>println(failure)
  }

  val failurePromise = Promise[Int]()

  val failureFuture :Future[Int] = Future{
    4 / 0
  }
  failurePromise completeWith failureFuture

  failurePromise.future.onComplete {
    case Success(value) => println(value.toString)
    case Failure(failure) =>println(failure)
  }
  //Waiting till future result gets calculated
  //Blocking the code
  Await.ready(successPromise.future,Duration.Inf)
  Await.ready(failurePromise.future,Duration.Inf)//Infinite Duration

}