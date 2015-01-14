package neuralnetworks.karpathy

import scala.math._

object KarpathyLab_1 {

  	// http://karpathy.github.io/neuralnets/
	// Strategy #1: Random Local Search
	
	/* "As with this example, all of our gates will take one or two inputs
	 * and produce a single output value."
	 */
		
	def forwardBinaryGate[T](op: (T,T)=>T)(x: T, y: T) = {
		op(x,y)
	}                                         
	
	def forwardUnaryGate[T](op: T=>T)(x: T) = {
		op(x)
	}
	
	type T = Double
	val forwardMultiplyGate = forwardBinaryGate[T]({(x,y) => x*y})_
	val forwardAddGate = forwardBinaryGate[T]({(x,y) => x+y})_
	val forwardDivideGate = forwardBinaryGate[T]({(x,y) => x/y})_
	val forwardSubtractGate = forwardBinaryGate[T]({(x,y) => x-y})_
	val forwardModuloGate = forwardBinaryGate[T]({(x,y) => x%y})_
  	val forwardMaxGate = forwardBinaryGate[T]({(x,y) => max(x,y)})_
  	val forwardExpGate = forwardUnaryGate[T]({x => exp(x)})_
  	
  	def forwardMultiplyDerivGate(step_size:T)(x:T, y:T) = forwardBinaryGate[T]({
	  (x,y) => (step_size + x) * (step_size + y)
	})_
  	
	// gate1: add, gate2: multiply
  	def forwardCircuit(gate1: (T,T)=>T)(gate2: (T,T)=>T)(stepSize: Double)(x:T, y:T, z:T) = {
		// This is all a bunch of unsatisfying simplistic voodoo by the tut author
		// but I'm going through the motions...!
	  
		// add
		val q = gate1(x,y) // 3.0
		println("q:" + q) 
	   
		// multiply
		val f = gate2(q, z)
		println("f:" + f) // -12.0
		
		// gradient of the MULTIPLY gate with respect to its inputs
		// wrt is short for "with respect to"
		val derivative_f_wrt_z = q // 3
		val derivative_f_wrt_q = z // -4

		// derivative of the ADD gate with respect to its inputs
		val derivative_q_wrt_x = 1.0
		val derivative_q_wrt_y = 1.0
		
		// chain rule
		val derivative_f_wrt_x = derivative_q_wrt_x * derivative_f_wrt_q // -4
		val derivative_f_wrt_y = derivative_q_wrt_y * derivative_f_wrt_q // -4
	}
}