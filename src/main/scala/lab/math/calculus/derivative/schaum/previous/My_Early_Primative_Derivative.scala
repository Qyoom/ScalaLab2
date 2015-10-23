package lab.math.calculus.derivative.schaum.previous

import scala.math._

object My_Early_Primative_Derivative {

    /* Calculates slope based on delta_x and slope function as
     * delta_x goes toward 0
     */
    def derivative_model_A(
        f: Double => Double, 
        x1: Double = 0, 
        deltaThreshold: Double = 0.00001
    )(x0: Double) = { // curried
      
        val inverseThreshold = 1 - deltaThreshold
    
        // TODO: There is an issue here with the limit in that there are two error
        // scenarios: when x0 is initially passed in to this derivative function
        // with 0 value, or when x1 and x2 are passed in with the same value. This
        // creates a divide by zero error (which defeats the whole purpose of the limit).
        // Code and learn...!
        def delta(x0: Double, x1: Double): Double = x1 - x0
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
        def inter(x0: Double, x1: Double): Double = {
            val x1_closer = moveCloser(x0, x1)
            val dx = delta(x0, x1_closer)
            val slope = (f(x0 + dx) - f(x0)) / dx
            println("derivative step: " + slope)
            if(abs(dx) > deltaThreshold) inter(x0, x1_closer) // inner recursion
            else slope
        }
        
        // Kick off derivitive calculation
        if(abs(dx) > deltaThreshold) inter(x0, x1)
        else slope
    }

}