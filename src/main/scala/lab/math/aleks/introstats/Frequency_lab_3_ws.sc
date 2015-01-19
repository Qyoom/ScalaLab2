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
  
  val ratingFreq = List(4d,7,14,15,6,4)           //> ratingFreq  : List[Double] = List(4.0, 7.0, 14.0, 15.0, 6.0, 4.0)
  ogive(ratingFreq)                               //> res0: List[Double] = List(0.08, 0.22, 0.5, 0.8, 0.92, 1.0)
  
  /*
  val houseSales = List(4d,4,6,4,2)
  ogive(houseSales)
  val weights = List(7d, 7, 12, 10, 8, 6)
  ogive(weights)
  val months = List(5d,9,7,3,1)
  ogive(months)
  */
}
/*



*/