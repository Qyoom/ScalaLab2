package lab.math

import math._

import lab.math.NthRoot._

object EuclideanLab1 extends App {
 
	/* Length of a vector: You square each of the coordinates, and add up all 
  	 * those squares; then take the square root of that sum. 
  	 * --Goldsmith, U of Chicago (see ppt).
  	 * https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0CB4QFjAA&url=http%3A%2F%2Fhum.uchicago.edu%2Ffaculty%2Fgoldsmith%2FCogSciCourse%2Fpowerpoint%2Fn-space.ppt&ei=KrtzVPfhE8j1iQKuvIDQBg&usg=AFQjCNELPtfLS4XQw8auGB-PjV_663IvYg&bvm=bv.80185997,d.cGE
  	 */
  
	// Euclidean Distance ///////////////////////////////////////////////////
  
	/* From Wikipedia/Euclidean_vector
	 * Mathematically, a vector x in an n-dimensional Euclidean space can be defined
  	 * as an ordered list of n real numbers (the Cartesian coordinates of P):
  	 * x = [x1, x2, ..., xn]. Its magnitude or length is most commonly defined as
  	 * its Euclidean norm (or Euclidean length).
  	 */
	// Computes Euclidean distance
	def eucDist(X: List[Double], Y: List[Double]): Double = {
  		require(X.length == X.length)
  		val coords = X zip Y
  		val sqrdDiffs = for {
  		    tup <- coords
  		    diff = tup._1 - tup._2
  		    sqr = diff * diff
  		} yield sqr
  		//println("diffs: " + sqrdDiffs)
  		val sum = sqrdDiffs.foldRight(0.0)(_ + _)
  		//println("sum: " + sum)
  		sqrt(sum)  
	}
	
	//...................................//
	
	val A = List(3.0, 4.1, 4.8, 6.0)
	val B = List(3.6, 5.0, 6.3, 7.9)
	val C = List(-3.6, -5.0, -6.3, -7.9)
	val D = List(-3.6, -7.9, -5.0, -6.3)
	
	val res1 = eucDist(A, B)
	println("res1: " + res1) // 2.651414716712571
	
	val res2 = eucDist(A, C)
	println("res2: " + res2)
	
	// Euclidean norm //////////////////////////////////////////////////
	
	/* Wikipedia/Euclidean_distance
	 * The Euclidean norm, or Euclidean length, or magnitude of a vector 
	 * measures the length of the vector
	 */
	// Computes Euclidean norm
	def eucNorm(xs: List[Double]): Double = {
		// inner tail recursion
		def inter(xs: List[Double], accum: Double): Double = {
			xs match {
			  	case Nil => accum
			  	case x :: xs => {
			  		inter(xs, accum + (x*x)) // tail recursion
			  	}
			}
		}
		sqrt(inter(xs, 0.0)) // square root of the sum of squared differences
	}
	
	//...........................//
	
	val res3 = eucNorm(A)
	println("res3: " + res3)
	
	val res4 = eucNorm(C)
	println("res4: " + res4)
	
	// Minkowski norm /////////////////////////////////////////////
	
	def minkNorm(xs: List[Double], n: Int): Double = {
		def inter(xs: List[Double], accum: Double): Double = {
			xs match {
			  	case Nil => accum
			  	case x :: xs => {
			  		inter(xs, accum + pow(abs(x), n)) // tail recursion
			  	}
			}
		}
		nthRoot(inter(xs, 0.0), n)
	}
	
	//........................//
	
	println("res5: " + minkNorm(A, 3))
	println("res6: " + minkNorm(A, 4))
	println("res7: " + minkNorm(A, 5))
	println("res8: " + minkNorm(A, 11))
	println("res9: " + minkNorm(A, 50))
	println("res10: " + minkNorm(A, 100))
	
	println("res11: " + minkNorm(C, 3))
	println("res11.1: " + minkNorm(C, 100))
	println("res11.2: " + minkNorm(D, 100))
	println("res12: " + minkNorm(B, 3))
}

