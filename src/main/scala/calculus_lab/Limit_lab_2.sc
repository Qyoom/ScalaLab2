package calculus_lab

import math._

object Limit_lab_2 {

  def f(x: Double): Double = {
  		(2*pow(x,2) - 2) / (x - 1)
  }                                               //> f: (x: Double)Double
  
  f(1)                                            //> res0: Double = NaN
  f(.99)                                          //> res1: Double = 3.980000000000002
  f(.999)                                         //> res2: Double = 3.9979999999999425
  f(.9999)                                        //> res3: Double = 3.999799999998995
  f(.99999)                                       //> res4: Double = 3.999979999998345
  f(.999999)                                      //> res5: Double = 3.9999980000442434
  f(.9999999)                                     //> res6: Double = 3.9999998001598556
  f(.99999999)                                    //> res7: Double = 3.9999999777955395
  f(.999999999)                                   //> res8: Double = 4.0
  
  f(1.9)                                          //> res9: Double = 5.800000000000001
  f(1.09)                                         //> res10: Double = 4.18
  f(1.009)                                        //> res11: Double = 4.018
  f(1.0009)                                       //> res12: Double = 4.001799999999916
  f(1.00009)                                      //> res13: Double = 4.000180000000091
  f(1.000009)                                     //> res14: Double = 4.000018000021226
  f(1.0000009)                                    //> res15: Double = 4.000001800041597
  f(1.00000009)                                   //> res16: Double = 4.000000177635684
  f(1.000000009)                                  //> res17: Double = 4.0
}