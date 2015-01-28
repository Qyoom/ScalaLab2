package lab.math.vectorspace

import lab.math.vectorspace.SimpleLinearRegression_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression_lab_1_ws {
	// ------ Data ------------------------------- //
	// www.Aleks.com Simple linear regression
	// Sample observed input
	val X = DenseVector(2.2, 3.0, 4.3, 4.9, 6.0, 7.4, 7.9)
                                                  //> X  : breeze.linalg.DenseVector[Double] = DenseVector(2.2, 3.0, 4.3, 4.9, 6.0
                                                  //| , 7.4, 7.9)
  // Sample observed output
	val Y = DenseVector(1.1, 4.4, 3.1, 5.2, 7.5, 5.4, 9.0)
                                                  //> Y  : breeze.linalg.DenseVector[Double] = DenseVector(1.1, 4.4, 3.1, 5.2, 7.5
                                                  //| , 5.4, 9.0)
	
  // ------ Input Measures ------------------------------- //
  
  mean(Y)                                         //> res0: Double = 5.1000000000000005
  
  // Variance: average of the squared differences from the Mean.
  val variance = pow(Y - mean(Y), 2).sum / Y.length
                                                  //> variance  : Double = 5.937142857142857
  // Standard Deviation
  val stdDev = sqrt(variance)                     //> stdDev  : Double = 2.4366253009321843
  
  // Convertion to the standard normal distribution (per Aleks)
  val z = (Y - mean(Y)) / stdDev                  //> z  : breeze.linalg.DenseVector[Double] = DenseVector(-1.641614735950461, -0.
                                                  //| 28728257879133073, -0.8208073679752306, 0.04104036839876138, 0.9849688415702
                                                  //| 763, 0.1231211051962845, 1.600574367551699)
  
  // --------------------------------------------------------------------------- //
  // Referencing www.Aleks.com "Simple linear regression" for statistical formulas
  
  // ------ Model, prediction --------------- //
  // Derive the model from observations
  val model, (slope, intercept) = deriveModel(X, Y)
                                                  //> model  : (Double, Double) = (1.0357142857142858,-0.18214285714285694)
                                                  //| slope  : Double = 1.0357142857142858
                                                  //| intercept  : Double = -0.18214285714285694
  val predict = fitLine(model)_                   //> predict  : Double => Double = <function1>
  
  // Produce predicted outcomes from model based on observed input
  val predictions = for(x <- X) yield predict(x)  //> predictions  : breeze.linalg.DenseVector[Double] = DenseVector(2.0964285714
                                                  //| 28572, 2.9250000000000007, 4.271428571428572, 4.892857142857144, 6.03214285
                                                  //| 7142858, 7.4821428571428585, 8.000000000000002)
  mean(predictions)                               //> res1: Double = 5.100000000000001
  // Prediction output
 
  // ----- Output measures -------- //
  diagnosticLog(Y, predictions)                   //> Jan 27, 2015 3:35:53 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader5217998143990544263netlib-native_system-osx-x86_64.jnilib
                                                  //| SSE: 12.124999999999998
                                                  //| mean of redisuals: -9.516197353929913E-16
                                                  //| SST: 41.559999999999995
                                                  //| SSR: 29.43500000000001
                                                  //| SST - (SSE + SSR): -1.4210854715202004E-14
                                                  //| SSR/SST (r^2): 0.7082531280077
  // Compare via sum of squared residuals
  val SSE = sumSquaredResiduals(Y, predictions)   //> SSE  : Double = 12.124999999999998
  // Mean squared error. MSE is an unbiased estimate of the variance of the error term epsilon.
  val MSE = SSE / (Y.length - 2)                  //> MSE  : Double = 2.425
  // The square root of MSE is the standard error of the estimate, which is an unbiased estimate of the standard deviation of the error term epsilon.
  val s = sqrt(MSE)                               //> s  : Double = 1.5572411502397436
  // Standard error of the estimated slope
	val SEb1 = s / pow(X - mean(X), 2).sum    //> SEb1  : Double = 0.05675077078133176
	// Using this statistic, it is possible to do a test of the null hypothesis that the population slope equals zero, that is, that there is no linear relationship between the variables x and y.
	// See StatLearning (Hastie, Tibshirani) also
	val t = slope / SEb1                      //> t  : Double = 18.250224119510733
	val SSR = pow(predictions - mean(Y), 2).sum
                                                  //> SSR  : Double = 29.43500000000001
  // With this statistic it is also possible to do a test of the null hypothesis, i.e. that there is no linear relationship between the variables x and y
	(SSR/1)/MSE                               //> res2: Double = 12.138144329896912
}
/*



*/