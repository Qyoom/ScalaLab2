package courses.edx.mit.introprobability

object ProbabilityFuncs1 {

	// P(A|B)
	// = P(A intercept B) / P(B)
	def Pr_A_given_B[T] (A:List[T], B:List[T]): (Int, Int) = {
  		val numer = Pr_A_intercept_B_direct(A,B)
  		val denom = B.length
  		(numer, denom)
	}
	
	// P(A intercept B)
	// = P(B) * P(A|B)
	def Pr_A_intercept_B[T] (A:List[T], B:List[T]): Double = {
		val (numer, denom) = Pr_A_given_B(A, B)
		val P_A_given_B = numer / denom.toDouble
		B.length * P_A_given_B
	}
	
	// P(A intercept B) directly
	def Pr_A_intercept_B_direct[T] (A:List[T], B:List[T]): Int = {
  		val A_intercept_B = for {
  			B_event <- B
  			A_event <- A
  			if(A_event == B_event)
  		} yield A_event
  		A_intercept_B.length
	}
}