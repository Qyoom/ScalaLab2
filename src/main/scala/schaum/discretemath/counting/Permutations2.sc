package schaum.discretemath.counting
import schaum.discretemath.counting.Factorial._

// EXAMPLE 5.5
object Permutations2 {
  println("Schaum Permutations, EXAMPLE 5.5")     //> Schaum Permutations, EXAMPLE 5.5
  
  def numPerms(n: Int)(r: Int*): Int = {
  		// recursive
  		def denom(d: List[Int], acc: Int): Int = {
  			println("d: " + d + " | acc: " + acc)
	  		d match {
	  			case Nil => acc
	  			case x :: xs => {
	  				denom(xs, fac(x) * acc) // recurse
	  			}
	  		}
	  	}
  		fac(n) / denom(r.toList, 1)
  } // end numPerms                               //> numPerms: (n: Int)(r: Int*)Int
  
  /********** EXAMPLES **********/
  numPerms(7)(3,2)                                //> 3.036344593938168E64
                                                  //| 5.381780668201844E65
                                                  //| 3598695.6187410373
                                                  //| 2.852561716306302E7
                                                  //| fac(7): 5040
                                                  //| d: List(3, 2) | acc: 1
                                                  //| fac(3): 6
                                                  //| d: List(2) | acc: 6
                                                  //| fac(2): 2
                                                  //| d: List() | acc: 12
                                                  //| res0: Int = 420
  
}