package lab.math.aleks.calculus_prep

import math._

object Limit_funcs_1 {

  def f1(x: Double): Double = {
  		val numer = 6 - 3 * sqrt(3*x - 14)
  		val denom = 6 - x
  		numer/denom
  }                                               //> f1: (x: Double)Double
  
  f1(5)                                           //> res0: Double = 3.0
  f1(5.5)                                         //> res1: Double = 2.513167019494862
  f1(5.9)                                         //> res2: Double = 2.293847814985951
  f1(5.999)                                       //> res3: Double = 2.250422033276104
  f1(5.99999)                                     //> res4: Double = 2.2500042187586757
  
  f1(6.000000001)                                 //> res5: Double = 2.25
  f1(6.00001)                                     //> res6: Double = 2.2499957812413243
  f1(6.001)                                       //> res7: Double = 2.249578283128132
  f1(6.1)                                         //> res8: Double = 2.2093240599831523
  f1(6.5)                                         //> res9: Double = 2.0712472794702883
  f1(7)                                           //> res10: Double = 1.9372539331937721
  
  def f2(x: Double): Double = {
  		val numer = pow((x + 4), 3) - 64
  		val denom = 4*x
  		numer/denom
  }                                               //> f2: (x: Double)Double
  
  f2(-0.001)                                      //> res11: Double = 11.99700024999828
  f2(-0.00001)                                    //> res12: Double = 11.99997000007613
  f2(0.00001)                                     //> res13: Double = 12.000029999725824
  f2(0.001)                                       //> res14: Double = 12.003000250004447
}