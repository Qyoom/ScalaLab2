package lab.calculus.derivatives

import scala.math._
import lab.math.Rounding_lab_1.roundAt

object Derivative3 {
    
    /* Calculates slope based on delta_x and slope function as
     * delta_x goes toward 0
     */
    def derivative_model_A(
        f: Double => Double, 
        x1: Double = 0, 
        deltaThreshold: Double = 0.00001)
    		(x0: Double) = {
      
    		val inverseThreshold = 1 - deltaThreshold
        
    		// TODO: There is an issue here with the limit in that there are two error
    		// scenarios: when x0 is initially passed in to this derivative function
    		// with 0 value, or when x1 and x2 are passed in with the same value. This
    		// creates a divide by zero error (which defeats the whole purpose of the limit).
    		// Code and learn...!
        def delta(x0: Double, delta_x: Double): Double = delta_x - x0
        val dx = delta(x0, x1)
        val slope = (f(x0 + dx) - f(x0)) / dx
        println("initial slope: " + slope)
        
        // Returns reduced delta; recursive
        def moveCloser(x0: Double, x1: Double): Double = {
            val diff = abs(x0 - x1)
			if(x1 > x0) x1 - diff * inverseThreshold
			else x1 + diff * inverseThreshold
		}
        
        // Returns slope with reduced delta
        def inter(x0: Double, delta_x0: Double): Double = {
            val delta_x = moveCloser(x0, delta_x0)
            val dx = delta(x0, delta_x)
            val slope = (f(x0 + dx) - f(x0)) / dx
            println("derivative step: " + slope)
            if(abs(dx) > deltaThreshold) inter(x0, delta_x) // inner recursion
            else slope
        }
        
        // Kick off derivitive calculation
        if(abs(dx) > deltaThreshold) inter(x0, x1)
        else slope
    }
    
    // https://code.google.com/p/scalation/source/browse/trunk/src/scalation/math/Calculus.scala?spec=svn126&r=121
	// http://cobweb.cs.uga.edu/~jam/scalation_1.1/doc/index.html#scalation.calculus.Calculus$
	val h = 1E-10                                   //> h  : Double = 1.0E-10
	type FunctionS2S = (Double) => Double
	/** Estimate the derivative of the scalar-to-scalar function f at point x.
     *  @param f  the function whose derivative is sought
     *  @param x  the point (scalar) at which to estimate the derivative
     */
    def derivative_model_B(f: FunctionS2S)(x: Double): Double =
    {
        (f(x + h) - f(x)) / h
    }
}