package lab.math

import lab.math.EuclideanLab1.eucDist
import lab.math.EuclideanLabBreeze2.eucDist
import breeze.linalg._
import breeze.numerics._

object EuclideanDistance_lab_1 {
  val A = List(3.0, 4.1, 4.8, 6.0)                //> A  : List[Double] = List(3.0, 4.1, 4.8, 6.0)
	val B = List(3.6, 5.0, 6.3, 7.9)          //> B  : List[Double] = List(3.6, 5.0, 6.3, 7.9)
	val C = List(5d, 1d)                      //> C  : List[Double] = List(5.0, 1.0)
	val D = List(1d, -2d)                     //> D  : List[Double] = List(1.0, -2.0)
	EuclideanLab1.eucDist(A, B)               //> res0: Double = 2.651414716712571
	EuclideanLab1.eucDist(C, D)               //> res1: Double = 5.0
	
	val X1 = DenseVector(0d,2d,0d,0d,-1d,1d)  //> X1  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 2.0, 0.0, 0.0, -1
                                                  //| .0, 1.0)
	val X2 = DenseVector(3d,0d,1d,1d,0d,1d)   //> X2  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 0.0, 1.0, 1.0, 0.
                                                  //| 0, 1.0)
	val X3 = DenseVector(0d,0d,3d,2d,1d,1d)   //> X3  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 3.0, 2.0, 1.
                                                  //| 0, 1.0)
	val zeros = DenseVector(0d,0d,0d,0d,0d,0d)//> zeros  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0, 0.0,
                                                  //|  0.0, 0.0)
	
	EuclideanLabBreeze2.eucDist(X1, zeros)    //> Nov 25, 2014 5:28:03 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader5582679445945432928netlib-native_system-osx-x86_64.jnilib
                                                  //| res2: Double = 2.449489742783178
	EuclideanLabBreeze2.eucDist(X2, zeros)    //> res3: Double = 3.4641016151377544
	EuclideanLabBreeze2.eucDist(X3, zeros)    //> res4: Double = 3.872983346207417
	
}