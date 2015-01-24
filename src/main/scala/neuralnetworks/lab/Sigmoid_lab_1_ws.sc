package neuralnetworks.lab

import scala.math._

object Sigmoid_lab_1_ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // http://ufldl.stanford.edu/wiki/index.php/Neural_Networks
  def f(z: Double) = {
  		1 / 1 + exp(-z)
  }                                               //> f: (z: Double)Double
  
  // http://en.wikipedia.org/wiki/Sigmoid_function
  def S(t: Double) = {
  		1 / 1 + pow(E, -t)
  }                                               //> S: (t: Double)Double
  
  // ----------------------------------- //
  
  // derivative of sigmoid function
  def f_deriv(z: Double) = {
  		f(z) * (1 - f(z))
  }                                               //> f_deriv: (z: Double)Double
  
  // ----------------------------------- //
  
  f_deriv(.7)                                     //> res0: Double = -0.7431822677330158
  f_deriv(1)                                      //> res1: Double = -0.503214724408055
  f_deriv(10)                                     //> res2: Double = -4.540199091611318E-5
  f_deriv(.01)                                    //> res3: Double = -1.9702485070559235
  
  // ----------------------------------- //
  
  f(4)                                            //> res4: Double = 1.0183156388887342
  S(4)                                            //> res5: Double = 1.0183156388887342
  f(1)                                            //> res6: Double = 1.3678794411714423
  S(1)                                            //> res7: Double = 1.3678794411714423
  f(.1)                                           //> res8: Double = 1.9048374180359595
  S(.1)                                           //> res9: Double = 1.9048374180359595
  f(10)                                           //> res10: Double = 1.0000453999297625
  S(10)                                           //> res11: Double = 1.0000453999297625
}