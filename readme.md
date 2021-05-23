##### Scala Asynchronous Programming #####


Futures provide a way to reason about performing many operations in parallel– in an efficient and non-blocking way. A Future is a placeholder object for a value that may not yet exist. Generally, the value of the Future is supplied concurrently and can subsequently be used. Composing concurrent tasks in this way tends to result in faster, asynchronous, non-blocking parallel code.

By default, futures and promises are non-blocking, making use of callbacks instead of typical blocking operations. To simplify the use of callbacks both syntactically and conceptually, Scala provides combinators such as flatMap, foreach, and filter used to compose futures in a non-blocking way. Blocking is still possible