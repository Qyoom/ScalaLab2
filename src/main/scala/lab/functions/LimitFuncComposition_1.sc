package lab.functions
 
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
  }                                               //> compose: (numer: lab.functions.LimitFuncComposition_1.R => lab.functions.Lim
                                                  //| itFuncComposition_1.R, denom: lab.functions.LimitFuncComposition_1.R => lab.
                                                  //| functions.LimitFuncComposition_1.R)lab.functions.LimitFuncComposition_1.R =>
                                                  //|  Double
  /* Variations of limit functions... */
  
  val f1 = compose({x => 6 - 3 * sqrt(3*x - 14)}, {x => 6 - x})
                                                  //> f1  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
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
                                                  //> f2  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
  f2(-0.001)                                      //> res11: Double = 11.99700024999828
  f2(-0.00001)                                    //> res12: Double = 11.99997000007613
  f2(0.00001)                                     //> res13: Double = 12.000029999725824
  f2(0.001)                                       //> res14: Double = 12.003000250004447
  
  val f3 = compose({x => 8 * (x - 5)}, {x => pow(x, 2) - 25})
                                                  //> f3  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
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
                                                  //> f4  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
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
                                                  //> f5  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
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
  
  val f6 = compose({x => pow((x+1),3)-1}, {x => x})
                                                  //> f6  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
  f6(-0.01)                                       //> res45: Double = 2.9700999999999977
  f6(-0.001)                                      //> res46: Double = 2.997000999999999
  f6(-0.000001)                                   //> res47: Double = 2.99999700004161
  f6(0.000001)                                    //> res48: Double = 3.0000029997978572
  f6(0.001)                                       //> res49: Double = 3.0030009999997276
  f6(0.01)                                        //> res50: Double = 3.0301000000000133
  
  val f7 = compose({x => 9 * (x - 5)}, {x => pow(x,2) - 25})
                                                  //> f7  : lab.functions.LimitFuncComposition_1.R => Double = <function1>
  f7(4)                                           //> res51: Double = 1.0
  f7(4.9)                                         //> res52: Double = 0.9090909090909105
  f7(4.99)                                        //> res53: Double = 0.9009009009008988
  f7(4.999)                                       //> res54: Double = 0.9000900090008327
  f7(5.001)                                       //> res55: Double = 0.8999100089991675
  f7(5.01)                                        //> res56: Double = 0.8991008991009012
  f7(5.1)                                         //> res57: Double = 0.8910891089108897
  f7(6)                                           //> res58: Double = 0.8181818181818182
}