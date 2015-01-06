package lab.math.vectorspace

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._

object VectorSimilarity_lab {

	// --------- Vector Similarity ---------------- //
	// See "Neural Networks and Learning Machines" p. 27 (print).
	// The inner (dot) product of (Av, Bv) divided by the product |Av| * |Bv|
	// is the cosine of the angle subtended between the vectors Av and Bv.
	// Also see: http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=geometry1
	
	val Av = DenseVector(3.0, 4.1, 4.8, 6.0)  //> Av  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.1, 4.8, 6.0)
	val Bv = DenseVector(3.6, 5.0, 6.3, 7.9)  //> Bv  : breeze.linalg.DenseVector[Double] = DenseVector(3.6, 5.0, 6.3, 7.9)
	
	
	eucDist(Av, Bv)                           //> Jan 05, 2015 9:30:55 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader6483619679517441160netlib-native_system-osx-x86_64.jnilib
                                                  //| res0: Double = 2.651414716712571
	Av dot Bv                                 //> res1: Double = 108.94
	eucNorm(Av)                               //> res2: Double = 9.211405973031479
	eucNorm(Bv)                               //> res3: Double = 11.83469475736489
	eucNorm(Av) * eucNorm(Bv)                 //> res4: Double = 109.01417797699527
	
	// Vector Similarity
	val cosineAvBv = (Av dot Bv) / (eucNorm(Av) * eucNorm(Bv))
                                                  //> cosineAvBv  : Double = 0.9993195566083989
}