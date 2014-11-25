package lab.math
import math._

object logarithm_lab {

	//package scala
	/** The package object `scala.math` contains methods for performing basic
	  * numeric operations such as elementary exponential, logarithmic, root and
	  * trigonometric functions.
	  */
	//package object math
		
	// Users/hieronymus/Development/Math/Aleks/Reference/Logarithms.rtfd
	
	/** Returns Euler's number `e` raised to the power of a `double` value.
   *
   *  @param  x the exponent to raise `e` to.
   *  @return the value `e^a^`, where `e` is the base of the natural
   *          logarithms.
   */
   exp(1)                                         //> res0: Double = 2.7182818284590455
   exp(10)                                        //> res1: Double = 22026.465794806718
   exp(2)                                         //> res2: Double = 7.38905609893065
   exp(E)                                         //> res3: Double = 15.154262241479262
   exp(log(E))                                    //> res4: Double = 2.7182818284590455

	// def log(x: Double): Double = java.lang.Math.log(x)
	// natural logarithm
  log(1)                                          //> res5: Double = 0.0
  log(E)                                          //> res6: Double = 1.0
  log(10)                                         //> res7: Double = 2.302585092994046
  log(2)                                          //> res8: Double = 0.6931471805599453
  
  //.......................//
  
  val x = exp(5)                                  //> x  : Double = 148.4131591025766
  log(x)                                          //> res9: Double = 5.0
  val y = log(5)                                  //> y  : Double = 1.6094379124341003
  exp(y)                                          //> res10: Double = 5.0
  
  log(pow(5, 3))                                  //> res11: Double = 4.8283137373023015
  3 * log(5)                                      //> res12: Double = 4.828313737302301
  
  pow(E, 5) / pow(E, 2)                           //> res13: Double = 20.085536923187664
  pow(E, 5-2)                                     //> res14: Double = 20.085536923187664
  
  pow(E, log(5))                                  //> res15: Double = 4.999999999999999
  log(pow(E, 2))                                  //> res16: Double = 2.0
  log(7) + log(2)                                 //> res17: Double = 2.6390573296152584
  log(14)                                         //> res18: Double = 2.6390573296152584
  log(24) - log(6)                                //> res19: Double = 1.3862943611198908
  log(24/6)                                       //> res20: Double = 1.3862943611198906
  log(10) / log(2)                                //> res21: Double = 3.3219280948873626
  
  //.......................//
  
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
                                                  //> log2: (x: Double)Double
  log2(1)                                         //> res22: Double = 0.0
  log2(2)                                         //> res23: Double = 1.0
  log2(4)                                         //> res24: Double = 2.0
  log2(8)                                         //> res25: Double = 3.0
  log2(32)                                        //> res26: Double = 5.0
  
  log2(pow(2,4))                                  //> res27: Double = 4.0
  log2(pow(2,8))                                  //> res28: Double = 8.0
  
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log3(x: Double) = scala.math.log(x)/scala.math.log(3)
                                                  //> log3: (x: Double)Double
  log3(1)                                         //> res29: Double = 0.0
  log3(3)                                         //> res30: Double = 1.0
  log3(9)                                         //> res31: Double = 2.0
  log3(27)                                        //> res32: Double = 3.0
  
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log4(x: Double) = scala.math.log(x)/scala.math.log(4)
                                                  //> log4: (x: Double)Double
  log4(1)                                         //> res33: Double = 0.0
  log4(4)                                         //> res34: Double = 1.0
  log4(3)                                         //> res35: Double = 0.7924812503605781
  log4(64)                                        //> res36: Double = 3.0
  
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log5(x: Double) = scala.math.log(x)/scala.math.log(5)
                                                  //> log5: (x: Double)Double
  log5(1)                                         //> res37: Double = 0.0
  log5(5)                                         //> res38: Double = 1.0
  log5(25)                                        //> res39: Double = 2.0
  log5(125)                                       //> res40: Double = 3.0000000000000004
  
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log16(x: Double) = scala.math.log(x)/scala.math.log(16)
                                                  //> log16: (x: Double)Double
  log16(1)                                        //> res41: Double = 0.0
  log16(4)                                        //> res42: Double = 0.5
  log16(8)                                        //> res43: Double = 0.75
  log16(16)                                       //> res44: Double = 1.0
  log16(32)                                       //> res45: Double = 1.25
  
  log16(pow(16,3))                                //> res46: Double = 3.0
  
   /** Returns the base 10 logarithm of the given `Double` value. */
	 //def log10(x: Double): Double = java.lang.Math.log10(x)
	 log10(1.0/10)                            //> res47: Double = -1.0
	 log10(1)                                 //> res48: Double = 0.0
   log10(10)                                      //> res49: Double = 1.0
   log10(100)                                     //> res50: Double = 2.0
   log10(1000)                                    //> res51: Double = 3.0
   log10(.1)                                      //> res52: Double = -1.0
       
   //.....................//
   
   log5(125)                                      //> res53: Double = 3.0000000000000004
   log5(25)                                       //> res54: Double = 2.0
   log5(1000)                                     //> res55: Double = 4.29202967422018
   log5(25 * 1000)                                //> res56: Double = 6.29202967422018
   log5(25) + log5(1000)                          //> res57: Double = 6.29202967422018
   log5(25 * 125)                                 //> res58: Double = 5.0
   log5(25) + log5(125)                           //> res59: Double = 5.0
   log5(1000) - log5(25)                          //> res60: Double = 2.2920296742201796
   log5(1000/25)                                  //> res61: Double = 2.292029674220179
   
   //-------------------------------------//
   
   /* Generic exponential function.
    * a is the base, s is the exponent, x is the s'th power of a.
    * Inverse of the logarithmic function.
    */
   def expFunc(a: Double, s: Double): Double = {
		 val x = pow(a, s)
		 x
   }                                              //> expFunc: (a: Double, s: Double)Double
   
   /* Generic logarithmic function.
    * a is the base, s is the exponent, x is the s'th power of a.
    * Range must be positive real number.
    */
   def logFunc(a: Double, x: Double): Double = {
		 val s = scala.math.log(x)/scala.math.log(a)
		 s
   }                                              //> logFunc: (a: Double, x: Double)Double
   
   //...................//
   
   expFunc(4, 3)                                  //> res62: Double = 64.0
   logFunc(4, 64)                                 //> res63: Double = 3.0
   expFunc(4, logFunc(4, expFunc(4, 3)))          //> res64: Double = 64.0
   logFunc(4, expFunc(4, 3))                      //> res65: Double = 3.0
   logFunc(-4, 64)                                //> res66: Double = NaN
   
   logFunc(3, (1.0/81))                           //> res67: Double = -4.0
   logFunc(4, 16)                                 //> res68: Double = 2.0
   logFunc(8, 1)                                  //> res69: Double = 0.0
   logFunc(10, (1.0/10.0))                        //> res70: Double = -0.9999999999999998
   expFunc(10, -1)                                //> res71: Double = 0.1
   
   expFunc(2, -3)                                 //> res72: Double = 0.125
}