package basic
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.control.NonFatal

object SparkExecutor {
  def main(args: Array[String]): Unit = {
    try{
      val spark = SparkSession.builder()
        .master("local[2]")
        .appName("ScalaPython")
        .getOrCreate()

      val sparkContext = spark.sparkContext
      val numbers = Array("80_80")
      val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/function.py"

      val rdd = sparkContext.parallelize(numbers)

      val output = rdd.pipe(command).collect()
      output.foreach(println(_))
    }catch{
      case NonFatal(e) =>
        print("Error in main : " + e.printStackTrace())

    }

  }
}
