package lab.functions
import math._

object SequenceProgression_lab_2 {

  def seqProg[R](n: R, seqOp: R=>R, numberOfRecursions: Int): List[R] = {
  		def inter(numRecur: Int, acc: List[R]): List[R] = {
  			if (numRecur > 0) inter(numRecur - 1, acc ++ List(seqOp(acc.last)))
	  		else acc
  		}
  		inter(numberOfRecursions, List[R](n))
  }                                               //> seqProg: [R](n: R, seqOp: R => R, numberOfRecursions: Int)List[R]
  // Arithmetic progression
	// is a sequence with a common constant interval between terms.
	type I = Int
  val arithProg = (n:I, interval:I, numRec:Int) => seqProg[I](n, {n => n + interval}, numRec)
                                                  //> arithProg  : (lab.functions.SequenceProgression_lab_2.I, lab.functions.Seque
                                                  //| nceProgression_lab_2.I, Int) => List[lab.functions.SequenceProgression_lab_2
                                                  //| .I] = <function3>
  arithProg(5, 4, 5)                              //> res0: List[lab.functions.SequenceProgression_lab_2.I] = List(5, 9, 13, 17, 2
                                                  //| 1, 25)
  arithProg(3, 2, 5)                              //> res1: List[lab.functions.SequenceProgression_lab_2.I] = List(3, 5, 7, 9, 11,
                                                  //|  13)
  
  // Geometric progression
  // is a sequence with a common ratio between the terms.
  type D = Double
  val geomProg = (n:D, interval:D, numRec:Int) => seqProg[D](n, {n => n * interval}, numRec)
                                                  //> geomProg  : (lab.functions.SequenceProgression_lab_2.D, lab.functions.Sequen
                                                  //| ceProgression_lab_2.D, Int) => List[lab.functions.SequenceProgression_lab_2.
                                                  //| D] = <function3>
  geomProg(3, 2d, 5)                              //> res2: List[lab.functions.SequenceProgression_lab_2.D] = List(3.0, 6.0, 12.0,
                                                  //|  24.0, 48.0, 96.0)
  geomProg(3, 0.5, 5)                             //> res3: List[lab.functions.SequenceProgression_lab_2.D] = List(3.0, 1.5, 0.75,
                                                  //|  0.375, 0.1875, 0.09375)
  
  3 * pow(2, 5)                                   //> res4: Double = 96.0
  3 * pow(0.5, 5)                                 //> res5: Double = 0.09375
  
  val squareProg = (n:I, numRec:Int) => seqProg[I](n, {n => n * n}, numRec)
                                                  //> squareProg  : (lab.functions.SequenceProgression_lab_2.I, Int) => List[lab.f
                                                  //| unctions.SequenceProgression_lab_2.I] = <function2>
  squareProg(3, 5)                                //> res6: List[lab.functions.SequenceProgression_lab_2.I] = List(3, 9, 81, 6561,
                                                  //|  43046721, -501334399)
}