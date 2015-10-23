package lab.math.vectorspace

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._
import spire.algebra.ReversedOrder

object VectorSimilarity_lab {

	// --------- Vector Similarity ---------------- //
	// See "Neural Networks and Learning Machines" p. 27 (print).
	// The inner (dot) product of (Av, Bv) divided by the product |Av| * |Bv|
	// is the cosine of the angle subtended between the vectors Av and Bv.
	// Also see: http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=geometry1
	
	val Av = DenseVector(3.0, 4.1, 4.8, 6.0)  //> Av  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.1, 4.8, 6.0)
	val Bv = DenseVector(3.6, 5.0, 6.3, 7.9)  //> Bv  : breeze.linalg.DenseVector[Double] = DenseVector(3.6, 5.0, 6.3, 7.9)
	val Cv = DenseVector(1.1, 5.7, 0.0, 12.8) //> Cv  : breeze.linalg.DenseVector[Double] = DenseVector(1.1, 5.7, 0.0, 12.8)
	val Dv = DenseVector(0.0, 1.1, 0.0, 32.4) //> Dv  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 1.1, 0.0, 32.4)
	
	
	eucDist(Av, Bv)                           //> Jun 25, 2015 5:53:00 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader3935235814455411902netlib-native_system-osx-x86_64.jnilib
                                                  //| res0: Double = 2.651414716712571
	Av dot Bv                                 //> res1: Double = 108.94
	eucNorm(Av)                               //> res2: Double = 9.211405973031479
	norm(Av) // Breeze, same                  //> res3: Double = 9.211405973031479
	eucNorm(Bv)                               //> res4: Double = 11.83469475736489
	Bv.norm()                                 //> res5: Double = 11.83469475736489
	eucNorm(Av) * eucNorm(Bv)                 //> res6: Double = 109.01417797699527
	
	// Vector Similarity
	val cosineAvBv = (Av dot Bv) / (eucNorm(Av) * eucNorm(Bv))
                                                  //> cosineAvBv  : Double = 0.9993195566083989
	(Av dot Bv) / (Av.norm() * Bv.norm())     //> res7: Double = 0.9993195566083989
	
	val cosineAvCv = (Av dot Cv) / (eucNorm(Av) * eucNorm(Cv))
                                                  //> cosineAvCv  : Double = 0.79921016883338
	
	val cosineAvDv = (Av dot Dv) / (eucNorm(Av) * eucNorm(Dv))
                                                  //> cosineAvDv  : Double = 0.666094019599112
}
/*



*/