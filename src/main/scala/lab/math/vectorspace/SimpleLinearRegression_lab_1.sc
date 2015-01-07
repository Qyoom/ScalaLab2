package lab.math.vectorspace

import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression_lab_1 {

	// ------ Simple Linear Regression Model------ //
	
	// Derive model from observations
	// Model is function for y = mx + b
	def model(X: DenseVector[Double], Y: DenseVector[Double]) = {
		val x_mean = mean(X)
		val y_mean = mean(Y)
		val x_diffs = X - x_mean
		val y_diffs = Y - y_mean
		val slope = (x_diffs :* y_diffs).sum / pow(x_diffs, 2).sum
		val intercept = y_mean - slope * x_mean
		println("slope:" + slope + " intercept:" + intercept)
		(x: Double) => slope * x + intercept
	}                                         //> model: (X: breeze.linalg.DenseVector[Double], Y: breeze.linalg.DenseVector[D
                                                  //| ouble])Double => Double
	
  
  // ------ Squared error ---------------------- //
  
  /* Least Squares: The "best-fitting" line can be defined as the one which
   * minimizes the sum of the squared residuals between observed output and
   * estimated output (dependent variables).
   */
  
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
	}                                         //> sumSquaredResiduals: (Y_obs: breeze.linalg.DenseVector[Double], Y_est: bree
                                                  //| ze.linalg.DenseVector[Double])Double
	
	// ------ Data ------------------------------- //
	// www.Aleks.com Simple linear regression
	// Sample observed input
	val X = DenseVector(2.2, 3.0, 4.3, 4.9, 6.0, 7.4, 7.9)
                                                  //> X  : breeze.linalg.DenseVector[Double] = DenseVector(2.2, 3.0, 4.3, 4.9, 6.
                                                  //| 0, 7.4, 7.9)
  // Sample observed output
	val Y = DenseVector(1.1, 4.4, 3.1, 5.2, 7.5, 5.4, 9.0)
                                                  //> Y  : breeze.linalg.DenseVector[Double] = DenseVector(1.1, 4.4, 3.1, 5.2, 7.
                                                  //| 5, 5.4, 9.0)
  // ------ Test ------ //
  
  // Derive the model from observations
  val fitLine = model(X, Y)                       //> slope:1.0357142857142858 intercept:-0.18214285714285694
                                                  //| fitLine  : Double => Double = <function1>
  
  // Produce predicted outcome from model based on observed input
  val predictions = for(x <- X) yield fitLine(x)  //> predictions  : breeze.linalg.DenseVector[Double] = DenseVector(2.0964285714
                                                  //| 28572, 2.9250000000000007, 4.271428571428572, 4.892857142857144, 6.03214285
                                                  //| 7142858, 7.4821428571428585, 8.000000000000002)
  // Compare via sum of squared residuals
  val SSE = sumSquaredResiduals(Y, predictions)   //> Jan 06, 2015 5:13:37 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader7706488130363794005netlib-native_system-osx-x86_64.jnilib
                                                  //| mean of redisuals: -9.516197353929913E-16
                                                  //| SST: 41.559999999999995
                                                  //| SSR: 29.43500000000001
                                                  //| SST - (SSE + SSR): -1.4210854715202004E-14
                                                  //| SSR/SST (r^2): 0.7082531280077
                                                  //| SSE  : Double = 12.124999999999998
  // Mean squared error. MSE is an unbiased estimate of the variance of the error term epsilon.
  val MSE = SSE / (Y.length - 2)                  //> MSE  : Double = 2.425
  // The square root of MSE is the standard error of the estimate, which is an unbiased estimate of the standard deviation of the error term epsilon.
  val s = sqrt(MSE)                               //> s  : Double = 1.5572411502397436
  // Standard error of the estimated slope
	val SEb1 = s / pow(X - mean(X), 2).sum    //> SEb1  : Double = 0.05675077078133176
}