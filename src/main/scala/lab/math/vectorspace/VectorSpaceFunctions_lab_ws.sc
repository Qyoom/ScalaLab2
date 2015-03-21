package lab.math.vectorspace
import lab.math.vectorspace.VectorSpaceFunctions_lab_1._
 

object VectorSpaceFunctions_lab_ws {
  // y = mx + b
  // solveFor(y, x, yIntercept, slope, errorTerm)
  
  // Example:
  // y = 5x+3
  // -2 = 5(-1) + 3
  solveFor(None, Some(-1d), Some(3d), Some(5d), None)
  solveFor(Some(-2d), None,  Some(3d), Some(5d), None)
  solveFor(Some(-2d), Some(-1d), None, Some(5d), None)
  solveFor(Some(-2d), Some(-1d), Some(3d), None, None)
  // With errorTerm
  solveFor(None, Some(-1d), Some(3d), Some(5d), Some(.25))
  solveFor(Some(-2d), None,  Some(3d), Some(5d), Some(.25))
  solveFor(Some(-2d), Some(-1d), None, Some(5d), Some(.25))
  solveFor(Some(-2d), Some(-1d), Some(3d), None, Some(.25))
}