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
  	
  	def forwardCircuit(gate1: (T,T)=>T)(gate2: (T,T)=>T)(stepSize: Double)(x0:T, y0:T, z:T) = {
		// This is all a bunch of unsatisfying simplistic voodoo by the tut author
		// but I'm going through the motions...!
	  
		val x1 = gate1(x0,y0)
		val y1 = z
		
		val x_gradient = y1
		val y_gradient = x1
		
		val x2 = x1 + stepSize * x_gradient
		val y2 = y1 + stepSize * y_gradient
	  
		gate2(x2, y2)
	}
}