package neuralnetworks.karpathy

object karpathy_lab_1_ws {
	// http://karpathy.github.io/neuralnets/
	/* As with this example, all of our gates will take one or two inputs
	 * and produce a single output value.
	 */
		
	def forwardGate[T](op: (T,T)=>T)(x: T, y: T) = {
		op(x,y)
	}                                         //> forwardGate: [T](op: (T, T) => T)(x: T, y: T)T
	
	type T = Double
	val forwardMultiplyGate = forwardGate[T]({(x,y) => x*y})_
                                                  //> forwardMultiplyGate  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuraln
                                                  //| etworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_la
                                                  //| b_1_ws.T = <function2>
  val forwardAddGate = forwardGate[T]({(x,y) => x+y})_
                                                  //> forwardAddGate  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetwor
                                                  //| ks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_lab_1_w
                                                  //| s.T = <function2>
  val forwardDivideGate = forwardGate[T]({(x,y) => x/y})_
                                                  //> forwardDivideGate  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnet
                                                  //| works.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_lab_
                                                  //| 1_ws.T = <function2>
  val forwardSubtractGate = forwardGate[T]({(x,y) => x-y})_
                                                  //> forwardSubtractGate  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuraln
                                                  //| etworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_la
                                                  //| b_1_ws.T = <function2>
  val forwardModuloGate = forwardGate[T]({(x,y) => x%y})_
                                                  //> forwardModuloGate  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnet
                                                  //| works.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_lab_
                                                  //| 1_ws.T = <function2>
  // Test
  forwardMultiplyGate(3,7)                        //> res0: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 21.0
  forwardAddGate(3,7)                             //> res1: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 10.0
  forwardDivideGate(3,7)                          //> res2: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 0.42857142857142855
  forwardSubtractGate(3,7)                        //> res3: neuralnetworks.karpathy.karpathy_lab_1_ws.T = -4.0
  forwardModuloGate(3,7)                          //> res4: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 3.0
  
  // ------------------------------------ //
  // http://karpathy.github.io/neuralnets/
  
  val x = -2d                                     //> x  : Double = -2.0
  val y = 3d                                      //> y  : Double = 3.0
  forwardMultiplyGate(x,y)                        //> res5: neuralnetworks.karpathy.karpathy_lab_1_ws.T = -6.0
  
  // ----- Recursive, immutable, curried version ------------------ //
  
  // try changing x,y randomly small amounts and keep track of what works best
  def randomLocalSearch(gate: (T,T)=>T)(tweak:Double)(iter:Int)(x:T,y:T) = {
  		def inter(iter:Int, bestOut:T, bestX:T, bestY:T): (T,T,T) = {
  			if(iter > 0) {
  				val newX = bestX + tweak * (Math.random() * 2 - 1) // tweak x a bit
  				val newY = bestY + tweak * (Math.random() * 2 - 1) // tweak x a bit
  				val newOut = gate(newX, newY)
  				if(newOut > bestOut) inter(iter-1, newOut, newX, newY)
  				else inter(iter-1, bestOut, bestX, bestY)
  			}
  			else (bestOut, bestX, bestY)
  		}
  		inter(iter, Double.NegativeInfinity, x, y)
  }                                               //> randomLocalSearch: (gate: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neu
                                                  //| ralnetworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpat
                                                  //| hy_lab_1_ws.T)(tweak: Double)(iter: Int)(x: neuralnetworks.karpathy.karpath
                                                  //| y_lab_1_ws.T, y: neuralnetworks.karpathy.karpathy_lab_1_ws.T)(neuralnetwork
                                                  //| s.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T
                                                  //| , neuralnetworks.karpathy.karpathy_lab_1_ws.T)

  val forwardMultSearch = randomLocalSearch(forwardMultiplyGate)_
                                                  //> forwardMultSearch  : Double => (Int => ((neuralnetworks.karpathy.karpathy_l
                                                  //| ab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) => (neuralnetworks.
                                                  //| karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T, 
                                                  //| neuralnetworks.karpathy.karpathy_lab_1_ws.T))) = <function1>
  val search1 = forwardMultSearch(0.01)(100)      //> search1  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.kar
                                                  //| pathy.karpathy_lab_1_ws.T) => (neuralnetworks.karpathy.karpathy_lab_1_ws.T,
                                                  //|  neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpa
                                                  //| thy_lab_1_ws.T) = <function2>

  search1(x,y)                                    //> res6: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy
                                                  //| .karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) = (-5.31
                                                  //| 3994225160271,-1.836753201152012,2.8931454818357376)
  
  
}