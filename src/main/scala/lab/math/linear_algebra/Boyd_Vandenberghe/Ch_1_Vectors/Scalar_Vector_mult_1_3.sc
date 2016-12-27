package lab.math.linear_algebra.Boyd_Vandenberghe.Ch_1_Vectors

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._
import scala.math._

object Scalar_Vector_mult_1_3 {

  DenseVector(1, 9, 6) :* -2                      //> res0: breeze.linalg.DenseVector[Int] = DenseVector(-2, -18, -12)
  
  // Note here how d is required for both sides
  DenseVector(1d, 9, 6) :* -2d                    //> Dec 25, 2016 5:17:59 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader2602868367276307508netlib-native_system-osx-x86_64.jnilib
                                                  //| res1: breeze.linalg.DenseVector[Double] = DenseVector(-2.0, -18.0, -12.0)
  DenseVector(1d, 9, 6) :* 0d                     //> res2: breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0)
  
  DenseVector(1, 9, 6) :/ 2                       //> res3: breeze.linalg.DenseVector[Int] = DenseVector(0, 4, 3)
  
  DenseVector(1d, 9, 6) :/ 2d                     //> res4: breeze.linalg.DenseVector[Double] = DenseVector(0.5, 4.5, 3.0)
  
  DenseVector(1d, 9, 6) :/ -2d                    //> res5: breeze.linalg.DenseVector[Double] = DenseVector(-0.5, -4.5, -3.0)
  
  -DenseVector(1d, 9, 6) :/ -2d                   //> res6: breeze.linalg.DenseVector[Double] = DenseVector(0.5, 4.5, 3.0)
  
  -DenseVector(1d, 9, 6) :/ 2d                    //> res7: breeze.linalg.DenseVector[Double] = DenseVector(-0.5, -4.5, -3.0)
  
  // Associative Property ///////////////////////
  
  val v1 = DenseVector(2, 3, 4)                   //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(2, 3, 4)
  val v2 = DenseVector(5, 6, 7)                   //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(5, 6, 7)
  
  (v1 :* 2) :* 3 == v1 :* (2 * 3)                 //> res8: Boolean = true
  
  // Distributive Property /////////////////////
  
  (v1 :* 2) + (v1 :* 3) == v1 :* (2 + 3)          //> res9: Boolean = true
  
  (v1 :+ v2) :* 3 == (v1 :* 3) :+ (v2 :* 3)       //> res10: Boolean = true
    
  ////////////////////////////////////////////////////////////////////
  // Note this weirdness about 1 == 1 == 1 // This is a no no in Scala

  (v1 :* 2) :* 3 == v1 :* (2 * 3) == v1 :* 2 * 3  //> res11: Boolean = false
  
  (v1 :* 2) :* 3                                  //> res12: breeze.linalg.DenseVector[Int] = DenseVector(12, 18, 24)
  
  v1 :* 2 * 3                                     //> res13: breeze.linalg.DenseVector[Int] = DenseVector(12, 18, 24)
  
  (v1 :* 2) :* 3 == v1 :* 2 * 3                   //> res14: Boolean = true
  
  1.5 == 1.5                                      //> res15: Boolean(true) = true
  
  1.5 == 1.5 == 1.5                               //> res16: Boolean = false
  
  ((v1 :* 2) :* 3 == v1 :* (2 * 3)) == (v1 :* 2 * 3)
                                                  //> res17: Boolean = false
  
  ((v1 :* 2) :* 3 == v1 :* (2 * 3))               //> res18: Boolean = true
  (v1 :* 2 * 3)                                   //> res19: breeze.linalg.DenseVector[Int] = DenseVector(12, 18, 24)
  ////////////////////////////////////////////////////////////////////
  
  '''                                             //> res20: Char('\'') = '
}