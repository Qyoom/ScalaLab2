package lab.math.aleks.introstats

import lab.math.Rounding_lab_1._

object Independent_Mutually_Exclusive_ws {
	
	def union(pA: Double, pB: Double) = {
		// Intersection probabilities
		// Probability if independent = P(A) + P(B) - P(AB)
		// Probability if mutually exclusive = P(A) + P(B)
		val pAUB_ind = pA + pB - (pA * pB)
		val pAUB_mutExc = pA + pB
		//(roundAt(2)(pAUB_ind), roundAt(2)(pAUB_mutExc))
		//(pAUB_ind, pAUB_mutExc)
		(roundAt(4)(pAUB_ind), roundAt(4)(pAUB_mutExc))
	}                                         //> union: (pA: Double, pB: Double)(Double, Double)
	
	// ----------------------------------- //
	
	val pB = 0.67                             //> pB  : Double = 0.67
	val pC = 0.26                             //> pC  : Double = 0.26
	union(pB, pC)                             //> res0: (Double, Double) = (0.7558,0.93)
}