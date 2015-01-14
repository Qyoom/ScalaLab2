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
}