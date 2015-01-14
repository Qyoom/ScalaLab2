package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._

object karpathy_lab_5_ws {
	/* Recursive Case: Circuits with Multiple Gates
	 * Functional composition of gates
   */
   
   val x = -2                                     //> x  : Int = -2
   val y = 5                                      //> y  : Int = 5
   val z = -4                                     //> z  : Int = -4
   
   val c1 = forwardCircuit(forwardAddGate)(forwardMultiplyGate)(0.01)_
                                                  //> c1  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => Unit = <function3>
   c1(x,y,z)                                      //> q:3.0
                                                  //| f:-12.0
  
}
/*


*/