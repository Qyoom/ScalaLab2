package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._

object karpathy_lab_5_ws {
	/* Recursive Case: Circuits with Multiple Gates
	 * Functional composition of gates
   */
  
   // gate1: add, gate2: multiply
  	def forwardCircuit(gate1: (T,T)=>T)(gate2: (T,T)=>T)(stepSize: Double)(x:T, y:T, z:T) = {
		// This is all a bunch of unsatisfying simplistic voodoo by the tut author
		// but I'm going through the motions...!
		
		// gradient of the MULTIPLY gate with respect to its inputs
		val derivative_f_wrt_q = z // -4
 
		// derivative of the ADD gate with respect to its inputs
		val derivative_q_wrt_x = 1.0
		val derivative_q_wrt_y = 1.0
		
		// chain rule
		val derivative_f_wrt_x = derivative_q_wrt_x * derivative_f_wrt_q // -4
		val derivative_f_wrt_y = derivative_q_wrt_y * derivative_f_wrt_q // -4
		
		val x1 = x + stepSize * derivative_f_wrt_x
		val y1 = y + stepSize * derivative_f_wrt_y
		
		// add
		val q = gate1(x1,y1)
		println("q:" + q)
		val derivative_f_wrt_z = q // 3 // not used...
		// gradient of the MULTIPLY gate with respect to its inputs
		val z1 = z + stepSize * derivative_f_wrt_z
	   
		// multiply
		val f = gate2(q, z1)
		println("f:" + f)
	}                                         //> forwardCircuit: (gate1: (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnet
                                                  //| works.karpathy.KarpathyLab_1.T) => neuralnetworks.karpathy.KarpathyLab_1.T)
                                                  //| (gate2: (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.K
                                                  //| arpathyLab_1.T) => neuralnetworks.karpathy.KarpathyLab_1.T)(stepSize: Doubl
                                                  //| e)(x: neuralnetworks.karpathy.KarpathyLab_1.T, y: neuralnetworks.karpathy.K
                                                  //| arpathyLab_1.T, z: neuralnetworks.karpathy.KarpathyLab_1.T)Unit
   
   val x = -2                                     //> x  : Int = -2
   val y = 5                                      //> y  : Int = 5
   val z = -4                                     //> z  : Int = -4
   
   val c1 = forwardCircuit(forwardAddGate)(forwardMultiplyGate)(0.01)_
                                                  //> c1  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Kar
                                                  //| pathyLab_1.T, neuralnetworks.karpathy.KarpathyLab_1.T) => Unit = <function3
                                                  //| >
   c1(x,y,z)                                      //> q:2.92
                                                  //| f:-11.594736
  
}
/*


*/