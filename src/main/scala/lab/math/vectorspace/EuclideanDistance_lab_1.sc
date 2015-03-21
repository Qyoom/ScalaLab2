package lab.math.vectorspace

import lab.math.vectorspace.EuclideanLabBreeze2._
import breeze.linalg._
//import breeze.numerics._

object EuclideanDistance_lab_1 {
  val A = List(3.0, 4.1, 4.8, 6.0)
	val B = List(3.6, 5.0, 6.3, 7.9)
	val C = List(5d, 1d)
	val D = List(1d, -2d)
	lab.math.EuclideanLab1.eucDist(A, B)
	lab.math.EuclideanLab1.eucDist(C, D)
	
	val X1 = DenseVector(0d,2d,0d,0d,-1d,1d)
	val X2 = DenseVector(3d,0d,1d,1d,0d,1d)
	val X3 = DenseVector(0d,0d,3d,2d,1d,1d)
	val zeros = DenseVector(0d,0d,0d,0d,0d,0d)
	val Av = DenseVector(3.0, 4.1, 4.8, 6.0)
	val Bv = DenseVector(3.6, 5.0, 6.3, 7.9)
	
	eucDist(X1, zeros)
	eucDist(X2, zeros)
	eucDist(X3, zeros)
	

                                                  
	
}