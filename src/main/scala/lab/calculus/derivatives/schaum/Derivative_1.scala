package lab.calculus.derivatives.schaum

import scala.math._

object Derivative_1 {

    val deltaThreshold = 0.000001
    
    /* Calculates derivative based on delta_x and delta_y function as
     * delta goes toward 0
     */
    def derivative(f: Double => Double) (x0: Double, delta_x: Double = 0): Double = {
        
        def delta(x1: Double, x2: Double): Double = x2 - x1
        def dx = delta(x0, delta_x)
        val slope = (f(x0 + dx) - f(x0)) / dx
        println("initial slope: " + slope)
        
        // Returns reduced delta; recursive
        def moveCloser(x1: Double, x2: Double): Double = {
            val dif = abs(x1 - x2)
			if(x2 > x1) x2 - dif * .99999
			else x2 + dif * .99999
		}
        
        // Returns slope with reduced delta
        def inter(x1: Double, x2: Double): Double = {
            val newX2 = moveCloser(x1, x2)
            val dx = delta(x1, newX2)
            val slope = (f(x1 + dx) - f(x1)) / dx
            println("derivative step: " + slope)
            if(abs(dx) > deltaThreshold) inter(x1, newX2) // inner recursion
            else slope
        }
        
        // Kick off deriveSlope
        if(abs(dx) > deltaThreshold) inter(x0, delta_x)
        else slope
    } // end outer deriveSlope
}