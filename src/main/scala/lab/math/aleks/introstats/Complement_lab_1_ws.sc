package lab.math.aleks.introstats

import breeze.linalg._
import breeze.stats._
import breeze.math._
import breeze.numerics._

import lab.math.Rounding_lab_1._

import lab.math.Rounding_lab_1._

object Complement_lab_1_ws {

	/*
	val pA_comp = 0.40
	val pA = 1 - pA_comp
	val pB = 0.10
	val pB_comp = 1 - pB
	val pAB = pA * pB
	val pAUB = roundAt(2)(pA + pB - pAB)
	
	val pA = 0.70
	val pA_comp = roundAt(2)(1 - pA)
	val pB_comp = 0.50
	val pB = 1 - pB_comp
	//
	val pAB = pA * pB
	val AUB = pA + pB - pAB
	
	val pA_comp = 0.20
	val pA = 1 - pA_comp
	val pB = 0.70
	val pB_comp = roundAt(2)(1 - pB)
	*/
	
	val pA = 0.40                             //> pA  : Double = 0.4
	val pA_comp = 1 - pA                      //> pA_comp  : Double = 0.6
	val pB_comp = 0.70                        //> pB_comp  : Double = 0.7
	val pB = 1 - pB_comp                      //> pB  : Double = 0.30000000000000004
	//
	val pAB = roundAt(2)(pA * pB)             //> pAB  : Double = 0.12
	val pAUB = roundAt(2)(pA + pB - pAB)      //> pAUB  : Double = 0.58
}
/*



*/