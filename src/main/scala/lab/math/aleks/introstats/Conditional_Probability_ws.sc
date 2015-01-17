package lab.math.aleks.introstats

import lab.math.Rounding_lab_1._

object Conditional_Probability_ws {
	// P(A|B) = P(AB)/P(B)
	// P(B|A) = P(AB)/P(A)
  def condProb(pA: Double, pB: Double, pAB: Double) = {
  		(("P(B|A)", roundAt(2)(pAB/pA)), ("P(A|B)", roundAt(2)(pAB/pB)))
  }                                               //> condProb: (pA: Double, pB: Double, pAB: Double)((String, Double), (String, D
                                                  //| ouble))
  
  // ---------------------------- //
  
  // A = visit therapist = 0.27
  // B = use antidepressants = 0.45
  // (a) = P(B|A)
  // (b) = P(A|B)
  condProb(0.27, 0.45, 0.21)                      //> res0: ((String, Double), (String, Double)) = ((P(B|A),0.78),(P(A|B),0.47))
}