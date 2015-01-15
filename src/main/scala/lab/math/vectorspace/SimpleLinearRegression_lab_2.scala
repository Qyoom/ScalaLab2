package lab.math.vectorspace

import breeze.linalg._
import breeze.numerics._
import breeze.math._
import breeze.stats._

object SimpleLinearRegression_lab_2 {

	// ------ Simple Linear Regression Model------ //
	// Referencing John Hopkins Least squares estimation of regression lines
	// Referencing file:///Users/hieronymus/Development/Courses/Coursera/Signature%20courses/Johns%20Hopkins%20-%20Data%20Science%20Series/github_teaching_materials_v2/courses/07_RegressionModels/01_03_ols/index.html#4
	
	// Derive model from observations
	// Returns slope and intercept
	def deriveModel(X: DenseVector[Double], Y: DenseVector[Double]) = {
		val slope = pearsons(Y,X) * (stddev(Y) / stddev(X))
		val intercept = mean(Y) - slope * mean(X)
		//println("slope:" + slope + " intercept:" + intercept)
		(slope, intercept)
	}
  
	// Pearson's Correlation
	// Following http://www.mathsisfun.com/data/correlation.html
	def pearsons(X: DenseVector[Double], Y: DenseVector[Double]): Double = {
	
		val a = X :- mean(X)
		val a_sq = pow(a, 2)
		val a_sq_sum = a_sq.sum
				
		val b = Y :- mean(Y)
		val b_sq = pow(b, 2)
		val b_sq_sum = b_sq.sum
		
		val ab_dot = a dot b
		val sqrt_ab = sqrt(a_sq_sum * b_sq_sum)
		
		val result = ab_dot / sqrt_ab
		
		// Diagnostic
		/*
		println("a:" + a)
		println("a_sq:" + a_sq)
		println("a_sq_sum:" + a_sq_sum)
		println("b:" + b)
		println("b_sq:" + b_sq)
		println("b_sq_sum:" + b_sq_sum)
		println("ab_prod:" + ab_dot)
		*/
		
		result // return
	}
}





