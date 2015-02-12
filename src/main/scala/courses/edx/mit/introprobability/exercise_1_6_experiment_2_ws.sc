package courses.edx.mit.introprobability

import courses.edx.mit.introprobability.Exercise_1_6._
import courses.edx.mit.introprobability.ProbabilityFuncs1._

object exercise_1_6_experiment_2_ws {

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

	// ----- Probability Laws --------------- //
  
  // Event: More Heads than Tails
  val A = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			val numHeads = event.count(side => side == H)
  			if(numHeads > (event.length - numHeads))
  		} yield event
  }                                               //> A  : courses.edx.mit.introprobability.Exercise_1_6.TossSeq => List[List[cour
                                                  //| ses.edx.mit.introprobability.Exercise_1_6.Coin.Value]] = <function1>
  // Event: Second toss is a Tail
  val B = (sampleSpace: TossSeq) => {
  		for{
  			event <- sampleSpace
  			if (event(2) == T)
  		} yield event
  }                                               //> B  : courses.edx.mit.introprobability.Exercise_1_6.TossSeq => List[List[cour
                                                  //| ses.edx.mit.introprobability.Exercise_1_6.Coin.Value]] = <function1>
  
  // ----- Experiments -------------- //
  
  // Initiate experiment P(A|B)
  val (numer, denom) = Pr_A_given_B( A(sampleSpace), B(sampleSpace) )
                                                  //> numer  : Int = 1
                                                  //| denom  : Int = 4
  // Result P(A|B)
  numer / denom.toDouble                          //> res0: Double = 0.25
  println("P(A|B): " + numer + "/" + denom)       //> P(A|B): 1/4
  
  // P(A intercept B)
  Pr_A_intersect_B( A(sampleSpace), B(sampleSpace) )
                                                  //> res1: Double = 1.0
 
  // P(B)
  B(sampleSpace).length                           //> res2: Int = 4
  
  // P(A)
  A(sampleSpace).length                           //> res3: Int = 4
}
/*



*/