package neuralnetworks.lab

import scala.math._

object Sigmoid_lab_1_ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // http://ufldl.stanford.edu/wiki/index.php/Neural_Networks
  def S_1(z: Double) = {
  		1 / 1 + exp(-z)
  }                                               //> S_1: (z: Double)Double
  
  // http://en.wikipedia.org/wiki/Sigmoid_function
  def S_2(t: Double) = {
  		1 / 1 + pow(E, -t)
  }                                               //> S_2: (t: Double)Double
  
  // ----------------------------------- //
  
  S_1(4)                                          //> res0: Double = 1.0183156388887342
  S_2(4)                                          //> res1: Double = 1.0183156388887342
  S_1(1)                                          //> res2: Double = 1.3678794411714423
  S_2(1)                                          //> res3: Double = 1.3678794411714423
  S_1(.1)                                         //> res4: Double = 1.9048374180359595
  S_2(.1)                                         //> res5: Double = 1.9048374180359595
  S_1(10)                                         //> res6: Double = 1.0000453999297625
  S_2(10)                                         //> res7: Double = 1.0000453999297625
}