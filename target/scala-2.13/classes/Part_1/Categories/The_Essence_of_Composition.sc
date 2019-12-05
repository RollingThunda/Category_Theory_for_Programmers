trait A
trait B
trait C
case class a() extends A
case class b() extends B
case class c() extends C

val double = (i: Int) => { i * 2 }
val f: A=>B = (a: A) => b()
val g: B=>C = (b: B) => c()
val h = g compose f
h(a())

def identity[A](a: A): A = a
identity(a())
f comp