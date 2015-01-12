package lab.math.aleks.introstats

import lab.math.Rounding_lab_1._

object Frequency_lab_3_ws {
	val round = roundAt(3)_                   //> round  : Double => Double = <function1>
  
  def ogive(X: List[Double]): List[Double] = {
  		val total = X.sum
  		// Recursive
		def inter(X: List[Double], cumRelFreqSeq: List[Double]): List[Double] = {
	  		X match {
	  			case Nil => cumRelFreqSeq.reverse
	  			case x :: xs => {
	  				val relFreq = x/total
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
}