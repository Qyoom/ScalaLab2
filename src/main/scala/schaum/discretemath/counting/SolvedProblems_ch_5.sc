package schaum.discretemath.counting

import schaum.discretemath.counting.Factorial._

object SolvedProblems_ch_5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // 5.1
  fac(4)                                          //> 3.036344593938168E64
                                                  //| 5.381780668201844E65
                                                  //| 3598695.6187410373
                                                  //| 2.852561716306302E7
                                                  //| fac(4): 24
                                                  //| res0: Int = 24
  fac(5)                                          //> fac(5): 120
                                                  //| res1: Int = 120
  fac(6)                                          //> fac(6): 720
                                                  //| res2: Int = 720
  6 * fac(5)                                      //> fac(5): 120
                                                  //| res3: Int = 720
  fac(9)                                          //> fac(9): 362880
                                                  //| res4: Int = 362880
  9 * fac(8)                                      //> fac(8): 40320
                                                  //| res5: Int = 362880
  //fac(50) // Bomb's out!
  
 
}