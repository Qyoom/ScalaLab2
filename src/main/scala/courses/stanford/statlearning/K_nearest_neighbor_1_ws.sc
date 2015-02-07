package courses.stanford.statlearning

import breeze.linalg._
import breeze.numerics._
import lab.math.vectorspace.EuclideanLabBreeze2._

object K_nearest_neighbor_1_ws {
	// An Introduction to Statistical Learning ORIG.pdf p.53

	val X1 = DenseVector(0d,2,0,0,-1,1)       //> X1  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 2.0, 0.0, 0.0, -1
                                                  //| .0, 1.0)
	val X2 = DenseVector(3d,0,1,1,0,1)        //> X2  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 0.0, 1.0, 1.0, 0.
                                                  //| 0, 1.0)
	val X3 = DenseVector(0d,0,3,2,1,1)        //> X3  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 3.0, 2.0, 1.
                                                  //| 0, 1.0)
	
	val testPoint = DenseVector(0d, 0d, 0d)   //> testPoint  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0)
	
	val X1_norm = norm(X1)                    //> X1_norm  : Double = 2.449489742783178
	val X2_norm = norm(X2)                    //> X2_norm  : Double = 3.4641016151377544
	val X3_norm = norm(X3)                    //> X3_norm  : Double = 3.872983346207417
	
	// -------------------------------- //
	
	val X_mat_A = DenseMatrix((0d,2d,0d,0d,-1d,1d), (3d,0d,1d,1d,0d,1d), (0d,0d,3d,2d,1d,1d)).t
                                                  //> X_mat_A  : breeze.linalg.DenseMatrix[Double] = 0.0   3.0  0.0  
                                                  //| 2.0   0.0  0.0  
                                                  //| 0.0   1.0  3.0  
                                                  //| 0.0   1.0  2.0  
                                                  //| -1.0  0.0  1.0  
                                                  //| 1.0   1.0  1.0  
	
	X_mat_A                                   //> res0: breeze.linalg.DenseMatrix[Double] = 0.0   3.0  0.0  
                                                  //| 2.0   0.0  0.0  
                                                  //| 0.0   1.0  3.0  
                                                  //| 0.0   1.0  2.0  
                                                  //| -1.0  0.0  1.0  
                                                  //| 1.0   1.0  1.0  
  // matrix dimensions
	(X_mat_A.rows, X_mat_A.cols)              //> res1: (Int, Int) = (6,3)
	X_mat_A(::,1)                             //> res2: breeze.linalg.DenseVector[Double] = DenseVector(3.0, 0.0, 1.0, 1.0, 0.
                                                  //| 0, 1.0)
	
  // column vector
	X_mat_A(::,1)                             //> res3: breeze.linalg.DenseVector[Double] = DenseVector(3.0, 0.0, 1.0, 1.0, 0.
                                                  //| 0, 1.0)
  // Using Breeze Broadcasting
  
  // sum each column
	sum(X_mat_A(::, *))                       //> res4: breeze.linalg.DenseMatrix[Double] = 2.0  6.0  7.0  
	
	// norm each row
	norm(X_mat_A(*,::))                       //> res5: breeze.linalg.DenseVector[Double] = DenseVector(3.0, 2.0, 3.1622776601
                                                  //| 683795, 2.23606797749979, 1.4142135623730951, 1.7320508075688772)
	// euclidean distance
  for(v <- X_mat_A(*,::)) yield eucDist(v, testPoint)
                                                  //> Feb 07, 2015 1:23:50 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader1281677575783985213netlib-native_system-osx-x86_64.jnilib
                                                  //| res6: breeze.linalg.DenseVector[Double] = DenseVector(3.0, 2.0, 3.1622776601
                                                  //| 683795, 2.23606797749979, 1.4142135623730951, 1.7320508075688772)
	

}