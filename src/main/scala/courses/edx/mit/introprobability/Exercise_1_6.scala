package courses.edx.mit.introprobability

object Exercise_1_6 {
	
  	// ----- Sample Space ------------- //
	
	object Toss extends Enumeration {
	  	type Toss = Value
		val Heads, Tails = Value
  	}
  	val H = Toss.Heads
  	val T = Toss.Tails
  	val sides = Toss.values.toList
  	
  	// Events are possible sequences of a uniform number of coin tosses
  	// List of events
  	type TossSeq = List[List[Toss.Value]]
  
	// Sample space for this experiment is all combinations of three coin tosses
	// Order of elements matters, i.e. (H,H,T) != (H,T,H)
	val sampleSpace:TossSeq = for{
  		_1st_coin <- sides
  		_2nd_coin <- sides
  		_3rd_coin <- sides
	} yield List(_1st_coin, _2nd_coin, _3rd_coin)
  
	println("sampleSpace.length: " + sampleSpace.length)
	
	// P(A|B)
	def Pr_A_given_B (A:TossSeq, B:TossSeq): (Int, Int) = {
  		val A_intercept_B = for {
  			B_event <- B
  			A_event <- A
  			if(A_event == B_event)
  		} yield A_event
  		(A_intercept_B.length, B.length)
	}
	
	// ----- log sample space ------------ //
	
	val sampleSpace_log = for{
		event <- sampleSpace
	} yield {
		event match {
			case List(a, b, c) => (a, b, c)
		}                                 
	}
}