package lab.math

import math._
import lab.math.Rounding_lab_1.roundAt

object Rounding_tests_1_ws {
	log(6)                                    //> res0: Double = 1.791759469228055
  
  /* Foundations of Statistical Natural Language Processing, p580 */
  val raw = 10 * ((1 + log(6)) / (1 + log(89)))   //> raw  : Double = 5.086435466236399
  
  roundAt(2)(raw)                                 //> res1: Double = 5.09
  
  roundAt(3)(0.16666666666666666)                 //> res2: Double = 0.167
  val round = roundAt(3)_                         //> round  : Double => Double = <function1>
  round(0.16666666666666666)                      //> res3: Double = 0.167
}