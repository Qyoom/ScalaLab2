package lab.math.vectorspace
  
import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression {

  // ------ Simple Linear Regression Model------ //
	// Referencing www.Aleks.com "Simple linear regression" for statistical formulas
	// This is also the equation model that Haistie/Tibshirani present.
  
	/* Least Squares: The "best-fitting" line can be defined as the one which
	 * minimizes the sum of the squared residuals (errors) between observed output and
	 * estimated output (dependent variables).
	 */
	
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
		val y = slope * x + intercept // y = mx + b
		y
	}
  
	// This provides the estimate for the standard deviation referred to by Intro to Statistical Learning 
	// (James, Witten, Hastie and Tibshirani), p.65
	def sumSquaredResiduals(Y_obs: DenseVector[Double], Y_est: DenseVector[Double]): Double = {
		// Sum of the squared errors (residuals, or difference between observed and predicted)
  		val SSE = pow(Y_obs - Y_est, 2).sum
  		SSE
	}
	
	def correlation(X: DenseVector[Double], Y: DenseVector[Double]): Double = {
		val x_mean = mean(X)
		val y_mean = mean(Y)
		val x_diffs = X - x_mean
		val y_diffs = Y - y_mean
		val numer = (x_diffs :* y_diffs).sum
		val denom = sqrt(pow(x_diffs, 2).sum) * sqrt(pow(y_diffs, 2).sum)
		numer / denom
	}
  
 	def diagnosticLog(Y_obs: DenseVector[Double], Y_est: DenseVector[Double]) {
  		require(Y_obs.length == Y_est.length)
  		val Y_mean = mean(Y_obs)
  		
  		// Sum of the squared errors (residuals, or difference between observed and predicted)
  		val SSE = sumSquaredResiduals(Y_obs, Y_est)
  		
  		// Regression sum of squares
  		val SSR = pow(Y_est - Y_mean, 2).sum
  		
  		// Total sum of Squares, spread of Y values about their mean
  		val SST = pow(Y_obs - Y_mean, 2).sum
  		
  		// Gives the proportion of the total variation in the y values that is accounted for by the estimated linear relationship between x and y. Numerically equal to the square of the sample correlation coefficient r.
  		val r_squared = SSR/SST
  		val alt_r_squared = 1 - r_squared
  		
  		val F = {
  			val p = 1 // number of parameters. This example is a simple single variable
  			val n = Y_obs.length // sample size
  			val numer = (SST - SSR) / n
  			val denom = SSR / (n - p - 1)
  			numer / denom
  		}
  		
  		println("SSE: " + SSE + "\nmean of redisuals: " + mean((Y_obs - Y_est)) + "\nSST: " + SST + "\nSSR: " + SSR + "\nSST - (SSE + SSR): " + (SST - (SSE + SSR)) + "\nSSR/SST (r^2): " + r_squared + "\n1 - SSR/SST (Tibshirani version of r^2): " + alt_r_squared + "\nF: " + F)
 	}

}