package lab.math.linear_algebra.Boyd_Vandenberghe.Ch_1_Vectors

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._
import scala.math._

object Vector_addition_1_2 {

  // Fig. 1.7

  val a = DenseVector(5, 1)                       //> a  : breeze.linalg.DenseVector[Int] = DenseVector(5, 1)
  val b = DenseVector(1, 3)                       //> b  : breeze.linalg.DenseVector[Int] = DenseVector(1, 3)
  val a_b = a + b // (6, 4)                       //> a_b  : breeze.linalg.DenseVector[Int] = DenseVector(6, 4)
  
  a_b - a                                         //> res0: breeze.linalg.DenseVector[Int] = DenseVector(1, 3)
  a_b - b                                         //> res1: breeze.linalg.DenseVector[Int] = DenseVector(5, 1)
  
  a - b                                           //> res2: breeze.linalg.DenseVector[Int] = DenseVector(4, -2)
  
  // Fig. 1.9
  
  val q = DenseVector(2, 4)                       //> q  : breeze.linalg.DenseVector[Int] = DenseVector(2, 4)
  val p = DenseVector(6, 2)                       //> p  : breeze.linalg.DenseVector[Int] = DenseVector(6, 2)
  //val q = DenseVector(-4, 2)
  //val p = DenseVector(4, -2)
  
  q - p                                           //> res3: breeze.linalg.DenseVector[Int] = DenseVector(-4, 2)
  p - q                                           //> res4: breeze.linalg.DenseVector[Int] = DenseVector(4, -2)
  q + p                                           //> res5: breeze.linalg.DenseVector[Int] = DenseVector(8, 6)
  

  '''                                             //> res6: Char('\'') = '
}