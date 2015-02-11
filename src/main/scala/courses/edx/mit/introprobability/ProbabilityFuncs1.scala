package courses.edx.mit.introprobability

object ProbabilityFuncs1 {

	// P(A|B)
	def Pr_A_given_B[T] (A:List[T], B:List[T]): (Int, Int) = {
  		val A_intercept_B = for {
  			B_event <- B
  			A_event <- A
  			if(A_event == B_event)
  		} yield A_event
  		(A_intercept_B.length, B.length)
	}
}