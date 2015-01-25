package lab.calculus.derivatives.schaum

import scala.math._
import lab.calculus.derivatives.Derivative3.derivative

object Example_2_ws {
	// Chapter 9, Differential and Integral Calculus, 3rd Ed.
	// THE DERIVATIVE
	
	def f(x: Double) = pow(x,2) + 3*x         //> f: (x: Double)Double
	
	// ----- Tests ------------------------- //
	
	//val x0 = 2.0
	val x0 = -4.0                             //> x0  : Double = -4.0
	//val delta_x = 0
   
  val f_prime = derivative(f)_                    //> f_prime  : Double => Double = <function1>
  // derivative of f at x0
  f_prime(x0)                                     //> initial slope: -1.0
                                                  //| derivative step: -4.999960000007793
                                                  //| derivative step: -5.0
                                                  //| res0: Double = -5.0

}