package lab.implicits

import lab.implicits.Implicits_scope._

//http://www.artima.com/weblogs/viewpost.jsp?thread=179766
object Implicits_lab_1 extends App {
  
  val x = Array(1, 2, 3)
  val y = Array('A', 'B', 'C')
  
  // error without implicit conversion
  var v: String = x
  var w: String = y
  
  println(v)
  println(y)
  
  val a = Array(1, 2, 3)
  val b = Array(4, 5, 6)
  // val c = a append b // Not figured out yet
}