package lab.math.calculus.derivative.schaum.previous

object Derivative_formulas_1 {

    // This is my take on what I saw in this MIT video
    // http://ocw.mit.edu/courses/mathematics/18-01sc-single-variable-calculus-fall-2010/1.-differentiation/part-a-definition-and-basic-rules/session-1-introduction-to-derivatives/
    // NO. This is just slope, not the derivative!
    def f_deriv(x0: Double, x1: Double, f: Double => Double): Double = {
        val delta_x = x1 - x0
        val res = (f(x0 + delta_x) - f(x0)) / delta_x // ratio of delta of f(x1) - f(x0) over delta x
        res
    }                                               //> f_deriv: (x0: Double, x1: Double, f: Double => Double)Double
  
    // Comparing with
    // https://code.google.com/p/scalation/source/browse/trunk/src/scalation/math/Calculus.scala?spec=svn126&r=121
    // http://cobweb.cs.uga.edu/~jam/scalation_1.1/doc/index.html#scalation.calculus.Calculus$
    val h = 1E-10                                   //> h  : Double = 1.0E-10
    type FunctionS2S = (Double) => Double // scalar-to-scalar function
    /**Estimate the derivative of the scalar-to-scalar function f at point x.
     * @param f  the function whose derivative is sought
     * @param x  the point (scalar) at which to estimate the derivative
     */
    def derivative (f: FunctionS2S, x: Double): Double = {
        (f(x + h) - f(x)) / h
    }
}
