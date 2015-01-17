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
  valueFreqMean(weightVec, freqVec)               //> Jan 16, 2015 3:04:42 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader524720447977885598netlib-native_system-osx-x86_64.jnilib
                                                  //| res1: Double = 6.742857142857143
  val students = DenseVector(6d,10,15)            //> students  : breeze.linalg.DenseVector[Double] = DenseVector(6.0, 10.0, 15.0)
                                                  //| 
	val books = DenseVector(1d,3,4)           //> books  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 3.0, 4.0)
	valueFreqMean(books, students)            //> res2: Double = 3.096774193548387
	
	val families = DenseVector(6d,10,14,7)    //> families  : breeze.linalg.DenseVector[Double] = DenseVector(6.0, 10.0, 14.0,
                                                  //|  7.0)
	val milk = DenseVector(3d,4,7,6)          //> milk  : breeze.linalg.DenseVector[Double] = DenseVector(3.0, 4.0, 7.0, 6.0)
	valueFreqMean(milk, families)             //> res3: Double = 5.351351351351352
	
	val computers = DenseVector(7d,12,3)      //> computers  : breeze.linalg.DenseVector[Double] = DenseVector(7.0, 12.0, 3.0)
                                                  //| 
	val price = DenseVector(2050d,1600,2700)  //> price  : breeze.linalg.DenseVector[Double] = DenseVector(2050.0, 1600.0, 270
                                                  //| 0.0)
	valueFreqMean(price, computers)           //> res4: Double = 1893.1818181818182
	
	val numChildren = DenseVector(0d,2,3,1)   //> numChildren  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 2.0, 3.
                                                  //| 0, 1.0)
	val numHouseholds = DenseVector(8d,11,13,4)
                                                  //> numHouseholds  : breeze.linalg.DenseVector[Double] = DenseVector(8.0, 11.0,
                                                  //|  13.0, 4.0)
	valueFreqMean(numChildren, numHouseholds) //> res5: Double = 1.8055555555555556
}
/*



*/