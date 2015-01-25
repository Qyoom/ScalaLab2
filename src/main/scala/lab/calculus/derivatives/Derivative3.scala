package lab.calculus.derivatives

import scala.math._
import lab.math.Rounding_lab_1.roundAt

object Derivative3 {
    
    /* Calculates slope based on delta_x and slope function as
     * delta_x goes toward 0
     */
    def derivative(
        f: Double => Double, 
        delta_x: Double = 0, 
        deltaThreshold: Double = 0.00001)
    		(x0: Double) = {
      
    		val inverseThreshold = 1 - deltaThreshold
        
        def delta(x0: Double, delta_x: Double): Double = delta_x - x0
        val dx = delta(x0, delta_x)
        val slope = (f(x0 + dx) - f(x0)) / dx
        println("initial slope: " + slope)
        
        // Returns reduced delta; recursive
        def moveCloser(x0: Double, delta_x: Double): Double = {
            val diff = abs(x0 - delta_x)
			if(delta_x > x0) delta_x - diff * inverseThreshold
			else delta_x + diff * inverseThreshold
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
        if(abs(dx) > deltaThreshold) inter(x0, delta_x)
        else slope
    } // end outer derivative
}