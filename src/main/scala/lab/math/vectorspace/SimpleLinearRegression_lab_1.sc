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
  
  // ------ Squared error ------ //
  
  /* Least Squares: The "best-fitting" line can be defined as the one which
   * minimizes the sum of the squared residuals between observed output and
   * estimated output (dependent variables).
   */
  
 	def sumSquaredResiduals(Y_obs: DenseVector[Double], Y_est: DenseVector[Double]): Double = {
  		require(Y_obs.length == Y_est.length)
  		// Sum of the squared difference
  		println("mean of redisuals: " + mean((Y_obs - Y_est)))
  		pow(Y_obs - Y_est, 2).sum
	}                                         //> sumSquaredResiduals: (Y_obs: breeze.linalg.DenseVector[Double], Y_est: bree
                                                  //| ze.linalg.DenseVector[Double])Double
	
	// ------ Data ------ //
	// /Users/hieronymus/Development/Math/Aleks/Reference/Simple linear regression.rtfd
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
  fitLine(6.5)                                    //> res0: Double = 6.550000000000001
  val predictions = for(x <- X) yield fitLine(x)  //> predictions  : breeze.linalg.DenseVector[Double] = DenseVector(2.0964285714
                                                  //| 28572, 2.9250000000000007, 4.271428571428572, 4.892857142857144, 6.03214285
                                                  //| 7142858, 7.4821428571428585, 8.000000000000002)
  // Compare via sum of squared residuals
  sumSquaredResiduals(Y, predictions)             //> Jan 06, 2015 3:28:38 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader5672202808711355880netlib-native_system-osx-x86_64.jnilib
                                                  //| mean of redisuals: -9.516197353929913E-16
                                                  //| res1: Double = 12.124999999999998
  

}