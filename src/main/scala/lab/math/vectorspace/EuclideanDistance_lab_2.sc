package lab.math.vectorspace

import lab.math.vectorspace.EuclideanLabBreeze2._
import breeze.linalg._
import breeze.numerics._
 
object EuclideanDistance_lab_2 {
	val A = DenseVector(3.0, 4.1, 4.8, 6.0)
	A.sum
	pow(A,2)
	pow(A,2).sum
	sqrt(pow(A,2).sum)
	eucNorm(A)
	
	// ------------------------- //
	
	val B = DenseVector(3.6, 5.0, 6.3, 7.9)
	B.sum
	pow(B,2)
	pow(B,2).sum
	sqrt(pow(B,2).sum)
	eucNorm(B)
	
	// ------------------------- //
	
	// eucDist is correct: http://calculator.vhex.net/post/calculator-result/euclidean-distance
	
	val distance1 = abs(eucNorm(A) - eucNorm(B))
	
	val distance2 = eucDist(A, B)
	
	distance1 == distance2
	
	// ------------------------- //
	
	val C = DenseVector(2d,4,6,8,10,12,14,16)
	//val D = C * 10.1009
	val d = List(106d, 132, 89.3, 878.6, 36, 8, 317, 112.5).sorted
	//val D = DenseVector(106d, 132, 89.3, 878.6, 36, 8, 317, 112.5)
  val D = DenseVector(d.toArray)
  val distance3 = abs(eucNorm(D) - eucNorm(C))
	
	val distance4 = eucDist(C, D)
	
	distance3 == distance4
	
	// ------------------------- //
	
	val distance5 = abs(eucNorm(D) - eucNorm(D))
	
	val distance6 = eucDist(D, D)
	
	distance5 == distance6
	
	// ------------------------- //
	
	val E = DenseVector(2d, 4, 5, 5, 6)
	E.sum
	norm(E)
	
	val F = DenseVector(1d, 3, 4, 6, 8)
  F.sum
  norm(F)
  
  val distance7 = abs(eucNorm(F) - eucNorm(E))
	
	val distance8 = eucDist(E, F)
	
	distance7 == distance8
}
/*



*/