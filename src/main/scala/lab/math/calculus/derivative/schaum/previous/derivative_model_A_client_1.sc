package lab.math.calculus.derivative.schaum.previous

object derivative_model_A_client_1 {
  import lab.math.calculus.derivative.schaum.previous.My_Early_Primative_Derivative.derivative_model_A
  import scala.math._
  import lab.math.NthRoot._

  /** Collins Intro Calculus, Ch.3 Derivatives - Shortcuts (Rules), p.92 **/
  
  ///////////////////////////////////////////////////////////////////
  // The derivative of a constant is 0
  def f1(x: Double) = 5                           //> f1: (x: Double)Int
  
  val dmA_f1 = derivative_model_A(f1)_            //> dmA_f1  : Double => Double = <function1>
  dmA_f1(1)                                       //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| res0: Double = -0.0
  dmA_f1(-1)                                      //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| res1: Double = 0.0
  dmA_f1(3)                                       //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| derivative step: -0.0
                                                  //| res2: Double = -0.0
  dmA_f1(-3)                                      //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| derivative step: 0.0
                                                  //| res3: Double = 0.0
  dmA_f1(0.5)                                     //> initial slope: -0.0
                                                  //| derivative step: -0.0
                                                  //| res4: Double = -0.0
  dmA_f1(-0.5)                                    //> initial slope: 0.0
                                                  //| derivative step: 0.0
                                                  //| res5: Double = 0.0
    ///////////////////////////////////////////////////////////////////
  // The Power Rule: The derivative of x^n is n*x^(n-1)
  def f2(x: Double) = pow(x,4)                    //> f2: (x: Double)Double
  // Derivative: 4 * pow(x, 4-1)
  
  val dmA_f2 = derivative_model_A(f2)_            //> dmA_f2  : Double => Double = <function1>
  4 * pow(1, 4-1)                                 //> res6: Double = 4.0
  dmA_f2(1)                                       //> initial slope: 1.0
                                                  //| derivative step: 3.9999400003947154
                                                  //| res7: Double = 3.9999400003947154
  4 * pow(-1, 4-1)                                //> res8: Double = -4.0
  dmA_f2(-1)                                      //> initial slope: -1.0
                                                  //| derivative step: -3.9999400003947154
                                                  //| res9: Double = -3.9999400003947154
  4 * pow(3, 4-1)                                 //> res10: Double = 108.0
  dmA_f2(3)                                       //> initial slope: 27.0
                                                  //| derivative step: 107.99838001099778
                                                  //| derivative step: 107.9999763152441
                                                  //| res11: Double = 107.9999763152441
  4 * pow(-3, 4-1)                                //> res12: Double = -108.0
  dmA_f2(-3)                                      //> initial slope: -27.0
                                                  //| derivative step: -107.99838001099778
                                                  //| derivative step: -107.9999763152441
                                                  //| res13: Double = -107.9999763152441
  4 * pow(0.5, 4-1)                               //> res14: Double = 0.5
  dmA_f2(0.5)                                     //> initial slope: 0.125
                                                  //| derivative step: 0.49999250004933943
                                                  //| res15: Double = 0.49999250004933943
  4 * pow(-0.5, 4-1)                              //> res16: Double = -0.5
  dmA_f2(-0.5)                                    //> initial slope: -0.125
                                                  //| derivative step: -0.49999250004933943
                                                  //| res17: Double = -0.49999250004933943
  ///////////////////////////////////////////////////////////////////
  // The derivative of a constant times a function is
  // the constant times the derivative of the function.
  def f3(x: Double) = 5 * pow(x, 3)               //> f3: (x: Double)Double
  // Derivative: 15*x^2
    
  val dmA_f3 = derivative_model_A(f3)_            //> dmA_f3  : Double => Double = <function1>
  
  15*pow(1,2)                                     //> res18: Double = 15.0
  dmA_f3(1)                                       //> initial slope: 5.0
                                                  //| derivative step: 14.999850000464985
                                                  //| res19: Double = 14.999850000464985
  15*pow(-1,2)                                    //> res20: Double = 15.0
  dmA_f3(-1)                                      //> initial slope: 5.0
                                                  //| derivative step: 14.999850000464985
                                                  //| res21: Double = 14.999850000464985
  15*pow(3,2)                                     //> res22: Double = 135.0
  dmA_f3(3)                                       //> initial slope: 45.0
                                                  //| derivative step: 134.99865000424037
                                                  //| derivative step: 134.99998223643308
                                                  //| res23: Double = 134.99998223643308
  15*pow(-3,2)                                    //> res24: Double = 135.0
  dmA_f3(-3)                                      //> initial slope: 45.0
                                                  //| derivative step: 134.99865000424037
                                                  //| derivative step: 134.99998223643308
                                                  //| res25: Double = 134.99998223643308
  15*pow(0.5,2)                                   //> res26: Double = 3.75
  dmA_f3(0.5)                                     //> initial slope: 1.25
                                                  //| derivative step: 3.749962500116246
                                                  //| res27: Double = 3.749962500116246
  15*pow(-0.5,2)                                  //> res28: Double = 3.75
  dmA_f3(-0.5)                                    //> initial slope: 1.25
                                                  //| derivative step: 3.749962500116246
                                                  //| res29: Double = 3.749962500116246
  
  
  
  '''                                             //> res30: Char('\'') = '
}