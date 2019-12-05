import scala.collection.mutable.HashMap

val f: Boolean => Boolean = _ => ???

def g: Boolean => Boolean = ???

val fact = (n: Int) => (1 to n).product

fact(5)

//def absurd[A]: Nothing => A


 def memoize[A, B] (f:A => B): A => B = new HashMap[A, B]() {
   override def apply(key: A) = getOrElseUpdate(key, f(key))
 }

def fib(n: Int): Int = {
  n match {
    case 1 => 1
    case 2 => 1
    case n => fib(n-1) + fib(n-2)
  }
}

fib(3)

