package lab.implicits

object Implicits_scope {
    
    implicit def array2string[T](a: Array[T]) = a.toString

}