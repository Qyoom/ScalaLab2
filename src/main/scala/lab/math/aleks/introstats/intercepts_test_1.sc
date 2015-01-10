package lab.math.aleks.introstats

import lab.math.vectorspace.VectorSpaceFunctions_lab_1._

object intercepts_test_1 {
  // y = mx + b
  // graphLine(y, x, yIntercept, slope, errorTerm)
  // To find the x-intercept, set y = 0 and solve for x.
  // To find the y-intercept, set x = 0 and solve for y.
  
  // 7.9x - 8.2y -9.6 = 0
  solveFor(Option(0.0), None, Option(-9.6), Option(7.9), None)
                                                  //> res0: (String, Double) = (x,1.2151898734177213)
 	// y = 88.83 + 0.51x
 	// y = 0.51x + 88.83
 	// y = 0.51(160.6) + 88.83
 	solveFor(None, Option(160.6), Option(88.83), Option(0.51), None)
                                                  //> res1: (String, Double) = (y,170.736)
}