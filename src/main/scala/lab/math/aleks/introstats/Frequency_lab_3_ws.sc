package lab.math.aleks.introstats

import lab.math.Rounding_lab_1._
 
object Frequency_lab_3_ws {
	val round = roundAt(3)_                   //> round  : Double => Double = <function1>
  
  // Cumulative Relative Frequency
  def ogive(X: List[Double]): List[Double] = {
  		val total = X.sum
  		// Recursive
		def inter(X: List[Double], cumRelFreqSeq: List[Double]): List[Double] = {
	  		X match {
	  			case Nil => cumRelFreqSeq.reverse
	  			case x :: xs => {
	  				val relFreq = x/total // series of relative frequencies accumulate to 1
	  				val cumRelFreq = if(cumRelFreqSeq != Nil) {
	  					round(relFreq + cumRelFreqSeq.head)
	  				} else relFreq
	  				inter(xs, cumRelFreq :: cumRelFreqSeq)
	  			}
	  		}
	  	}
	  	// Call recursion
	  	inter(X, List[Double]())
  }                                               //> ogive: (X: List[Double])List[Double]
  
  val houseSales = List(4d,4,6,4,2)               //> houseSales  : List[Double] = List(4.0, 4.0, 6.0, 4.0, 2.0)
  ogive(houseSales)                               //> res0: List[Double] = List(0.2, 0.4, 0.7, 0.9, 1.0)
  val weights = List(7d, 7, 12, 10, 8, 6)         //> weights  : List[Double] = List(7.0, 7.0, 12.0, 10.0, 8.0, 6.0)
  ogive(weights)                                  //> res1: List[Double] = List(0.14, 0.28, 0.52, 0.72, 0.88, 1.0)
  val months = List(5d,9,7,3,1)                   //> months  : List[Double] = List(5.0, 9.0, 7.0, 3.0, 1.0)
  ogive(months)                                   //> res2: List[Double] = List(0.2, 0.56, 0.84, 0.96, 1.0)
}