package courses.edx.mit.introprobability

import courses.edx.mit.introprobability.Exercise_1_7._
import courses.edx.mit.introprobability.ProbabilityFuncs1._
import math._

object exercise_1_7_experiment_1_ws {
  
	// Event space is all combinations of 2 4-sided die rolls.
	// See Exercise_1_7 (import)
	sampleSpace_log.foreach(println)          //> sampleSpace.length: 16
                                                  //| (1,1)
                                                  //| (1,2)
                                                  //| (1,3)
                                                  //| (1,4)
                                                  //| (2,1)
                                                  //| (2,2)
                                                  //| (2,3)
                                                  //| (2,4)
                                                  //| (3,1)
                                                  //| (3,2)
                                                  //| (3,3)
                                                  //| (3,4)
                                                  //| (4,1)
                                                  //| (4,2)
                                                  //| (4,3)
                                                  //| (4,4)
  	
  	// ----- This experiment's Probability Laws --------------- //
  	
  	// Event: {max(X,Y) = m} where X = first roll, Y = second roll
  def A_event (sampleSpace: RollSeq)(m: Int) = {
  		for{
  			event <- sampleSpace
  			if(event.max == m)
  		} yield event
  }                                               //> A_event: (sampleSpace: courses.edx.mit.introprobability.Exercise_1_7.RollSeq
                                                  //| )(m: Int)List[List[Int]]
  // Event: {min(X,Y) = m} where X = first roll, Y = second roll
  def B_event (sampleSpace: RollSeq)(m: Int) = {
  		for{
  			event <- sampleSpace
  			if(event.min == m)
  		} yield event
  }                                               //> B_event: (sampleSpace: courses.edx.mit.introprobability.Exercise_1_7.RollSeq
                                                  //| )(m: Int)List[List[Int]]
  
  val A = A_event(sampleSpace)_                   //> A  : Int => List[List[Int]] = <function1>
  val B = B_event(sampleSpace)_                   //> B  : Int => List[List[Int]] = <function1>
  
  // ----- Experiment -------------- //
  
  // // Initiate experiments for P(A|B) with variations
  for(side <- sides) {
  		val (numer, denom) = Pr_A_given_B( A(side), B(2) ) // per exercise 1.7
  		// Result P(A|B)
  		numer / denom.toDouble
  		println("X=" + side + ", Y=2, P(A|B): " + numer + "/" + denom)
  }                                               //> X=1, Y=2, P(A|B): 0/5
                                                  //| X=2, Y=2, P(A|B): 1/5
                                                  //| X=3, Y=2, P(A|B): 2/5
                                                  //| X=4, Y=2, P(A|B): 2/5
}
/*



*/