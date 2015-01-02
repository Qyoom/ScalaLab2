package lab.math.coursera.ohio.calculus.seriesandsequences
import lab.math.coursera.ohio.calculus.seriesandsequences.LimitFuncComposition.compose
import math._

object Limit_lab_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val f1 = compose({x => 6 - 3 * sqrt(3*x - 14)}, {x => 6 - x})
                                                  //> f1  : lab.math.coursera.ohio.calculus.seriesandsequences.LimitFuncCompositio
                                                  //| n.R => Double = <function1>
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
  
  val f2 = compose({m => 4 * pow(m,2) - 2*m - 1}, {m => pow(m,2) + 6*m + 5})
                                                  //> f2  : lab.math.coursera.ohio.calculus.seriesandsequences.LimitFuncCompositio
                                                  //| n.R => Double = <function1>
  f2(1)                                           //> res11: Double = 0.08333333333333333
  f2(10)                                          //> res12: Double = 2.296969696969697
  f2(100)                                         //> res13: Double = 3.7528524280999527
  f2(1000)                                        //> res14: Double = 3.974134323388055
  f2(10000)                                       //> res15: Double = 3.99740134932034
  f2(100000)                                      //> res16: Double = 3.99974001349932
}