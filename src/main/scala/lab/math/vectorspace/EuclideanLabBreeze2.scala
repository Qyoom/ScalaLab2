package lab.math.vectorspace

//import math._
import lab.math.NthRoot._
import breeze.linalg._
import breeze.numerics._

object EuclideanLabBreeze2 extends App {
  
	// Test vectors
	val A = DenseVector(3.0, 4.1, 4.8, 6.0)
	val B = DenseVector(3.6, 5.0, 6.3, 7.9)
	val C = DenseVector(-3.6, -5.0, -6.3, -7.9)
	
	///// Computes Euclidean distance ////////////////////////////////////////
	def eucDist(X: DenseVector[Double], Y: DenseVector[Double]): Double = {
  		require(X.length == Y.length)
  		// square root of the sum of the squared difference
  		// See Neural Networks and Learning Machines (3rd Edition).pdf, p.23
  		sqrt(pow(X - Y, 2).sum)
	}
	
	//.. tests .................................//
	
	val res1 = eucDist(A, B)
	println("res1: " + res1) // 2.651414716712571
	
	val res2 = eucDist(A, C)
	println("res2: " + res2)

	///// Computes Euclidean norm (i.e. Euclidean length) ////////////////////////////////////
	def eucNorm(X: DenseVector[Double]): Double = {
		// square root of the sum of the squared elements. Pathagorean theorem.
		sqrt(pow(X, 2).sum)
	}
	
	//.. tests .........................//
	
	val res3 = eucNorm(A)
	println("res3: " + res3) // 9.211405973031479
	
	val res4 = eucNorm(C)
	println("res4: " + res4) // 11.83469475736489
	
	println("res4b: " + eucNorm(DenseVector(1/2d, 1/2d, 1/2d, 1/2d)))
	println("res4c: " + eucNorm(DenseVector(1,-2,2)))
	
	// Breeze, built in norm
	println("norm(A): " + norm(A)) // identical to eucNorm here
	println("norm(C): " + norm(C))
	
	///// Minkowski norm /////////////////////////////////////////////
	// Regularizer?
	
	def minkNorm(X0: DenseVector[Double], n: Int): Double = {
		val X1 = if(n % 2 == 0) X0 else X0.map(x => abs(x)) // TODO: This seems heavy
		nthRoot(pow(X1, n).sum, n)
	}
	
	//.. tests ......................//
	
	println("res5: " + minkNorm(A, 3))
	println("res6: " + minkNorm(A, 4))
	println("res7: " + minkNorm(A, 5))
	println("res8: " + minkNorm(A, 11))
	println("res9: " + minkNorm(A, 50))
	println("res10: " + minkNorm(A, 100))
	
	println("res11: " + minkNorm(C, 3))
	println("res11.5: " + minkNorm(C, 100))
	println("res12: " + minkNorm(B, 3))
	
}
