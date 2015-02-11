package courses.edx.mit.introprobability

import courses.edx.mit.introprobability.Exercise_1_6._
import courses.edx.mit.introprobability.ProbabilityFuncs1._

object exercise_1_6_experiment_1_ws {

	// Event space is all combinations of 3 coin tosses
	// See Exercise_1_6 (import)
	sampleSpace_log.foreach(println)          //> sampleSpace.length: 8
                                                  //| (Heads,Heads,Heads)
                                                  //| (Heads,Heads,Tails)
                                                  //| (Heads,Tails,Heads)
                                                  //| (Heads,Tails,Tails)
                                                  //| (Tails,Heads,Heads)
                                                  //| (Tails,Heads,Tails)
                                                  //| (Tails,Tails,Heads)
                                                  //| (Tails,Tails,Tails)
 
	// ----- This experiment's Probability Laws --------------- //
  
  // Event: More Heads than Tails
  val A = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			val numHeads = event.count(side => side == H)
  			if(numHeads > (event.length - numHeads))
  		} yield event
  }                                               //> A  : courses.edx.mit.introprobability.Exercise_1_6.TossSeq => List[List[cour
                                                  //| ses.edx.mit.introprobability.Exercise_1_6.Toss.Value]] = <function1>
  // Event: First toss is a Head
  val B = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			if (event.head == H) // not that kind of head
  		} yield event
  }                                               //> B  : courses.edx.mit.introprobability.Exercise_1_6.TossSeq => List[List[cour
                                                  //| ses.edx.mit.introprobability.Exercise_1_6.Toss.Value]] = <function1>
  // P(A|B)
  val (numer, denom) = Pr_A_given_B( A(sampleSpace), B(sampleSpace) )
                                                  //> numer  : Int = 3
                                                  //| denom  : Int = 4
  numer / denom.toDouble                          //> res0: Double = 0.75
  println("P(A|B): " + numer + "/" + denom)       //> P(A|B): 3/4
  
}
/*



*/