package lab.math.coursera.ohio.calculus.seriesandsequences

object SequenceProgression_lab {

  def seqProg(n: Double, seqOp: Double=>Double, numberOfRecursions: Int): List[Double] = {
  		def inter(n: Double, numRecur: Int, acc: List[Double]): List[Double] = {
  			if (numRecur > 0) inter(seqOp(n), numRecur - 1, acc ++ List(seqOp(n)))
	  		else acc
  		}
  		inter(n, numberOfRecursions, List[Double](n))
  }                                               //> seqProg: (n: Double, seqOp: Double => Double, numberOfRecursions: Int)List[D
                                                  //| ouble]
  // Arithmetic progression
	// is a sequence with a common constant interval between terms.
  val arithProg = (n:Double, interval:Double, numRec:Int) => seqProg(n, {n => n + interval}, numRec)
                                                  //> arithProg  : (Double, Double, Int) => List[Double] = <function3>
  arithProg(5, 4, 5)                              //> res0: List[Double] = List(5.0, 9.0, 13.0, 17.0, 21.0, 25.0)
  arithProg(3, 2, 5)                              //> res1: List[Double] = List(3.0, 5.0, 7.0, 9.0, 11.0, 13.0)
  
  // Geometric progression
  // is a sequence with a common ratio between the terms.
  val geomProg = (n:Double, interval:Double, numRec:Int) => seqProg(n, {n => n * interval}, numRec)
                                                  //> geomProg  : (Double, Double, Int) => List[Double] = <function3>
  geomProg(3, 2d, 5)                              //> res2: List[Double] = List(3.0, 6.0, 12.0, 24.0, 48.0, 96.0)
  geomProg(3, 0.5, 5)                             //> res3: List[Double] = List(3.0, 1.5, 0.75, 0.375, 0.1875, 0.09375)
  
}