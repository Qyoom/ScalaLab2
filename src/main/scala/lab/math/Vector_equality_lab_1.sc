package lab.math

import breeze.linalg._

object Vector_equality_lab_1 {
  
  val a1 = DenseVector(2,4)                       //> a1  : breeze.linalg.DenseVector[Int] = DenseVector(2, 4)
  val a2 = DenseVector(4,8)                       //> a2  : breeze.linalg.DenseVector[Int] = DenseVector(4, 8)
  val b1	 = DenseVector(3,5)               //> b1  : breeze.linalg.DenseVector[Int] = DenseVector(3, 5)
  val b2 = DenseVector(5,9)                       //> b2  : breeze.linalg.DenseVector[Int] = DenseVector(5, 9)
  val b3 = DenseVector(6,9)                       //> b3  : breeze.linalg.DenseVector[Int] = DenseVector(6, 9)
   
	(a2 - a1) == (b2 - b1)                    //> res0: Boolean = true
	(a2 - a1) == (b2 - b3)                    //> res1: Boolean = false
	
	val a3 = DenseVector(0,0,0)               //> a3  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
	val a4 = DenseVector(1,-1,2)              //> a4  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
	val b4 = DenseVector(1,1,-2)              //> b4  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, -2)
	val b5 = DenseVector(0,2,-4)              //> b5  : breeze.linalg.DenseVector[Int] = DenseVector(0, 2, -4)
	(b4 - b5) == (a3 - a4)                    //> res2: Boolean = false
	
}