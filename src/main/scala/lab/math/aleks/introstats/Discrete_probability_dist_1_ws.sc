package lab.math.aleks.introstats

import lab.math.Rounding_lab_1.roundAt
import breeze.linalg._

object Discrete_probability_dist_1_ws {
	
	def missingProbs(rounding: Int)(
		prob_x_eq_X: DenseVector[Double],
		numMissing: Int
	) = {
		val known = roundAt(rounding)(prob_x_eq_X.sum)
		val res1 = roundAt(rounding)((1 - known) / numMissing)
		val res2 = roundAt(rounding)(1 - known - res1)
		(res1, res2)
	}                                         //> missingProbs: (rounding: Int)(prob_x_eq_X: breeze.linalg.DenseVector[Double]
                                                  //| , numMissing: Int)(Double, Double)
	
	val solve = missingProbs(2)_              //> solve  : (breeze.linalg.DenseVector[Double], Int) => (Double, Double) = <fun
                                                  //| ction2>
	// --------------------------- //
	
	solve(DenseVector(0.12, 0.29, 0.13), 2)   //> res0: (Double, Double) = (0.23,0.23)
}
/*



*/