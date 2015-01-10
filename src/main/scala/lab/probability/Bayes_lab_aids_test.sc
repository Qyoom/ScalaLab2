package lab.probability

object Bayes_lab_aids_test {
	// https://class.coursera.org/statinference-010/lecture/207
	
	/*                       P(A|B)P(B)
	 * P(B|A) = -------------------------------------
	 *           P(A|B)P(B) + {1 - P(A|B)}{1 - P(B)}
	 *
	 *	 A = test positive
	 * B = have disease
	 *
	 *            P(BA)
	 * P(B|A) = --------
	 *            P(A)
	 *
	 *
	 *                       P(+|D)P(D)
	 * P(D|+) = -------------------------------------
	 *           P(+|D)P(D) + P(+|!D)P(!D)
	 *
	 *
	 *                       P(+|D)P(D)
	 * P(D|+) = -------------------------------------
	 *           P(+|D)P(D) + {1 - P(+|D)}{1 - P(D)}
	 */
  
  // sensitivity   P(+|D)
  val sensi = .997                                //> sensi  : Double = 0.997
  
  // specificity   P(-|!D)
  val speci = .985                                //> speci  : Double = 0.985
  
  // prevalence in population   P(D)
  val preva = .001                                //> preva  : Double = 0.001
  
  // ----- equasion ---------- //
  
  def bayesProb(sensi: Double, speci: Double, preva: Double): Double = {
  		val numer = sensi * preva
  		val denom = (sensi * preva) + ((1 - speci) * (1 - preva))
  		println("numer: " + numer + "\ndenom: " + denom)
  		numer / denom
  }                                               //> bayesProb: (sensi: Double, speci: Double, preva: Double)Double
  
  // P(D|+)
  // positive predictive value
  // Probability of having disease given positive test
  bayesProb(sensi, speci, preva)                  //> numer: 9.97E-4
                                                  //| denom: 0.015982000000000014
                                                  //| res0: Double = 0.06238268051557998
}