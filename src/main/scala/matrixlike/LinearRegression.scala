package matrixlike

object LinearRegression {
    
    /*
     * y is a linear function of X
     * Theta_i are parameters. Theta0 is zero condition, or the bias. It
     * is the starting point for the y axis, the baseline from which change
     * will be measured. Theta1 is the gradient. The gradient is the line
     * having the best fit among all members of the target set (sharing an 
     * overall mean having the minimized, or least variance). If θ0 is 
     * 1.5 and θ1 is 0 then we get straight line parallel with X along 1.5 @ y
     * If θ1 is > 0 then we get a positive slope
     * Cost means the extent to which the line derived from the mean slope of 
     * theta (theta0, theta1) applied to the mean of X varies from the mean of y.
     */

    def gradientDescent(
            X: List[List[Double]], 
            y: List[List[Double]], 
            theta: List[Double], 
            alpha: Double, 
            iters: Double
        ): List[Double] = {
        
        List(0.0) // STUB
    }
}