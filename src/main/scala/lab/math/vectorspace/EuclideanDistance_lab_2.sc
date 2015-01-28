package lab.math.vectorspace

import lab.math.vectorspace.EuclideanLabBreeze2._
import breeze.linalg._
import breeze.numerics._

object EuclideanDistance_lab_2 {
	val A = DenseVector(3.0, 4.1, 4.8, 6.0)   //> A  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.1, 4.8, 6.0)
	A.sum                                     //> res0: Double = 17.9
	pow(A,2)                                  //> res1: breeze.linalg.DenseVector[Double] = DenseVector(9.0, 16.81, 23.04, 36.
                                                  //| 0)
	pow(A,2).sum                              //> res2: Double = 84.85
	sqrt(pow(A,2).sum)                        //> res3: Double = 9.211405973031479
	eucNorm(A)                                //> res4: Double = 9.211405973031479
	
	// ------------------------- //
	
	val B = DenseVector(3.6, 5.0, 6.3, 7.9)   //> B  : breeze.linalg.DenseVector[Double] = DenseVector(3.6, 5.0, 6.3, 7.9)
	B.sum                                     //> res5: Double = 22.799999999999997
	pow(B,2)                                  //> res6: breeze.linalg.DenseVector[Double] = DenseVector(12.96, 25.0, 39.69, 62
                                                  //| .410000000000004)
	pow(B,2).sum                              //> res7: Double = 140.06
	sqrt(pow(B,2).sum)                        //> res8: Double = 11.83469475736489
	eucNorm(B)                                //> res9: Double = 11.83469475736489
	
	// ------------------------- //
	
	// eucDist is correct: http://calculator.vhex.net/post/calculator-result/euclidean-distance
	
	val distance1 = abs(eucNorm(A) - eucNorm(B))
                                                  //> distance1  : Double = 2.623288784333411
	
	val distance2 = eucDist(A, B)             //> Jan 27, 2015 6:10:16 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader507080434728470611netlib-native_system-osx-x86_64.jnilib
                                                  //| distance2  : Double = 2.651414716712571
	
	distance1 == distance2                    //> res10: Boolean = false
	
	// ------------------------- //
	
	val C = DenseVector(2d,4,6,8,10,12,14,16) //> C  : breeze.linalg.DenseVector[Double] = DenseVector(2.0, 4.0, 6.0, 8.0, 10.
                                                  //| 0, 12.0, 14.0, 16.0)
	//val D = C * 10.1009
	val d = List(106d, 132, 89.3, 878.6, 36, 8, 317, 112.5).sorted
                                                  //> d  : List[Double] = List(8.0, 36.0, 89.3, 106.0, 112.5, 132.0, 317.0, 878.6)
                                                  //| 
	//val D = DenseVector(106d, 132, 89.3, 878.6, 36, 8, 317, 112.5)
  val D = DenseVector(d.toArray)                  //> D  : breeze.linalg.DenseVector[Double] = DenseVector(8.0, 36.0, 89.3, 106.0,
                                                  //|  112.5, 132.0, 317.0, 878.6)
  val distance3 = abs(eucNorm(D) - eucNorm(C))    //> distance3  : Double = 932.2036134398547
	
	val distance4 = eucDist(C, D)             //> distance4  : Double = 937.2283072976403
	
	distance3 == distance4                    //> res11: Boolean = false
	
	// ------------------------- //
	
	val distance5 = abs(eucNorm(D) - eucNorm(D))
                                                  //> distance5  : Double = 0.0
	
	val distance6 = eucDist(D, D)             //> distance6  : Double = 0.0
	
	distance5 == distance6                    //> res12: Boolean = true
	
	// ------------------------- //
	
	val E = DenseVector(2d, 4, 5, 5, 6)       //> E  : breeze.linalg.DenseVector[Double] = DenseVector(2.0, 4.0, 5.0, 5.0, 6.
                                                  //| 0)
	E.sum                                     //> res13: Double = 22.0
	norm(E)                                   //> res14: Double = 10.295630140987
	
	val F = DenseVector(1d, 3, 4, 6, 8)       //> F  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 3.0, 4.0, 6.0, 8.
                                                  //| 0)
  F.sum                                           //> res15: Double = 22.0
  norm(F)                                         //> res16: Double = 11.224972160321824
  
  val distance7 = abs(eucNorm(F) - eucNorm(E))    //> distance7  : Double = 0.9293420193348236
	
	val distance8 = eucDist(E, F)             //> distance8  : Double = 2.8284271247461903
	
	distance7 == distance8                    //> res17: Boolean = false
}
/*



*/