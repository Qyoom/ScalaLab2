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
	
	solve(DenseVector(0.30,0.30,0.22), 2)     //> res0: (Double, Double) = (0.09,0.09)
	solve(DenseVector(0.27,0.26,0.23), 2)     //> res1: (Double, Double) = (0.12,0.12)
	solve(DenseVector(0.28, 0.18, 0.14), 2)   //> res2: (Double, Double) = (0.2,0.2)
	solve(DenseVector(0.18, 0.15, 0.26), 2)   //> res3: (Double, Double) = (0.21,0.2)
}
/*



*/