package calculus_lab.mit.derivative

object Derivative_formula_1_ws {

	// This is my take on what I saw in this MIT video
	// http://ocw.mit.edu/courses/mathematics/18-01sc-single-variable-calculus-fall-2010/1.-differentiation/part-a-definition-and-basic-rules/session-1-introduction-to-derivatives/
  def f_deriv(x0: Double, x1: Double, f: Double => Double): Double = {
  		val delta_x = x1 - x0
  		val res = (f(x0 + delta_x) - f(x0)) / delta_x
  		res
  }                                               //> f_deriv: (x0: Double, x1: Double, f: Double => Double)Double
  
  // Comparing with
  // https://code.google.com/p/scalation/source/browse/trunk/src/scalation/math/Calculus.scala?spec=svn126&r=121
  // http://cobweb.cs.uga.edu/~jam/scalation_1.1/doc/index.html#scalation.calculus.Calculus$
  val h = 1E-10                                   //> h  : Double = 1.0E-10
  type FunctionS2S = (Double) => Double
  /**Estimate the derivative of the scalar-to-scalar function f at point x.
   * @param f  the function whose derivative is sought
   * @param x  the point (scalar) at which to estimate the derivative
   */
  def derivative (f: FunctionS2S, x: Double): Double = {
		(f(x + h) - f(x)) / h
	}                                         //> derivative: (f: Double => Double, x: Double)Double
  
  // --------------------------------- //
  
  // example 1
  def f(x: Double) = 1/x                          //> f: (x: Double)Double
  
  derivative(f, 3)                                //> res0: Double = -0.11111112030448567
  derivative(f, 2)                                //> res1: Double = -0.25000002068509275
  val temp2 = -1/4d                               //> temp2  : Double = -0.25
  derivative(f, -4)                               //> res2: Double = -0.06250000517127319
  val temp1 = -1/16d                              //> temp1  : Double = -0.0625
  
  f_deriv(3, 5, f)                                //> res3: Double = -0.06666666666666665
  f_deriv(1, 10, f)                               //> res4: Double = -0.1
  f_deriv(1, 100, f)                              //> res5: Double = -0.01
  f_deriv(1, 2, f)                                //> res6: Double = -0.5
  f_deriv(5, 3, f)                                //> res7: Double = -0.06666666666666665
  f_deriv(100, 1, f)                              //> res8: Double = -0.01
  f_deriv(50, 51, f)                              //> res9: Double = -3.9215686274509873E-4
  f_deriv(51, 50, f)                              //> res10: Double = -3.9215686274509873E-4
  f_deriv(7, 8, f)                                //> res11: Double = -0.01785714285714285
  f_deriv(15,17, f)                               //> res12: Double = -0.00392156862745098
  
}