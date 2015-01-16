package lab.math.aleks.introstats

import breeze.linalg._

// mean of frequencies of birth weights
object Frequency_mean_lab_1_ws {
	val freq = List(4,9,14,8)                 //> freq  : List[Int] = List(4, 9, 14, 8)
	val weight = List(5,6,7,8)                //> weight  : List[Int] = List(5, 6, 7, 8)
	val comb = freq zip weight                //> comb  : List[(Int, Int)] = List((4,5), (9,6), (14,7), (8,8))
	
	val freqWeights = for(
		c <- comb
	) yield c._1 * c._2                       //> freqWeights  : List[Int] = List(20, 54, 98, 64)
	
	freqWeights.sum / freq.sum.toDouble       //> res0: Double = 6.742857142857143
	
	// ---------------------------------- //
	
	def valueFreqMean(vals: DenseVector[Double], freqs: DenseVector[Double]): Double = {
  		(freqs dot vals) / freqs.sum.toDouble
  }                                               //> valueFreqMean: (vals: breeze.linalg.DenseVector[Double], freqs: breeze.linal
                                                  //| g.DenseVector[Double])Double
  
  // ---------------------------------- //
	
	val freqVec = DenseVector(4d,9,14,8)      //> freqVec  : breeze.linalg.DenseVector[Double] = DenseVector(4.0, 9.0, 14.0, 8
                                                  //| .0)
	val weightVec = DenseVector(5d,6,7,8)     //> weightVec  : breeze.linalg.DenseVector[Double] = DenseVector(5.0, 6.0, 7.0, 
                                                  //| 8.0)
  valueFreqMean(weightVec, freqVec)               //> Jan 16, 2015 2:51:42 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader6795666809030839923netlib-native_system-osx-x86_64.jnilib
                                                  //| res1: Double = 6.742857142857143
}