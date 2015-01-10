package lab.math.aleks.introstats

import lab.math.vectorspace.SimpleLinearRegression_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression_lab_2 {

	val X = DenseVector(216.3, 237.3, 255.8, 285.0, 296.7)
                                                  //> X  : breeze.linalg.DenseVector[Double] = DenseVector(216.3, 237.3, 255.8, 28
                                                  //| 5.0, 296.7)
	val Y = DenseVector(210.9, 245.1, 247.1, 301.4, 295.4)
                                                  //> Y  : breeze.linalg.DenseVector[Double] = DenseVector(210.9, 245.1, 247.1, 30
                                                  //| 1.4, 295.4)
  // Referencing www.Aleks.com "Simple linear regression" for statistical formulas
  
  // Derive the model from observations
  val model, (slope, intercept) = deriveModel(X, Y)
                                                  //> slope:1.1076266724381105 intercept:-26.031359356968892
                                                  //| slope:1.1076266724381105 intercept:-26.031359356968892
                                                  //| model  : (Double, Double) = (1.1076266724381105,-26.031359356968892)
                                                  //| slope  : Double = 1.1076266724381105
                                                  //| intercept  : Double = -26.031359356968892
  val predict = fitLine(model)_                   //> predict  : Double => Double = <function1>
  
  // Produce predicted outcomes from model based on observed input
  val predictions = for(x <- X) yield predict(x)  //> predictions  : breeze.linalg.DenseVector[Double] = DenseVector(213.548289891
                                                  //| 39443, 236.80845001259473, 257.29954345269977, 289.6422422878926, 302.601474
                                                  //| 3554185)
  // Compare via sum of squared residuals
  // Also prints lots of statistical diagnostics
  val SSE = sumSquaredResiduals(Y, predictions)   //> Jan 08, 2015 7:56:17 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader1149557262951868974netlib-native_system-osx-x86_64.jnilib
                                                  //| mean of redisuals: -1.1368683772161604E-14
                                                  //| SST: 5766.347999999996
                                                  //| SSR: 5396.447973505608
                                                  //| SST - (SSE + SSR): 4.547473508864641E-12
                                                  //| SSR/SST (r^2): 0.935851941905971
                                                  //| SSE  : Double = 369.90002649438367
  // Mean squared error. MSE is an unbiased estimate of the variance of the error term epsilon.
  val MSE = SSE / (Y.length - 2)                  //> MSE  : Double = 123.30000883146123
  // The square root of MSE is the standard error of the estimate, which is an unbiased estimate of the standard deviation of the error term epsilon.
  val s = sqrt(MSE)                               //> s  : Double = 11.104053711661397
  // Standard error of the estimated slope
	val SEb1 = s / pow(X - mean(X), 2).sum    //> SEb1  : Double = 0.002524412779428091
	// Using this statistic, it is possible to do a test of the null hypothesis that the population slope equals zero, that is, that there is no linear relationship between the variables x and y.
	slope / SEb1                              //> res0: Double = 438.7660692674218
	val SSR = pow(predictions - mean(Y), 2).sum
                                                  //> SSR  : Double = 5396.447973505608
  // With this statistic it is also possible to do a test of the null hypothesis, i.e. that there is no linear relationship between the variables x and y
	(SSR/1)/MSE                               //> res1: Double = 43.7668093023579
}