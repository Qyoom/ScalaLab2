package schaum.discretemath.counting
import schaum.discretemath.counting.Factorial._

object Permutations3 {
	def numPerms(n: Int)(r: Int*): Int = {
  		println("n:" + n + " | r:" + r)
  		
  		def denom(d: Seq[Int], acc: Int): Int = {
	  		d match {
	  			//println("d: " + d + " | acc: " + acc)
	  			case Nil => acc
	  			case x :: xs => {
	  				denom(xs, fac(x) * acc) // recurse
	  			}
	  		}
	  	}
  		denom(r, 1)
	}                                               //> numPerms: (n: Int)(r: Int*)Int
  
  numPerms(1)(2) 
}