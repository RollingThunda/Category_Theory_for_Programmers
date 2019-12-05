import scala.collection.mutable.HashMap
val f: Boolean => Boolean = _ => ???

def g: Boolean => Boolean = ???

val fact = (n: Int) => (1 to n).product
//def absurd[A]: Nothing => A

 def memoize[A, B] (f:A => B): A => B = new HashMap[A, B]() {
   override def apply(key: A) = getOrElseUpdate(key, f(key))
 }

def fib(n: Int): BigInt = {
  n match {
    case 1 => 1
    case 2 => 1
    case n => fib(n-1) + fib(n-2)
  }
}

val fib_mem: Int => BigInt = memoize(fib)

val fib_mem2: Int => BigInt = memoize{
  case 1 => 1
  case 2 => 2
  case n =>  fib_mem2(n-1) + fib_mem2(n-2)
}

val n = 40

val t0 = System.nanoTime()
fib(n)
val t1 = System.nanoTime()
println("Elapsed time: " + (t1 - t0)/1000000 + "ms")

val t0 = System.nanoTime()
fib_mem(n)
val t1 = System.nanoTime()
println("Elapsed time: " + (t1 - t0) /1000000+ "ms")

val t0 = System.nanoTime()
fib_mem(n)
val t1 = System.nanoTime()
println("Elapsed time: " + (t1 - t0) /1000000+ "ms")

val t0 = System.nanoTime()
fib_mem2(n)
val t1 = System.nanoTime()
println("Elapsed time: " + (t1 - t0) /1000000+ "ms")

val t0 = System.nanoTime()
fib_mem2(n)
val t1 = System.nanoTime()
println("Elapsed time: " + (t1 - t0) /1000000+ "ms")