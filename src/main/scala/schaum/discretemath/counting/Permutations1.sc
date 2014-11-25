package schaum.discretemath.counting
import schaum.discretemath.counting.Factorial._

// Theorem 5.4, p.91
// Also example on p. 93, Sampling without replacement
object Permutations1 {
  println("Schaum Permutations")                  //> Schaum Permutations
  
  def numPerms(n: Int, r: Int): Int = {
  		println("n:" + n + " | r:" + r)
  		
  		val numer = fac(n)
  		println("numer:" + numer)
  		
  		fac(n) / fac(n - r)
  }                                               //> numPerms: (n: Int, r: Int)Int
  
  /*
  def numPerms(n: Int, r: Int): Int = {
  		fac(n) / fac(n - r)
  }
  */
  
  //numPerms(6, 3)
  //numPerms(5, 3)
  //numPerms(52, 3)  // COMPUTER CAN'T HANDLE BIG NUMBERS!!
}