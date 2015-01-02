package lab.math.coursera.ohio.calculus.seriesandsequences

object LimitFuncComposition {
	/* Template for composing limit functions with numerators and denomenators
	 * as anonymous functions
	 */
	type R = Double
	def compose(numer: R=>R, denom: R=>R) = {
  		(x:R) => numer(x) / denom(x)
	}
}