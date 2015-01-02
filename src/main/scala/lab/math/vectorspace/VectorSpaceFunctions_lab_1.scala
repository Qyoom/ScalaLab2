package lab.math.vectorspace

object VectorSpaceFunctions_lab_1 {
  
	/* y = mx + b + epsilon
	 * label or output = slope times input + y-intercept + error term
	 * Calculate full equation given any 3 variables of y, m, x, or b.
	 * The error term is optional.
	 * Return a tuple containing paired meta name and value for solved missing variable.
	 */
	val solveFor: (
	    Option[Double], // y
	    Option[Double], // x
	    Option[Double], // yIntercept
	    Option[Double], // slope
	    Option[Double]  // errorTerm, not solved for
    ) => (String, Double) = { // The solved for (missing) value
      	case (None, Some(x), Some(yIntercept), Some(slope), errorTerm) => {
      		val y = (slope * x) + yIntercept + (errorTerm match {
      		  	case Some(e) => e
      		  	case None => 0.0
      		})
      		("y", y) // solves for y
      	}
      	case (Some(y), None, Some(yIntercept), Some(slope), errorTerm) => {
      		val x = (y - yIntercept) / slope + (errorTerm match {
      		  	case Some(e) => e
      		  	case None => 0.0
      		})
      		("x", x) // solves for x
      	}
      	case (Some(y), Some(x), None, Some(slope), errorTerm) => {
      		val yIntercept = y - (slope * x) + (errorTerm match {
      		  	case Some(e) => e
      		  	case None => 0.0
      		})
      		("yIntercept", yIntercept) // solves for y intercept
      	}
      	case (Some(y), Some(x), Some(yIntercept), None, errorTerm) => {
      		val slope = (y - yIntercept) / x + (errorTerm match {
      		  	case Some(e) => e
      		  	case None => 0.0
      		})
      		("slope", slope) // solves for slope
      	}
      	case _ => throw new IllegalArgumentException("Parameters do not have legal configuration")
    }
    // Might try using a Map instead of free params. In this way I would retain lables.
	// And Maps automatically come with Option/Some retrieval.
	// See lab.case_classes_pattern_matching.case_class_lab_2.sc
    
    
}






