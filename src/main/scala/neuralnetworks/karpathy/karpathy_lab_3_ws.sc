package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._
import scala.math._

object karpathy_lab_3_ws {
	// Strategy #3: Analytic Gradient
	val x = -2d                               //> x  : Double = -2.0
  val y = 3d                                      //> y  : Double = 3.0
  
  forwardMultiplyGate(x,y)                        //> res0: neuralnetworks.karpathy.KarpathyLab_1.T = -6.0
  
  val x_gradient = y                              //> x_gradient  : Double = 3.0
  val y_gradient = x                              //> y_gradient  : Double = -2.0
  
  val step_size = 0.01                            //> step_size  : Double = 0.01
  
  val new_x = x + step_size * x_gradient          //> new_x  : Double = -1.97
  val new_y = y + step_size * y_gradient          //> new_y  : Double = 2.98
  
  forwardMultiplyGate(new_x, new_y)               //> res1: neuralnetworks.karpathy.KarpathyLab_1.T = -5.8706
  
}
/*


*/