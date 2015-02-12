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
  
  condProb(0.91, 0.07, 0.06)                      //> res0: ((String, Double), (String, Double)) = ((P(B|A),0.07),(P(A|B),0.86))
}