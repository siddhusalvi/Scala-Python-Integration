package sparkAsync

import org.apache.spark.sql.SparkSession

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import scala.util.control.NonFatal

object SparkAsyncDemo1 {
  def main(args: Array[String]): Unit = {

  try {
    //Spark setup (3.00 ,2.12)
    val spark = SparkSession.builder()
      .master("local[2]")
      .appName("SparkAsyncDemo1")
      .config("spark.scheduler.mode", "FAIR")
      .getOrCreate()

    val sparkContext = spark.sparkContext

    //data
    val numbers = List("4","5")

    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/python/square.py"

    //Creating RDD
    val rdd = sparkContext.parallelize(numbers)

    //Performing Async Operation
    val output = rdd.pipe(command).collect()

    output.foreach(println(_))
    println("other operation")


    println("running some code after future")


  } catch {
    case NonFatal(e) =>
      print("Error in main : " + e.printStackTrace())

  }
}
}