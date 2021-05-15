//package streaming
//import org.apache.kafka.clients.consumer.ConsumerRecord
//import parser.Parser
//import org.apache.kafka.common.serialization.StringDeserializer
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.streaming.dstream.InputDStream
//import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
//import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
//import org.apache.spark.streaming.kafka010._
//import org.apache.spark.streaming.{Milliseconds, StreamingContext}
//
//import java.io.{BufferedReader, InputStreamReader, PrintStream}
//import scala.collection.mutable.ListBuffer
//import scala.concurrent.ExecutionContext.Implicits.global
//
//object StreamingDemo2 {
//  def main(args: Array[String]): Unit = {
//
//    //Spark setup (3.00 ,2.12)
//    val spark = SparkSession.builder()
//      .master("local[2]")
//      .appName("SparkAsyncDemo1")
////      .config("spark.scheduler.mode", "FAIR")
//      .getOrCreate()
//
//    val sparkContext = spark.sparkContext
//
//    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/python/double.py"
//
//    val ssc = new StreamingContext(sparkContext, Milliseconds(1000))
//
//    val kafkaParams = Map[String, Object](
//      "bootstrap.servers" -> "localhost:9092",
//      "key.deserializer" -> classOf[StringDeserializer],
//      "value.deserializer" -> classOf[StringDeserializer],
//      "group.id" -> "testgroup",
//      "auto.offset.reset" -> "latest",
//      "enable.auto.commit" -> (false: java.lang.Boolean)
//    )
//
//    val topics = Array("test")
//
//    val stream= KafkaUtils.createDirectStream[String,String](ssc,PreferConsistent,Subscribe[String,String](topics,kafkaParams))
//
//    stream.foreachRDD {
//      rdd => rdd.foreachPartition {
//        itr => itr.foreach(record => println(record.value()))
//      }
//    }
//
//    ssc.start()
//    ssc.awaitTermination()
//
//  }
//
//
//  val pythonProcess:ProcessBuilder = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/python/addition.py")
//  val prcessManager = pythonProcess.start()
//  val ps = new PrintStream(prcessManager.getOutputStream)
//  val reader = new BufferedReader(new InputStreamReader(prcessManager.getInputStream))
//  var outputList = ListBuffer[String]()
//
//  for(number <- nums){
//    ps.println(number)
//    ps.flush()
//
//    var line = reader.readLine()
//    if(line != null){
//      outputList.append(line)
//    }
//  }
//  outputList
//
//
//}
