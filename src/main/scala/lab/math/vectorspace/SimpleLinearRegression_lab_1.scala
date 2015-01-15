package lab.math.vectorspace

import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression_lab_1 {

  	// ------ Simple Linear Regression Model------ //
	// Referencing www.Aleks.com "Simple linear regression" for statistical formulas
	
	// Derive model from observations
	// Returns slope and intercept
	def deriveModel(X: DenseVector[Double], Y: DenseVector[Double]) = {
		val x_mean = mean(X)
		val y_mean = mean(Y)
		val x_diffs = X - x_mean
		val y_diffs = Y - y_mean
		val slope = (x_diffs :* y_diffs).sum / pow(x_diffs, 2).sum
		val intercept = y_mean - slope * x_mean
		//println("slope:" + slope + " intercept:" + intercept)
		(slope, intercept)
	}
	
	def fitLine(model: (Double, Double)) (x: Double): Double = {
		val slope = model._1
		val intercept = model._2
		val y = slope * x + intercept
		y
	}
  
  // ------ Squared error ---------------------- //
  
  /* Least Squares: The "best-fitting" line can be defined as the one which
   * minimizes the sum of the squared residuals (errors) between observed output and
   * estimated output (dependent variables).
   */
  // Diagnostic
 	def sumSquaredResiduals(Y_obs: DenseVector[Double], Y_est: DenseVector[Double]): Double = {
  		require(Y_obs.length == Y_est.length)
  		val Y_mean = mean(Y_obs)
  		// Sum of the squared errors (residuals, or difference between observed and predicted)
  		val SSE = pow(Y_obs - Y_est, 2).sum
  		// Regression sum of squares
  		val SSR = pow(Y_est - Y_mean, 2).sum
  		// Total sum of Squares, spread of Y values about their mean
  		val SST = pow(Y_obs - Y_mean, 2).sum
  		// Gives the proportion of the total variation in the y values that is accounted for by the estimated linear relationship between x and y. Numerically equal to the square of the sample correlation coefficient r.
  		val r_squared = SSR/SST
  		println("mean of redisuals: " + mean((Y_obs - Y_est)) + "\nSST: " + SST + "\nSSR: " + SSR + "\nSST - (SSE + SSR): " + (SST - (SSE + SSR)) + "\nSSR/SST (r^2): " + r_squared)
  		SSE // return
	}

}