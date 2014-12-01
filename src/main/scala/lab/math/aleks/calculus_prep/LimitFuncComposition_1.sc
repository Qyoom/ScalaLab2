package lab.math.aleks.calculus_prep

import math._

/* A lab for studying Scala function composition with an example for
 * calculating mathematical function limits.
 */
object LimitFuncComposition_1 {
  
  /* Template for composing limit functions with numerators and denomenators
   * as anonymous functions
   */
  type R = Double
  def compose(numer: R=>R, denom: R=>R) = {
  		(x:R) => numer(x) / denom(x)
  }                                               //> compose: (numer: lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => la
                                                  //| b.math.aleks.calculus_prep.LimitFuncComposition_1.R, denom: lab.math.aleks.c
                                                  //| alculus_prep.LimitFuncComposition_1.R => lab.math.aleks.calculus_prep.LimitF
                                                  //| uncComposition_1.R)lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => 
                                                  //| Double
  /* Variations of limit functions... */
  
  val f1 = compose({x => 6 - 3 * sqrt(3*x - 14)}, {x => 6 - x})
                                                  //> f1  : lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => Double = <fun
                                                  //| ction1>
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
  
  val f2 = compose({x => pow((x + 4), 3) - 64}, {x => 4*x})
                                                  //> f2  : lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => Double = <fun
                                                  //| ction1>
  f2(-0.001)                                      //> res11: Double = 11.99700024999828
  f2(-0.00001)                                    //> res12: Double = 11.99997000007613
  f2(0.00001)                                     //> res13: Double = 12.000029999725824
  f2(0.001)                                       //> res14: Double = 12.003000250004447
  
  val f3 = compose({x => 8 * (x - 5)}, {x => pow(x, 2) - 25})
                                                  //> f3  : lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => Double = <fun
                                                  //| ction1>
  f3(4)                                           //> res15: Double = 0.8888888888888888
  f3(4.5)                                         //> res16: Double = 0.8421052631578947
  f3(4.95)                                        //> res17: Double = 0.8040201005025118
  f3(4.999)                                       //> res18: Double = 0.8000800080007402
  f3(4.9999)                                      //> res19: Double = 0.8000080000806628
  f3(5.0001)                                      //> res20: Double = 0.7999920000793372
  f3(5.001)                                       //> res21: Double = 0.79992000799926
  f3(5.05)                                        //> res22: Double = 0.7960199004975133
  f3(5.5)                                         //> res23: Double = 0.7619047619047619
  f3(6)                                           //> res24: Double = 0.7272727272727273
  
  val f4 = compose({x => 7 - sqrt(7*x)}, {x => 7-x})
                                                  //> f4  : lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => Double = <fun
                                                  //| ction1>
  f4(6)                                           //> res25: Double = 0.5192593015921396
  f4(6.5)                                         //> res26: Double = 0.5092624367679583
  f4(6.95)                                        //> res27: Double = 0.5008960602255303
  f4(6.99)                                        //> res28: Double = 0.500178699093567
  f4(6.9999)                                      //> res29: Double = 0.5000017857271217
  f4(7.0001)                                      //> res30: Double = 0.4999982142995236
  f4(7.01)                                        //> res31: Double = 0.4998215560086834
  f4(7.05)                                        //> res32: Double = 0.4991103174678475
  f4(7.5)                                         //> res33: Double = 0.49137674618943805
  f4(8)                                           //> res34: Double = 0.48331477354788266
  
  val f5 = compose({x => 4 - 2*sqrt(3*x - 8)}, {x => 4-x})
                                                  //> f5  : lab.math.aleks.calculus_prep.LimitFuncComposition_1.R => Double = <fu
                                                  //| nction1>
  f5(3.5)                                         //> res35: Double = 1.675444679663241
  f5(3.9)                                         //> res36: Double = 1.5292318766573119
  f5(3.95)                                        //> res37: Double = 1.5143325186056575
  f5(3.999)                                       //> res38: Double = 1.5002813555182168
  f5(3.99999)                                     //> res39: Double = 1.5000028125279883
  f5(4.00001)                                     //> res40: Double = 1.4999971874942162
  f5(4.001)                                       //> res41: Double = 1.4997188554190508
  f5(4.05)                                        //> res42: Double = 1.4861951498534385
  f5(4.1)                                         //> res43: Double = 1.4728827066554437
  f5(4.5)                                         //> res44: Double = 1.3808315196468595
}