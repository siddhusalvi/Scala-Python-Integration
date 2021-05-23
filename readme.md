## Scala Asynchronous Programming
####Futures
A Future is an object holding a value which may become available at some point. This value is usually the result of some other computation:
- If the computation has not yet completed, we say that the Future is not completed.
- If the computation has completed with a value or with an exception, we say that the Future is completed.

Completion can take one of two forms:
1. When a Future is completed with a value, we say that the future was successfully completed with that value.
1. When a Future is completed with an exception thrown by the computation, we say that the Future was failed with that exception.

A Future has an important property that it may only be assigned once. Once a Future object is given a value or an exception, it becomes in effect immutable– it can never be overwritten.

#####Callback

This callback is called asynchronously once the future is completed. If the future has already been completed when registering the callback, then the callback may either be executed asynchronously, or sequentially on the same thread.

```scala
    import scala.util.{Success, Failure}

    val f: Future[List[String]] = Future {
    session.getRecentPosts
 }

    f onComplete {
    case Success(posts) => for (post <- posts) println(post)
    case Failure(t) => println("An error has occurred: " + t.getMessage)
    }
```

####Promise
The Promise is a writable, single-assignment container that completes a Future. The Promise is similar to the Future. However, the Future is about the read-side of an asynchronous operation, while the Promise is about the write-side.

**It allows us to put the value of a completed asynchronous operation into the Future, and change the state of the Future from not completed to completed by invoking the success method.**
Once the Promise is completed, we cannot call the success() method again.

##Spark Asynchronous programming
apache spark also provide a asynchronous action for concurrent execution of jobs, Few Asynchronous actions spark provide as follows

- collectAsync() -> Returns a future for retrieving all elements of this RDD.
- countAsync() -> Returns a future for counting the number of elements in the RDD.
- foreachAsync(scala.Function1<T,scala.runtime.BoxedUnit> f) -> Applies a function f to all elements of this RDD.
- foreachPartitionAsync(scala.Function1<scala.collection.Iterator,scala.runtime.BoxedUnit> f) ->
- Applies a function f to each partition of this RDD.
- takeAsync(int num) -> Returns a future for retrieving the first num elements of the RDD.

**Result.await method does not work with spark. **
By default spark scheduler run spark jobs in FIFO (First In First Out) fashion.
To configure job scheduler we need to set configuration for it as follows

```scala
val conf = new SparkConf().setAppName("spark_auth")
.setMaster("local[*]").set("spark.scheduler.mode", "FAIR")
```

Official Documentation :
https://docs.scala-lang.org/overviews/core/futures.html
