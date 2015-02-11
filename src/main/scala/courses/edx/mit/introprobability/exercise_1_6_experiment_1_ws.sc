package courses.edx.mit.introprobability

object exercise_1_6_experiment_1_ws {

	// ----- Sample Space ------------- //
	
	object Toss extends Enumeration {
	  	type Toss = Value
		val Heads, Tails = Value
  	}
  	val H = Toss.Heads                        //> H  : courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.Toss.Valu
                                                  //| e = Heads
  	val T = Toss.Tails                        //> T  : courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.Toss.Valu
                                                  //| e = Tails
  	val sides = Toss.values.toList            //> sides  : List[courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.
                                                  //| Toss.Value] = List(Heads, Tails)
  // Events are possible sequences of the same number of coin tosses
  // List of events
  type TossSeq = List[List[Toss.Value]]
  
  // Sample space for this experiment is all combinations of three coin tosses
  // Order of elements matters, i.e. (H,H,T) != (H,T,H)
  val sampleSpace:TossSeq = for{
  		_1st <- sides
  		_2nd <- sides
  		_3rd <- sides
  } yield List(_1st, _2nd, _3rd)                  //> sampleSpace  : courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws
                                                  //| .TossSeq = List(List(Heads, Heads, Heads), List(Heads, Heads, Tails), List(H
                                                  //| eads, Tails, Heads), List(Heads, Tails, Tails), List(Tails, Heads, Heads), L
                                                  //| ist(Tails, Heads, Tails), List(Tails, Tails, Heads), List(Tails, Tails, Tail
                                                  //| s))
  sampleSpace.length                              //> res0: Int = 8
  
  // ----- Probability Laws --------------- //
  
  // Event: More Heads than Tails
  val A = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			val numHeads = event.count(side => side == H)
  			if(numHeads > (event.length - numHeads))
  		} yield event
  }                                               //> A  : courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.TossSeq =
                                                  //| > List[List[courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.To
                                                  //| ss.Value]] = <function1>
  // Event: First toss is a Head
  val B = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			if (event.head == H)
  		} yield event
  }                                               //> B  : courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.TossSeq 
                                                  //| => List[List[courses.edx.mit.introprobability.exercise_1_6_experiment_1_ws.
                                                  //| Toss.Value]] = <function1>
  
  def Pr_A_given_B (A:TossSeq, B:TossSeq): (Int, Int) = {
  		val A_intercept_B = for {
  			B_event <- B
  			A_event <- A
  			if(A_event == B_event)
  		} yield A_event
  		(A_intercept_B.length, B.length)
  }                                               //> Pr_A_given_B: (A: courses.edx.mit.introprobability.exercise_1_6_experiment_
                                                  //| 1_ws.TossSeq, B: courses.edx.mit.introprobability.exercise_1_6_experiment_1
                                                  //| _ws.TossSeq)(Int, Int)
  
  val (numer, denom) = Pr_A_given_B( A(sampleSpace), B(sampleSpace) )
                                                  //> numer  : Int = 3
                                                  //| denom  : Int = 4
  numer / denom.toDouble                          //> res1: Double = 0.75
  println("P(A|B): " + numer + "/" + denom)       //> P(A|B): 3/4
  
}
/*



*/