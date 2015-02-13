package lab.calculus.derivatives

import lab.calculus.derivatives.Derivative3._
import scala.math._

object Derivatives_lab_3 {

	/** Collins Intro Calculus, Ch.3 Derivatives - Finding Slope in General, p.89, Ex.3.2(a) **/

	def fa(x: Double) = 3 * pow(x,2) - 2*x + 1//> fa: (x: Double)Double
	
	// slope is 6x-2  per book
	// x0 = 3
	6*3 - 2                                   //> res0: Int = 16
	// x0 = -1
	6*(-1) -2                                 //> res1: Int = -8
	
	val dmA_fa = derivative_model_A(fa)_      //> dmA_fa  : Double => Double = <function1>
	dmA_fa(3)                                 //> initial slope: 7.0
                                                  //| derivative step: 15.999910000051765
                                                  //| derivative step: 16.0
                                                  //| res2: Double = 16.0
	dmA_fa(-1)                                //> initial slope: -5.0
                                                  //| derivative step: -7.999969999997518
                                                  //| res3: Double = -7.999969999997518
	
}