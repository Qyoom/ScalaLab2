package lab.calculus.derivatives

object DerivativesLab2 {
    import scala.math._
    
    def main(args: Array[String]): Unit = {
        
        // Two different functions to derive derviatives for
        def f1 = (x: Double) => pow(x,2)
        def f2 = (x: Double) => pow(x,2) * 1.5
        
        // series of test inputs x1 and x2
        val params = List((3,7), (7,3), (5,12), (-5,12))
        
        params.foreach { x =>
            val x1 = x._1
            val x2 = x._2
            // slope derivative results for each
	        println("derive slope for f1 with x1=" + x1 + " x2=" + x2)
	        println("final slope for f1: " + deriveSlope(f1)(x1, x2) + "\n")
	        println("derive slope for f2 with x1=" + x1 + " x2=" + x2)
	        println("final slope for f2: " + deriveSlope(f2)(x1, x2)  + "\n")
        }
    }
    
    val deltaThreshold = 0.000001
    
    /* Calculates slope based on delta x and slope function as
     * x2 goes toward x1 and delta goes toward 0
     */
    def deriveSlope(f: Double => Double) (x1: Double, x2: Double): Double = {
        
        def delta(x1: Double, x2: Double): Double = x2 - x1
        def dx = delta(x1, x2)
        val slope = (f(x1 + dx) - f(x1)) / dx
        println("initial slope: " + slope)
        
        // Returns reduced delta; recursive
        def moveCloser(x1: Double, x2: Double): Double = {
            val dif = abs(x1 - x2)
			if(x2 > x1) x2 - dif * .99999
			else x2 + dif * .99999
		}
        
        // Returns slope with reduced delta
        def deriveSlope(x1: Double, x2: Double): Double = {
            val newX2 = moveCloser(x1, x2)
            val dx = delta(x1, newX2)
            val slope = (f(x1 + dx) - f(x1)) / dx
            println("derivative step: " + slope)
            if(abs(dx) > deltaThreshold) deriveSlope(x1, newX2) // inner recursion
            else slope
        }
        
        // Kick off deriveSlope
        if(abs(dx) > deltaThreshold) deriveSlope(x1, x2)
        else slope
    } // end outer deriveSlope
}