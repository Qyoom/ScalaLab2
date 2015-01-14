package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._

object karpathy_lab_4_ws {
	/* Recursive Case: Circuits with Multiple Gates
	 * Functional composition of gates
   */
   
   def forwardCircuit(gate1: (T,T)=>T)(gate2: (T,T)=>T)(stepSize: Double)(x0:T, y0:T, z:T) = {
		// This is all a bunch of unsatisfying simplistic voodoo by the tut author
		// but I'm going through the motions...!
	  
		val q = gate1(x0,y0)
		println("q:" + q)
		val y1 = z
		
		val x_gradient = y1
		val y_gradient = q
		
		val x2 = q + stepSize * x_gradient
		val y2 = y1 + stepSize * y_gradient
	  
		gate2(x2, y2)
	}                                         //> forwardCircuit: (gate1: (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetw
                                                  //| orks.karpathy.KarpathyLab_1.T) => neuralnetworks.karpathy.KarpathyLab_1.T)(g
                                                  //| ate2: (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T) => neuralnetworks.karpathy.KarpathyLab_1.T)(stepSize: Double)(x
                                                  //| 0: neuralnetworks.karpathy.KarpathyLab_1.T, y0: neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, z: neuralnetworks.karpathy.KarpathyLab_1.T)neuralnetworks.karpa
                                                  //| thy.KarpathyLab_1.T
   
   val x = -2                                     //> x  : Int = -2
   val y = 5                                      //> y  : Int = 5
   val z = -4                                     //> z  : Int = -4
   
   val c1 = forwardCircuit(forwardAddGate)(forwardMultiplyGate)(0.01)_
                                                  //> c1  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   c1(x,y,z)                                      //> q:3.0
                                                  //| res0: neuralnetworks.karpathy.KarpathyLab_1.T = -11.7512
   
   val c2 = forwardCircuit(forwardMultiplyGate)(forwardAddGate)(0.01)_
                                                  //> c2  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   c2(x,y,z)                                      //> q:-10.0
                                                  //| res1: neuralnetworks.karpathy.KarpathyLab_1.T = -14.139999999999999
   
   val c3 = forwardCircuit(forwardMultiplyGate)(forwardModuloGate)(0.01)_
                                                  //> c3  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => neuralnetworks.karp
                                                  //| athy.KarpathyLab_1.T = <function3>
   
   c3(x,y,z)                                      //> q:-10.0
                                                  //| res2: neuralnetworks.karpathy.KarpathyLab_1.T = -1.8399999999999999
   
}
/*


*/