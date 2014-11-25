package lab.calculus.derivatives

import math._

object Derivatives_lab_1 {
	val x1 = -5 //3                           //> x1  : Int = -5
	val x2 = 12 //7                           //> x2  : Int = 12
	// the expected derivative
	2 * x1                                    //> res0: Int = -10

	// The function for which we're finding the derivative
	def f(x: Double) = pow(x,2)               //> f: (x: Double)Double
	
	
	def delta(x1: Double, x2: Double): Double = x2 - x1
                                                  //> delta: (x1: Double, x2: Double)Double
	var dx = delta(x1, x2)                    //> dx  : Double = 17.0

	//diagnostics during development
	//f(x1)
	//f(x1 + dx)
	//2 * x1 + dx
	
	// Slope formula
	def sf = (f(x1 + dx) - f(x1)) / dx        //> sf: => Double
	
	// Showing derivative as dx -> 0
	dx = 0.001
	sf                                        //> res1: Double = -9.999000000004088
	dx = 0.0001
	sf                                        //> res2: Double = -9.99989999996842
	dx = 0.00001
	sf                                        //> res3: Double = -9.999989999798231
	dx = 0.000001
	sf                                        //> res4: Double = -9.999999001308879
	
	
	
}