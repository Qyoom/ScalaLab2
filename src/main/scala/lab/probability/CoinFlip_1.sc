package lab.probability

import math._

object CoinFlip_1 {
  
  def p(x: Double) = {
  		pow(1/2d, x) * pow(1/2d, 1-x)
  	}                                         //> p: (x: Double)Double
  	
  	def p2(x: Double) = {
  		pow(.3, x) * pow(.7, 1-x)
  	}                                         //> p2: (x: Double)Double
  	
  	def p3(theta: Double, x: Double) = {
  		pow(theta, x) * pow(1 - theta, 1 - x)
  	}                                         //> p3: (theta: Double, x: Double)Double
  	
  	/**** EQUAL Probability ****/
  	// heads
  p(1)                                            //> res0: Double = 0.5
  // tails
  p(0)                                            //> res1: Double = 0.5
  // equal probability
  p(1) == p(0)                                    //> res2: Boolean = true
  
  // biased ? Apparently not!
  p(.3)                                           //> res3: Double = 0.5
  p(.7)                                           //> res4: Double = 0.5
  p(.3) == p(.7)                                  //> res5: Boolean = true
  
  /**** BIASED Probablity v.1 ****/
  	// heads
  p2(1)                                           //> res6: Double = 0.3
  // tails
  p2(0)                                           //> res7: Double = 0.7
  // equal probability
  p2(1) == p(0)                                   //> res8: Boolean = false
  
  // biased ? Apparently not!
  p2(.3)                                          //> res9: Double = 0.5428814526898254
  p2(.7)                                          //> res10: Double = 0.3868247827578358
  p2(.3) == p(.7)                                 //> res11: Boolean = false
  
  /**** BIASED Probablity v.2 ****/
  	// heads
  p3(.3, 1)                                       //> res12: Double = 0.3
  // tails
  p3(.3, 0)                                       //> res13: Double = 0.7
  // equal probability
  p3(.3, 1) == p3(.3, 0)                          //> res14: Boolean = false
  
  // heads
  p3(.7, 1)                                       //> res15: Double = 0.7
  // tails
  p3(.7, 0)                                       //> res16: Double = 0.30000000000000004
  // equal probability
  p3(.7, 1) == p3(.7, 0)                          //> res17: Boolean = false
  
}