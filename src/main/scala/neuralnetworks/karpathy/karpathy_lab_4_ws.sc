package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._

object karpathy_lab_4_ws {
	/* Recursive Case: Circuits with Multiple Gates
	 * Functional composition of gates
   */
   
   val x = -2                                     //> x  : Int = -2
   val y = 5                                      //> y  : Int = 5
   val z = -4                                     //> z  : Int = -4
   
   val c1 = forwardCircuit(forwardAddGate)(forwardMultiplyGate)(0.01)_
                                                  //> c1  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   c1(x,y,z)                                      //> res0: neuralnetworks.karpathy.KarpathyLab_1.T = -11.7512
   
   val c2 = forwardCircuit(forwardMultiplyGate)(forwardAddGate)(0.01)_
                                                  //> c2  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   c2(x,y,z)                                      //> res1: neuralnetworks.karpathy.KarpathyLab_1.T = -14.139999999999999
   
   val c3 = forwardCircuit(forwardMultiplyGate)(forwardModuloGate)(0.01)_
                                                  //> c3  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   
   c3(x,y,z)                                      //> res2: neuralnetworks.karpathy.KarpathyLab_1.T = -1.8399999999999999
   
}
/*


*/