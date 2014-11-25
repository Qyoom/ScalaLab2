package lab.math

import lab.math.EuclideanLab1.eucDist

object EuclideanDistance_lab_1 {
  val A = List(3.0, 4.1, 4.8, 6.0)                //> A  : List[Double] = List(3.0, 4.1, 4.8, 6.0)
	val B = List(3.6, 5.0, 6.3, 7.9)          //> B  : List[Double] = List(3.6, 5.0, 6.3, 7.9)
	val C = List(5d, 1d)                      //> C  : List[Double] = List(5.0, 1.0)
	val D = List(1d, -2d)                     //> D  : List[Double] = List(1.0, -2.0)
	eucDist(A, B)                             //> res0: Double = 2.651414716712571
	eucDist(C, D)                             //> res1: Double = 5.0
	
}