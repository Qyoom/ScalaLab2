package lab.calculus.derivatives.schaum

import scala.math._
import lab.calculus.derivatives.Derivative3._

object Example_2_ws {
	// Chapter 9, Differential and Integral Calculus, 3rd Ed.
	// THE DERIVATIVE
	
	def f1(x: Double) = pow(x,2) + 3*x        //> f1: (x: Double)Double
	def f2(x: Double) = 1d/x                  //> f2: (x: Double)Double
	
	// ----- Tests ------------------------- //
	// derivative of f at x0
	
	val x0 = 2.0                              //> x0  : Double = 2.0
	//val x0 = -4.0
  
  val f2_dv1 = derivative_model_A(f2)_            //> f2_dv1  : Double => Double = <function1>
  f2_dv1(6)                                       //> initial slope: -Infinity
                                                  //| derivative step: -0.0277780555583027
                                                  //| derivative step: -0.027777777777777776
                                                  //| res0: Double = -0.027777777777777776
  val f2_dv2 = derivative_model_B(f2)_            //> f2_dv2  : Double => Double = <function1>
  f2_dv2(6)                                       //> res1: Double = -0.027777780076121417
  
  val f1_dv1 = derivative_model_A(f1)_            //> f1_dv1  : Double => Double = <function1>
  f1_dv1(x0)                                      //> initial slope: 5.0
                                                  //| derivative step: 6.999979999942834
                                                  //| derivative step: 7.0
                                                  //| res2: Double = 7.0
  
  val f1_dv2 = derivative_model_B(f1)_            //> f1_dv2  : Double => Double = <function1>
	f1_dv2(x0)                                //> res3: Double = 7.000000579182597
}