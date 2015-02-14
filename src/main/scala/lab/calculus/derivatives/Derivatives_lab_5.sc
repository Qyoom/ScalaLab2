package lab.calculus.derivatives

import lab.calculus.derivatives.Derivative3._
import scala.math._
import lab.math.NthRoot._
import lab.math.vectorspace.VectorSpaceFunctions_lab_1._

object Derivatives_lab_5 {

	/** Collins Intro Calculus, Ch.3 Derivatives - Shortcuts (Rules), p.92 **/
	
	///////////////////////////////////////////////////////////////////
	// The derivative of a constant is 0
	def f1(x: Double) = 5                     //> f1: (x: Double)Int
	
	// ----- Model A ----------------------- //
	
	val dmA_f1 = derivative_model_A(f1)_      //> dmA_f1  : Double => Double = <function1>
	dmA_f1(1)                                 //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| res0: Double = -0.0
	dmA_f1(-1)                                //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| res1: Double = 0.0
	dmA_f1(3)                                 //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| derivative step: -0.0
                                                  //| res2: Double = -0.0
	dmA_f1(-3)                                //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| derivative step: 0.0
                                                  //| res3: Double = 0.0
	dmA_f1(0.5)                               //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| res4: Double = -0.0
	dmA_f1(-0.5)                              //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| res5: Double = 0.0
  
  // ----- Model B ----------------------- //
	
	val dmB_f1 = derivative_model_B(f1)_      //> dmB_f1  : Double => Double = <function1>
	dmB_f1(1)                                 //> res6: Double = 0.0
	dmB_f1(-1)                                //> res7: Double = 0.0
	dmB_f1(3)                                 //> res8: Double = 0.0
	dmB_f1(-3)                                //> res9: Double = 0.0
	dmB_f1(0.5)                               //> res10: Double = 0.0
	dmB_f1(-0.5)                              //> res11: Double = 0.0
	
	///////////////////////////////////////////////////////////////////
	// The Power Rule: The derivative of x^n is n*x^(n-1)
	def f2(x: Double) = pow(x,4)              //> f2: (x: Double)Double
	// Derivative: 4 * pow(x, 4-1)
	
	// ----- Model A ----------------------- //
	
	val dmA_f2 = derivative_model_A(f2)_      //> dmA_f2  : Double => Double = <function1>
	4 * pow(1, 4-1)                           //> res12: Double = 4.0
	dmA_f2(1)                                 //> initial slope: 1.0
                                                  //| derivative step: 3.9999400003947154
                                                  //| res13: Double = 3.9999400003947154
  4 * pow(-1, 4-1)                                //> res14: Double = -4.0
	dmA_f2(-1)                                //> initial slope: -1.0
                                                  //| derivative step: -3.9999400003947154
                                                  //| res15: Double = -3.9999400003947154
  4 * pow(3, 4-1)                                 //> res16: Double = 108.0
	dmA_f2(3)                                 //> initial slope: 27.0
                                                  //| derivative step: 107.99838001099778
                                                  //| derivative step: 107.9999763152441
                                                  //| res17: Double = 107.9999763152441
  4 * pow(-3, 4-1)                                //> res18: Double = -108.0
	dmA_f2(-3)                                //> initial slope: -27.0
                                                  //| derivative step: -107.99838001099778
                                                  //| derivative step: -107.9999763152441
                                                  //| res19: Double = -107.9999763152441
  4 * pow(0.5, 4-1)                               //> res20: Double = 0.5
	dmA_f2(0.5)                               //> initial slope: 0.125
                                                  //| derivative step: 0.49999250004933943
                                                  //| res21: Double = 0.49999250004933943
  4 * pow(-0.5, 4-1)                              //> res22: Double = -0.5
	dmA_f2(-0.5)                              //> initial slope: -0.125
                                                  //| derivative step: -0.49999250004933943
                                                  //| res23: Double = -0.49999250004933943
  
  // ----- Model B ----------------------- //
	
	val dmB_f2 = derivative_model_B(f2)_      //> dmB_f2  : Double => Double = <function1>
	dmB_f2(1)                                 //> res24: Double = 4.000000330961484
	dmB_f2(-1)                                //> res25: Double = -4.000000330961484
	dmB_f2(3)                                 //> res26: Double = 107.99993788168649
	dmB_f2(-3)                                //> res27: Double = -108.00007999023364
	dmB_f2(0.5)                               //> res28: Double = 0.5000000413701855
	dmB_f2(-0.5)                              //> res29: Double = -0.5000000413701855
	
	///////////////////////////////////////////////////////////////////
	// The derivative of a constant times a function is
	// the constant times the derivative of the function.
	def f3(x: Double) = 5 * pow(x, 3)         //> f3: (x: Double)Double
	// Derivative: 15*x^2
	
	// ----- Model A ----------------------- //
	
	val dmA_f3 = derivative_model_A(f3)_      //> dmA_f3  : Double => Double = <function1>
	
	15*pow(1,2)                               //> res30: Double = 15.0
	dmA_f3(1)                                 //> initial slope: 5.0
                                                  //| derivative step: 14.999850000464985
                                                  //| res31: Double = 14.999850000464985
  15*pow(-1,2)                                    //> res32: Double = 15.0
	dmA_f3(-1)                                //> initial slope: 5.0
                                                  //| derivative step: 14.999850000464985
                                                  //| res33: Double = 14.999850000464985
  15*pow(3,2)                                     //> res34: Double = 135.0
	dmA_f3(3)                                 //> initial slope: 45.0
                                                  //| derivative step: 134.99865000424037
                                                  //| derivative step: 134.99998223643308
                                                  //| res35: Double = 134.99998223643308
  15*pow(-3,2)                                    //> res36: Double = 135.0
	dmA_f3(-3)                                //> initial slope: 45.0
                                                  //| derivative step: 134.99865000424037
                                                  //| derivative step: 134.99998223643308
                                                  //| res37: Double = 134.99998223643308
  15*pow(0.5,2)                                   //> res38: Double = 3.75
	dmA_f3(0.5)                               //> initial slope: 1.25
                                                  //| derivative step: 3.749962500116246
                                                  //| res39: Double = 3.749962500116246
  15*pow(-0.5,2)                                  //> res40: Double = 3.75
	dmA_f3(-0.5)                              //> initial slope: 1.25
                                                  //| derivative step: 3.749962500116246
                                                  //| res41: Double = 3.749962500116246
	
  // ----- Model B ----------------------- //
  
  val dmB_f3 = derivative_model_B(f3)_            //> dmB_f3  : Double => Double = <function1>
	dmB_f3(1)                                 //> res42: Double = 15.000001241105565
	dmB_f3(-1)                                //> res43: Double = 15.000001241105565
	dmB_f3(3)                                 //> res44: Double = 134.9999934063817
	dmB_f3(-3)                                //> res45: Double = 134.9999934063817
	dmB_f3(0.5)                               //> res46: Double = 3.7500003102763912
	dmB_f3(-0.5)                              //> res47: Double = 3.7500003102763912
	
	///////////////////////////////////////////////////////////////////
	// The derivative of a sum or difference of functions is the sum or
	// difference of the derivatives, respectively.
	def f4(x: Double) = pow(x,2) + pow(x,5)   //> f4: (x: Double)Double
	// Derivative: 2*x + 5*pow(x,4)
	
	// ----- Model B ----------------------- //
  
  val dmB_f4 = derivative_model_B(f4)_            //> dmB_f4  : Double => Double = <function1>
  
  2*1 + 5*pow(1,4)                                //> res48: Double = 7.0
	dmB_f4(1)                                 //> res49: Double = 7.000000579182597
	
	2*(-1) + 5*pow(-1,4)                      //> res50: Double = 3.0
	dmB_f4(-1)                                //> res51: Double = 3.000000248221113
	
	2*3 + 5*pow(3,4)                          //> res52: Double = 411.0
	dmB_f4(3)                                 //> res53: Double = 411.00008729699766
	
	2*(-3) + 5*pow(-3,4)                      //> res54: Double = 399.0
	dmB_f4(-3)                                //> res55: Double = 398.9998731412925
	
	2*0.5 + 5*pow(0.5,4)                      //> res56: Double = 1.3125
	dmB_f4(0.5)                               //> res57: Double = 1.312500108596737
	
	2*(-0.5) + 5*pow(-0.5,4)                  //> res58: Double = -0.6875
	dmB_f4(-0.5)                              //> res59: Double = -0.6875000568840051
	
	// ===== Tests ============================== //
	
	// ----- Example 3.4(a) ----- //
	def f5(x: Double) = 4*pow(x,3) - 7*pow(x,2) + 2
                                                  //> f5: (x: Double)Double
  // Derivative: 12*x^2 - 14*x
	val dmB_f5 = derivative_model_B(f5)_      //> dmB_f5  : Double => Double = <function1>
	
	12*pow(1,2) - 14*1                        //> res60: Double = -2.0
	dmB_f5(1)                                 //> res61: Double = -2.000000165480742
	
	12*pow(-2,2) - 14*(-2)                    //> res62: Double = 76.0
	dmB_f5(-2)                                //> res63: Double = 76.0000062882682
	
	// ----- Example 3.4(b) ----- //
	///// HAVING TROUBLE WITH THIS ONE!!
	def f6(x: Double) = nthRoot(x,3) + (5d/sqrt(x))
                                                  //> f6: (x: Double)Double
	//def f6(x: Double) = pow(x,-(1d/3)) + (5/sqrt(x))
	// Derivative: 1/3 * pow(x,-2/3) - (5/2)*pow(x,-3/2)
	val dmB_f6 = derivative_model_B(f6)_      //> dmB_f6  : Double => Double = <function1>
	
	(1d/3d) * pow(1,-(2d/3d)) - (5d/2d)*pow(1,-(3d/2d))
                                                  //> res64: Double = -2.1666666666666665
	dmB_f6(1)                                 //> res65: Double = -2.000000165480742
	
	(1d/3d) * pow(1.1,-2d/3d) - (5d/2d)*pow(1.1,-3d/2d)
                                                  //> res66: Double = -1.8541482739047193
	dmB_f6(1.1)                               //> res67: Double = -1.666968785229983
	
	val dmA_f6 = derivative_model_A(f6)_      //> dmA_f6  : Double => Double = <function1>
	//dmA_f6(1.1) // spins - doesn't resolve
	
	// ----- Example 3.5 ----- //
	def f7(x: Double) = pow(x,3) + 2*x + 1    //> f7: (x: Double)Double
	val dmA_f7 = derivative_model_A(f7, 4)_   //> dmA_f7  : Double => Double = <function1>
	dmA_f7(1)                                 //> initial slope: 23.0
                                                  //| derivative step: 5.000090000895626
                                                  //| derivative step: 5.0
                                                  //| res68: Double = 5.0
  // point-slope form of a line
  // y = mx + b
  // Correct point slope form at (1,4): y = 5x - 1
  // solveFor(y, x, yIntercept, slope, errorTerm)
  solveFor(Some(4d), Some(1d), None, Some(5d), None)
                                                  //> res69: (String, Double) = (yIntercept,-1.0)
  solveFor(None, Some(1d), Some(-1d), Some(5d), None)
                                                  //> res70: (String, Double) = (y,4.0)
  solveFor(Some(4d), None, Some(-1d), Some(5d), None)
                                                  //> res71: (String, Double) = (x,1.0)
}
/*



*/