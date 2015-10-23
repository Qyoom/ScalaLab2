package lab.math

import math._

object logarithms_lab_2 {
  // algorithms, Dasgupta.pdf, p.22
  /*
    How many digits are needed to represent the number N ≥ 0 in base b?
    Let’s see—with k digits in base b we can express numbers up to bk − 1;
    for instance, in decimal, three digits get us all the way up to
    999 = 103 − 1. By solving for k, we find that ⌈logb(N + 1)⌉ digits
    (about logb N digits, give or take 1) are needed to write N in base b.
   */
  pow(10,3)-1                                     //> res0: Double = 999.0
  log10(999)                                      //> res1: Double = 2.9995654882259823
  
  /*
    How much does the size of a number change when we change bases?
    Recall the rule for converting logarithms from base a to base b:
    logb N = (loga N)/(loga b). So the size of integer N in base a
    is the same as its size in base b, times a constant factor loga b.
   */
   def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
                                                  //> log2: (x: Double)Double
   def log3(x: Double) = scala.math.log(x)/scala.math.log(3)
                                                  //> log3: (x: Double)Double
   def log4(x: Double) = scala.math.log(x)/scala.math.log(4)
                                                  //> log4: (x: Double)Double
   // So, for N=5, converting a=log2 to b=log4 :
   log4(5)                                        //> res2: Double = 1.160964047443681
   log2(5)/(log2(4))                              //> res3: Double = 1.160964047443681
   
   /* When we do not specify a base, as we almost never will, we mean log2 N.
    * log N is, of course, the power to which you need to raise 2 in order to
    * obtain N.
    */
    val N = 5                                     //> N  : Int = 5
    val power = log2(N) // power = exponent       //> power  : Double = 2.321928094887362
    pow(2, power)                                 //> res4: Double = 4.999999999999999
   
   
   
  '''                                             //> res5: Char('\'') = '
}