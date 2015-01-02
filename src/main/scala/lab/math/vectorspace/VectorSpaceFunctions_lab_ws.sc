package lab.math.vectorspace
import lab.math.vectorspace.VectorSpaceFunctions_lab_1._

object VectorSpaceFunctions_lab_ws {
  // y = mx + b
  // solveFor(y, x, yIntercept, slope, errorTerm)
  
  // Example:
  // y = 5x+3
  // -2 = 5(-1) + 3
  solveFor(None, Some(-1d), Some(3d), Some(5d), None)
                                                  //> res0: (String, Double) = (y,-2.0)
  solveFor(Some(-2d), None,  Some(3d), Some(5d), None)
                                                  //> res1: (String, Double) = (x,-1.0)
  solveFor(Some(-2d), Some(-1d), None, Some(5d), None)
                                                  //> res2: (String, Double) = (yIntercept,3.0)
  solveFor(Some(-2d), Some(-1d), Some(3d), None, None)
                                                  //> res3: (String, Double) = (slope,5.0)
  // With errorTerm
  solveFor(None, Some(-1d), Some(3d), Some(5d), Some(.25))
                                                  //> res4: (String, Double) = (y,-1.75)
  solveFor(Some(-2d), None,  Some(3d), Some(5d), Some(.25))
                                                  //> res5: (String, Double) = (x,-0.75)
  solveFor(Some(-2d), Some(-1d), None, Some(5d), Some(.25))
                                                  //> res6: (String, Double) = (yIntercept,3.25)
  solveFor(Some(-2d), Some(-1d), Some(3d), None, Some(.25))
                                                  //> res7: (String, Double) = (slope,5.25)
}