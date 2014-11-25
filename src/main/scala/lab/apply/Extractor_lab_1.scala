package lab.apply


object Twice {
  def apply(x: Int): Int = {
      println("In apply, got " + x)
      x * 2
  }
  def unapply(z: Int): Option[Int] = {
      println("In unapply, got " + z)
      if (z%2 == 0) {Some(z/2)} else {Some(0)} // THIS is screwed up because it won't return None
  }
}

object TwiceTest extends App {
  println("21 % 2 == 0: " + (21 % 2 == 0))
  val x = Twice(21)
  println("x: " + x)
  x match { case Twice(n) => println("x match: " + n) } // prints 21
  val y = 21
  y match { case Twice(m) => println("m match: " + m) }
}