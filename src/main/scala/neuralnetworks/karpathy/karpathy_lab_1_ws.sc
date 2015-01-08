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
  forwardMultiplyGate(3,7)                        //> res0: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 21.0
  forwardAddGate(3,7)                             //> res1: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 10.0
  forwardDivideGate(3,7)                          //> res2: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 0.42857142857142855
  forwardSubtractGate(3,7)                        //> res3: neuralnetworks.karpathy.karpathy_lab_1_ws.T = -4.0
  forwardModuloGate(3,7)                          //> res4: neuralnetworks.karpathy.karpathy_lab_1_ws.T = 3.0
  
  // ------------------------------- //
  val x = -2d                                     //> x  : Double = -2.0
  val y = 3d                                      //> y  : Double = 3.0
  forwardMultiplyGate(x,y)                        //> res5: neuralnetworks.karpathy.karpathy_lab_1_ws.T = -6.0
  
  // try changing x,y randomly small amounts and keep track of what works best
	var tweak_amount = 0.01                   //> tweak_amount  : Double = 0.01
	var best_out = Double.NegativeInfinity    //> best_out  : Double = -Infinity
	var best_x = x                            //> best_x  : Double = -2.0
	var best_y = y                            //> best_y  : Double = 3.0
	for(k <- 1 to 100) {
	  var x_try = x + tweak_amount * (Math.random() * 2 - 1) // tweak x a bit
	  var y_try = y + tweak_amount * (Math.random() * 2 - 1) // tweak y a bit
	  var out = forwardMultiplyGate(x_try, y_try);
	  if(out > best_out) {
	    // best improvement yet! Keep track of the x and y
	    best_out = out
	    best_x = x_try
	    best_y = y_try
	  }
	}
  best_out                                        //> res6: Double = -5.953532407001166
  best_x                                          //> res7: Double = -1.9903346559611246
  best_y                                          //> res8: Double = 2.9912217973847364
  
  // ----- Recursive, immutable version ------------------ //
  
  def randomLocalSearch(gate: (T,T)=>T)(tweak:Double)(iter:Int)(x:T,y:T) = {
  		def inter(iter:Int, bestOut:T, bestX:T, bestY:T) = {
  			if(iter > 0) {
  				gate(x,y)
  			}
  			else 0.0
  		}
  		inter(iter, Double.NegativeInfinity, x, y)
  }                                               //> randomLocalSearch: (gate: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neu
                                                  //| ralnetworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpat
                                                  //| hy_lab_1_ws.T)(tweak: Double)(iter: Int)(x: neuralnetworks.karpathy.karpath
                                                  //| y_lab_1_ws.T, y: neuralnetworks.karpathy.karpathy_lab_1_ws.T)neuralnetworks
                                                  //| .karpathy.karpathy_lab_1_ws.T

  val forwardMultSearch = randomLocalSearch(forwardMultiplyGate)_
                                                  //> forwardMultSearch  : Double => (Int => ((neuralnetworks.karpathy.karpathy_l
                                                  //| ab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.k
                                                  //| arpathy.karpathy_lab_1_ws.T)) = <function1>
  val search1 = forwardMultSearch(0.01)(100)      //> search1  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.kar
                                                  //| pathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpathy_lab_1_ws.T =
                                                  //|  <function2>

  search1(x,y)                                    //> res9: neuralnetworks.karpathy.karpathy_lab_1_ws.T = -6.0
  
  
}