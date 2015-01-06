package lab.math.vectorspace

import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

import lab.math.vectorspace.GaltonData.galtonChild

object MeanSquaredError {

	// Test vectors
	val A = DenseVector(3.0, 4.1, 4.8, 6.0)   //> A  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.1, 4.8, 6.0)
	val B = DenseVector(3.6, 5.0, 6.3, 7.9)   //> B  : breeze.linalg.DenseVector[Double] = DenseVector(3.6, 5.0, 6.3, 7.9)
	val C = DenseVector(-3.6, -5.0, -6.3, -7.9)
                                                  //> C  : breeze.linalg.DenseVector[Double] = DenseVector(-3.6, -5.0, -6.3, -7.9)
                                                  //| 

	// ------ Mean squared error ------ //
  def mse(v: DenseVector[Double]): Double = {
  		mean(pow((v - mean(v)), 2))
  }                                               //> mse: (v: breeze.linalg.DenseVector[Double])Double
  
  mse(A)                                          //> res0: Double = 1.1868750000000001
  mse(B)                                          //> res1: Double = 2.5250000000000004
  mse(C)                                          //> res2: Double = 2.5250000000000004
  
 	mse(galtonChild)                          //> res3: Double = 6.333196796503433
 	
}