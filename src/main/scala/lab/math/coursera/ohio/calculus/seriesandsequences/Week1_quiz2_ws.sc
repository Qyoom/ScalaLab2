package lab.math.coursera.ohio.calculus.seriesandsequences

object Week1_quiz2_ws {

	// Arithmetic progression
	// is a sequence with a common constant interval between terms.
  def arithProg(n: Int, add: Int, numberOfRecursions: Int): List[Int] = {
  
  		def inter(n: Int, numRecur: Int, acc: List[Int]): List[Int] = {
	  		if (numRecur > 0) inter(n + add, numRecur - 1, acc ++ List(n + add))
	  		else acc
  		}
  		inter(n, numberOfRecursions, List[Int](n))
  }                                               //> arithProg: (n: Int, add: Int, numberOfRecursions: Int)List[Int]
  
  arithProg(5, 4, 5)                              //> res0: List[Int] = List(5, 9, 13, 17, 21, 25)
  arithProg(3, 2, 5)                              //> res1: List[Int] = List(3, 5, 7, 9, 11, 13)
  
  // Geometric progression --------------------------------------------------------------/
  // is a sequence with a common ratio between the terms.
  def geomProg(n: Double, ratio: Double, numberOfRecursions: Int): List[Double] = {
  		
  		def inter(n: Double, numRecur: Int, acc: List[Double]): List[Double] = {
  			if (numRecur > 0) inter(n * ratio, numRecur - 1, acc ++ List(n * ratio))
	  		else acc
  		}
  		inter(n, numberOfRecursions, List[Double](n))
  }                                               //> geomProg: (n: Double, ratio: Double, numberOfRecursions: Int)List[Double]
  
  geomProg(3, 2d, 5)                              //> res2: List[Double] = List(3.0, 6.0, 12.0, 24.0, 48.0, 96.0)
  geomProg(3, 0.5, 5)                             //> res3: List[Double] = List(3.0, 1.5, 0.75, 0.375, 0.1875, 0.09375)
  
}