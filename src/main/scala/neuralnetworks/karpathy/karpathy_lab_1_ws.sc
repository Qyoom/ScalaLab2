package neuralnetworks.karpathy

import neuralnetworks.karpathy.KarpathyLab_1._
import scala.math._

object karpathy_lab_1_ws {

	type T = Double
 
  // Test
  forwardMultiplyGate(3,7)                        //> res0: neuralnetworks.karpathy.KarpathyLab_1.T = 21.0
  forwardAddGate(3,7)                             //> res1: neuralnetworks.karpathy.KarpathyLab_1.T = 10.0
  forwardDivideGate(3,7)                          //> res2: neuralnetworks.karpathy.KarpathyLab_1.T = 0.42857142857142855
  forwardSubtractGate(3,7)                        //> res3: neuralnetworks.karpathy.KarpathyLab_1.T = -4.0
  forwardModuloGate(3,7)                          //> res4: neuralnetworks.karpathy.KarpathyLab_1.T = 3.0
  forwardMaxGate(3,7)                             //> res5: neuralnetworks.karpathy.KarpathyLab_1.T = 7.0
  forwardExpGate(3.7)                             //> res6: neuralnetworks.karpathy.KarpathyLab_1.T = 40.4473043600674
  
  // ------------------------------------ //
  // http://karpathy.github.io/neuralnets/
  
  val x = -2d                                     //> x  : Double = -2.0
  val y = 3d                                      //> y  : Double = 3.0
  forwardMultiplyGate(x,y)                        //> res7: neuralnetworks.karpathy.KarpathyLab_1.T = -6.0
  
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
  		inter(iter, gate(x, y), x, y)
  }                                               //> randomLocalSearch: (gate: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neu
                                                  //| ralnetworks.karpathy.karpathy_lab_1_ws.T) => neuralnetworks.karpathy.karpat
                                                  //| hy_lab_1_ws.T)(tweak: Double)(iter: Int)(x: neuralnetworks.karpathy.karpath
                                                  //| y_lab_1_ws.T, y: neuralnetworks.karpathy.karpathy_lab_1_ws.T)(neuralnetwork
                                                  //| s.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T
                                                  //| , neuralnetworks.karpathy.karpathy_lab_1_ws.T)
  // ---------------------------------------------- //

  val forwardMultSearch = randomLocalSearch(forwardMultiplyGate)_
                                                  //> forwardMultSearch  : Double => (Int => ((neuralnetworks.karpathy.karpathy_l
                                                  //| ab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) => (neuralnetworks.
                                                  //| karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T, 
                                                  //| neuralnetworks.karpathy.karpathy_lab_1_ws.T))) = <function1>
  val search1 = forwardMultSearch(0.01)(100)      //> search1  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.kar
                                                  //| pathy.karpathy_lab_1_ws.T) => (neuralnetworks.karpathy.karpathy_lab_1_ws.T,
                                                  //|  neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpa
                                                  //| thy_lab_1_ws.T) = <function2>

  search1(x,y)                                    //> res8: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy
                                                  //| .karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) = (-5.12
                                                  //| 540017132776,-1.7799767525886911,2.8794759054429706)
  val search2 = randomLocalSearch(forwardMaxGate)(0.01)(100)_
                                                  //> search2  : (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.kar
                                                  //| pathy.karpathy_lab_1_ws.T) => (neuralnetworks.karpathy.karpathy_lab_1_ws.T,
                                                  //|  neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpa
                                                  //| thy_lab_1_ws.T) = <function2>
  search2(x,y)                                    //> res9: (neuralnetworks.karpathy.karpathy_lab_1_ws.T, neuralnetworks.karpathy
                                                  //| .karpathy_lab_1_ws.T, neuralnetworks.karpathy.karpathy_lab_1_ws.T) = (3.273
                                                  //| 6083023193823,-1.9420780751722968,3.2736083023193823)
  
  /* // http://karpathy.github.io/neuralnets/
   * "So, we're done, right? Not quite: This is a perfectly fine strategy for tiny problems
   * with a few gates if you can afford the compute time, but it won't do if we want to
   * eventually consider huge circuits with millions of inputs. It turns out that we can
   * do much better."
   */
}
/*


*/