package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._

object karpathy_lab_2_ws {
	// http://karpathy.github.io/neuralnets/
	// Stategy #2: Numerical Gradient

  type T = Double
	
	/* Applying derivative
	 * h is tweek amount
	 * alpha is amoutn that h is reduced with each iteration
	 */
  def numericalGradient(f: (T,T)=>T)(h: Double)(iter:Int)(alpha: Double)(x:T,y:T) = {
  		def inter(h: Double, iter: Int) {
	  		if(iter > 0) {
	  			val x_derivative = (f(x + h, y) - f(x, y)) / h
	  			val y_derivative = (f(x, y + h) - f(x, y)) / h
	  			println("x derivative: " + x_derivative + "   y derivative: " + y_derivative)
	  			inter(h * alpha, iter - 1)
  			}
  		}
  		inter(h, iter)
  }                                               //> numericalGradient: (f: (neuralnetworks.karpathy.karpathy_lab_2_ws.T, neuraln
                                                  //| etworks.karpathy.karpathy_lab_2_ws.T) => neuralnetworks.karpathy.karpathy_la
                                                  //| b_2_ws.T)(h: Double)(iter: Int)(alpha: Double)(x: neuralnetworks.karpathy.ka
                                                  //| rpathy_lab_2_ws.T, y: neuralnetworks.karpathy.karpathy_lab_2_ws.T)Unit
  
  // ------------------------------------- //
  
  val x = -2d                                     //> x  : Double = -2.0
  val y = 3d                                      //> y  : Double = 3.0
  
  //val h = .01
  //val h = 5
  val h = .0001                                   //> h  : Double = 1.0E-4
  
  val iter = 10                                   //> iter  : Int = 10
  val alpha = .1                                  //> alpha  : Double = 0.1
  
  // ------------------------------------- //
  // Note that with the numericalGradient algo the derivative of x is y and visa versa.
  
  numericalGradient(forwardMultiplyGate)(h)(iter)(alpha)(x, y)
                                                  //> x derivative: 3.00000000000189   y derivative: -2.0000000000042206
                                                  //| x derivative: 3.000000000064062   y derivative: -2.0000000000131024
                                                  //| x derivative: 2.999999999531155   y derivative: -2.0000000002795555
                                                  //| x derivative: 2.999999999531155   y derivative: -1.9999999967268418
                                                  //| x derivative: 2.999999981767586   y derivative: -1.9999999878450574
                                                  //| x derivative: 3.0000002482211117   y derivative: -2.000000165480741
                                                  //| x derivative: 3.000000248221111   y derivative: -2.000000165480741
                                                  //| x derivative: 3.000000248221111   y derivative: -2.0000001654807407
                                                  //| x derivative: 3.0002667017470213   y derivative: -2.0001778011646807
                                                  //| x derivative: 3.0020430585864215   y derivative: -1.9984014443252804
  
  numericalGradient(forwardMultiplyGate)(h)(iter)(alpha)(2, 5)
                                                  //> x derivative: 5.000000000006111   y derivative: 1.9999999999953388
                                                  //| x derivative: 4.999999999988347   y derivative: 1.9999999999242843
                                                  //| x derivative: 5.000000001587067   y derivative: 2.0000000002795555
                                                  //| x derivative: 4.999999987376213   y derivative: 2.000000005608626
                                                  //| x derivative: 5.000000058430485   y derivative: 1.9999999878450574
                                                  //| x derivative: 5.000000413701852   y derivative: 2.000000165480741
                                                  //| x derivative: 5.000000413701852   y derivative: 2.000000165480741
                                                  //| x derivative: 5.000089231543822   y derivative: 2.0000001654807407
                                                  //| x derivative: 5.000444502911702   y derivative: 2.0001778011646807
                                                  //| x derivative: 4.9915627187147   y derivative: 2.0072832285222817
  
  // ========================================================================== //

	val f = forwardMultiplyGate               //> f  : (neuralnetworks.karpathy.KarpathyLab_1.T, neuralnetworks.karpathy.Karp
                                                  //| athyLab_1.T) => neuralnetworks.karpathy.KarpathyLab_1.T = <function2>
  
  val h1 = .1                                     //> h1  : Double = 0.1
  val h01 = .01                                   //> h01  : Double = 0.01
  val h001 = .001                                 //> h001  : Double = 0.001
  val h0001 = .0001                               //> h0001  : Double = 1.0E-4
  val h0000001 = .0000001                         //> h0000001  : Double = 1.0E-7
  val h0000000001 = .0000000001                   //> h0000000001  : Double = 1.0E-10
  
  f(x,y)                                          //> res0: neuralnetworks.karpathy.KarpathyLab_1.T = -6.0
  f(x + h01,y) - f(x,y)                           //> res1: Double = 0.03000000000000025
  (f(x + h01,y) - f(x,y)) / h01                   //> res2: Double = 3.000000000000025
  //............................//
  (f(x + h001,y) - f(x,y)) / h001                 //> res3: Double = 3.0000000000001137
  (f(x + h0001,y) - f(x,y)) / h0001               //> res4: Double = 3.00000000000189
  (f(x + h0000001,y) - f(x,y)) / h0000001         //> res5: Double = 2.9999999995311555
  (f(x + h0000000001,y) - f(x,y)) / h0000000001   //> res6: Double = 3.000000248221113
  //............................//
  (f(x + h1,y) - f(x,y)) / h1                     //> res7: Double = 3.000000000000007
}
/*




*/