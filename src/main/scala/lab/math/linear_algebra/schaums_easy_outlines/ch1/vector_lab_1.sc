package lab.math.linear_algebra.schaums_easy_outlines.ch1

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._
import scala.math._

object vector_lab_1 {
	// (x - y, x + y, z - 1) = (4, 2, 3)
	// x - y = 4 // 3 - (-1)
	// x + y = 2 // 3 + (-1)
	// z - 1 = 3 // z = 4
	val z = 4                                 //> z  : Int = 4
	
	val u = DenseVector(1d,2,3)               //> u  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 3.0)
	u                                         //> res0: breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 3.0)
	-u                                        //> Feb 21, 2015 12:42:45 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader1431387766571247613netlib-native_system-osx-x86_64.jnilib
                                                  //| res1: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, -2.0, -3.0)
	
	// 3 * u // not supported
	u * 3d                                    //> res2: breeze.linalg.DenseVector[Double] = DenseVector(3.0, 6.0, 9.0)
	
	// linear combination
	val u1 = DenseVector(1d,2,3)              //> u1  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 3.0)
	val u2 = DenseVector(2d,3,4)              //> u2  : breeze.linalg.DenseVector[Double] = DenseVector(2.0, 3.0, 4.0)
	val u3 = DenseVector(3d,4,5)              //> u3  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.0, 5.0)
	val k1 = 1d                               //> k1  : Double = 1.0
	val k2 = 2d                               //> k2  : Double = 2.0
	val k3 = 3d                               //> k3  : Double = 3.0
	u1*k1 + u2*k2 + u3*k3                     //> res3: breeze.linalg.DenseVector[Double] = DenseVector(14.0, 20.0, 26.0)
	
	// orthogonal
	val v1 = DenseVector(1d, -2, 3)           //> v1  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, -2.0, 3.0)
	val v2 = DenseVector(2d, 7, 4)            //> v2  : breeze.linalg.DenseVector[Double] = DenseVector(2.0, 7.0, 4.0)
	v1 dot v2                                 //> res4: Double = 0.0
	
	// Theorem 1.2
	(u1 + u2) dot u3                          //> res5: Double = 64.0
	(u1 dot u3) + (u2 dot u3)                 //> res6: Double = 64.0
	((u1 + u2) dot u3) == ((u1 dot u3) + (u2 dot u3))
                                                  //> res7: Boolean = true
	64 == 64                                  //> res8: Boolean(true) = true
	
	norm(u3)                                  //> res9: Double = 7.0710678118654755
	eucNorm(u3)                               //> res10: Double = 7.0710678118654755
	
	val v = DenseVector(1d, -2, -4, 5, 3)     //> v  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, -2.0, -4.0, 5.0, 3
                                                  //| .0)
  // Normalizing. v_unit is the unique unit vector in the same direction as v
	val v_unit = v./(norm(v))                 //> v_unit  : breeze.linalg.DenseVector[Double] = DenseVector(0.1348399724926484
                                                  //| 2, -0.26967994498529685, -0.5393598899705937, 0.674199862463242, 0.404519917
                                                  //| 47794525)
	norm(v_unit)                              //> res11: Double = 1.0
	
	// Cauchy-Schwarz inequality
	norm(u2) * norm(u3)                       //> res12: Double = 38.07886552931954
	u2 dot u3                                 //> res13: Double = 38.0
	abs(u2 dot u3) <= (norm(u2) * norm(u3))   //> res14: Boolean = true
	
	val u4 = DenseVector(1.5, 2,6, 3.7, 2, 1.9, 11, 5.3, 7.9)
                                                  //> u4  : breeze.linalg.DenseVector[Double] = DenseVector(1.5, 2.0, 6.0, 3.7, 2
                                                  //| .0, 1.9, 11.0, 5.3, 7.9)
	val u5 = DenseVector(7.3, 2.5, 7.1, 2.9, 8.6, 1, 1.2, 3, 3.4)
                                                  //> u5  : breeze.linalg.DenseVector[Double] = DenseVector(7.3, 2.5, 7.1, 2.9, 8
                                                  //| .6, 1.0, 1.2, 3.0, 3.4)
	u4 dot u5                                 //> res15: Double = 144.33999999999997
	norm(u4) * norm(u5)                       //> res16: Double = 243.35933514044618
	abs(u4 dot u5) <= (norm(u4) * norm(u5))   //> res17: Boolean = true
	
	// Triangle inequality or Minkowski inequality
	norm(u4 + u5)                             //> res18: Double = 27.91146717748818
	norm(u4) + norm(u5)                       //> res19: Double = 31.258417590800917
	norm(u4 + u5) <= norm(u4) + norm(u5)      //> res20: Boolean = true
}
/*



*/