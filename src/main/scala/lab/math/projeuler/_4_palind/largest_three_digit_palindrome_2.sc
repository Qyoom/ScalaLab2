package lab.math.projeuler._4_palind

import lab.math.projeuler._4_palind.Palindrome._
import scala.math._

object largest_three_digit_palindrome_2 {

	def largestPal (n1: Int, n2: Int): (Int, Int, Int) = {
	
		// TODO: This is brute force. I think tree recursion might be more efficient?
		val candidates = for {
			i <- n1 to 1 by -1
			j <- n2 to 1 by -1
			candidate = i * j
			if(isPal(candidate)) // Should break out of inner loop here.
		} yield (candidate, i, j)
		
		println("Number of palendromes found: " + candidates.length)
		
		candidates.max
	}                                         //> largestPal: (n1: Int, n2: Int)(Int, Int, Int)
	
	largestPal(999, 999)                      //> Number of palendromes found: 5064
                                                  //| res0: (Int, Int, Int) = (906609,993,913)
	
}