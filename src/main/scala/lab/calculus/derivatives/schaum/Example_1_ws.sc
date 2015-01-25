package lab.calculus.derivatives.schaum

import scala.math._

object Example_1_ws {
	// Chapter 9, Differential and Integral Calculus, 3rd Ed.
	// INCREMENTS
	
	def f(x: Double) = pow(x,2) + 2*x         //> f: (x: Double)Double
	
	// ----- Tests ------------------------- //
	
	val x0 = 1.0                              //> x0  : Double = 1.0
	val delta_x = 0.5                         //> delta_x  : Double = 0.5
	
	val y0 = f(x0)                            //> y0  : Double = 3.0
	val delta_y = f(x0 + delta_x) - f(x0)     //> delta_y  : Double = 2.25

	//f1(x0 + delta_x)
	//f1(x0)
	//f1(delta_x)
	
	// Average rate of change for interval x0 to delta_x
	delta_y / delta_x                         //> res0: Double = 4.5
}