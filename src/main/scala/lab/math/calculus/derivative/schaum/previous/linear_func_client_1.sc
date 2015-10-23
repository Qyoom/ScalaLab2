package lab.math.calculus.derivative.schaum.previous

object linear_func_client_1 {
  import lab.math.calculus.derivative.schaum.previous.LinearFunction1._

  val f1 = line(-3, -6) (5, 4)                    //> slope:1.25 intercept:-2.25
                                                  //| f1  : lab.math.calculus.derivative.schaum.previous.LinearFunction1.T => Doub
                                                  //| le = <function1>
  f1(7)                                           //> res0: Double = 6.5
  f1(-2)                                          //> res1: Double = -4.75
  f1(-3)                                          //> res2: Double = -6.0
  f1(5)                                           //> res3: Double = 4.0
  
  val f2 = line(-6,-2)(-3,-6)                     //> slope:-1.3333333333333333 intercept:-10.0
                                                  //| f2  : lab.math.calculus.derivative.schaum.previous.LinearFunction1.T => Doub
                                                  //| le = <function1>
  
  line(3,-5)(1,-1)                                //> slope:-2.0 intercept:1.0
                                                  //| res4: lab.math.calculus.derivative.schaum.previous.LinearFunction1.T => Doub
                                                  //| le = <function1>


}
/*


*/