package lab.math.calculus.derivative.schaum.previous

object LinearFunction1 {

    /* y = mx + b
     * i.e. Take two pairs of x,y coordinates and calculate slope and intercept,
     * returning function that takes any x input and produces y output according
     * to calculated slope and intercept.
     * Copy of ScalaLab2/src/main/scala/lab/math/vectorspace/line_function_lab_1.sc
     */
    type T = Double
    def line (x0: T, y0: T) (x1: T, y1: T) = {
        val slope = (y1 - y0) / (x1 - x0) // delta_y / delta_x
        // b = y - mx
        val intercept = y0 - slope * x0
        
        println("slope:" + slope + " intercept:" + intercept)
        
        // Return function(any_x) => y_output
        // new_y = m*new_x + b
        (new_x:T) => slope * new_x + intercept // solving for new_y
    }
}



