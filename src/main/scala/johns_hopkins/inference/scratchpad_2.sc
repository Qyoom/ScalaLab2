package scratchpad_NO_GIT

//import math._
import lab.math.Rounding_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.math._
import breeze.stats._

// WARNING: The correctness of anything on this page is highly suspect!!

object scratchpad_2 {
	val round = roundAt(3)_
	
  val XA = -4
  val XB = 1
  val pXA = -4 * .2
  val pXB = 1 * .8
  val mu = (pXA + pXB) / 2
  val XA_resid = XA - mu
  val XB_resid = XB - mu
  val varXA = math.pow(XA_resid, 2) * .2
  val varXB = math.pow(XB_resid, 2) * .8
  // Variance. This is just a total, no average
  val vari = (varXA + varXB)
  
  // ------------------------------------- //
  
  val x = DenseVector(2d,3,4,5)
  val p = DenseVector(.1, .2, .3, .4)
  
 	(x.map(x => pow(x,2)) :* p).sum - pow((x :* p).sum, 2)
                                                  
  // ------------------------------------- //
  
  val X = DenseVector(1.0,  2.0,  3.0,  4.0)
  val Prob = DenseVector(0.1,  0.2,  0.3,  0.4)
  (X :* Prob).sum
  X dot Prob
  
  // ----- Variance and Standard Deviation ------------- //
  
  val X_mean = X.sum / X.length
  mean(X)
  (X :- X_mean).sum
  X.map(x => (x - X_mean)).sum
  X :- X_mean
  X.map(x => (x - X_mean))
  X.map(x => pow(x - X_mean, 2))
  pow(X :- X_mean, 2)
  X.map(x => pow(x - X_mean, 2)).sum
  pow(X :- X_mean, 2).sum
  
  pow(X :- X_mean, 2).sum
  
  val empiricalVariance = pow(X :- X_mean, 2).sum / X.length - 1
  variance(X)
  // empirical standard deviation
  val empSD_X = sqrt(empiricalVariance)
  stddev(X)
  // The data defined by Xi/s have empirical standard deviation 1. This is called "scaling" the data.
	X :/ empSD_X
	
	// ----- Normalization ------------- //
	
	// The process of centering then scaling the data is called "normalizing" the data.
	// The data defined by
	val Z = 	(X :- X_mean) / empSD_X
	// have empirical mean zero and empirical standard deviation 1
	mean(Z)
	stddev(Z)
	
	// ----- Empirical Covariance ----------------- //
	
	val Y = DenseVector(1.7,  2.3,  3.8,  4.5)
	X - mean(X)
	(Y - mean(Y)).map(x => round(x))
	
  // Covariance
  val covXY = variance(X) * variance(Y)
  val coStDevXV = stddev(X) * stddev(Y)
  // Correlation
  covXY / coStDevXV
}
//
//
//
//
//