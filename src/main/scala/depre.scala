import scala.collection.mutable.HashMap

object depre extends App
{
  def memoize[A, B] (f:A => B): A => B = new HashMap[A, B]() {
    override def apply(key: A) = getOrElseUpdate(key, f(key))
  }
}

