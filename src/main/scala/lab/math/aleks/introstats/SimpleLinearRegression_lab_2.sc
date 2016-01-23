package lab.math.aleks.introstats

import lab.math.vectorspace.SimpleLinearRegression_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object SimpleLinearRegression_lab_2 {

	val X = DenseVector(216.3, 237.3, 255.8, 285.0, 296.7)
	val Y = DenseVector(210.9, 245.1, 247.1, 301.4, 295.4)
  // Referencing www.Aleks.com "Simple linear regression" for statistical formulas
  
  // Derive the model from observations
  val model, (slope, intercept) = deriveModel(X, Y)
  val predict = fitLine(model)_
  
  // Produce predicted outcomes from model based on observed input
  val predictions = for(x <- X) yield predict(x)
  // Compare via sum of squared residuals
  // Also prints lots of statistical diagnostics
  val SSE = sumSquaredResiduals(Y, predictions)
  diagnosticLog(Y, predictions)
  // Mean squared error. MSE is an unbiased estimate of the variance of the error term epsilon.
  val MSE = SSE / (Y.length - 2)
  // The square root of MSE is the standard error of the estimate, which is an unbiased estimate of the standard deviation of the error term epsilon.
  val s = sqrt(MSE)
  // Standard error of the estimated slope
	val SEb1 = s / pow(X - mean(X), 2).sum
	// Using this statistic, it is possible to do a test of the null hypothesis that the population slope equals zero, that is, that there is no linear relationship between the variables x and y.
	val t = slope / SEb1
	val SSR = pow(predictions - mean(Y), 2).sum
  // With this statistic it is also possible to do a test of the null hypothesis, i.e. that there is no linear relationship between the variables x and y
	(SSR/1)/MSE
}
/*


*/