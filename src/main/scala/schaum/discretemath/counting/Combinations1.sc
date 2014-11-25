package schaum.discretemath.counting
import schaum.discretemath.counting.Factorial._
import schaum.discretemath.counting.BinomialTheorem._

object Combinations1 {
  println("Schaum Combinations, p.93")            //> Schaum Combinations, p.93
  
  // Example 5.7
  // C(n, r) * r!
  binomialCoeficients(4, 3) * fac(3)              //> 3.036344593938168E64
                                                  //| 5.381780668201844E65
                                                  //| 3598695.6187410373
                                                  //| 2.852561716306302E7
                                                  //| fac(3): 6
                                                  //| res0: Double = 24.0
  // Example 5.8, p.94
  // C(n, r)
  // ans: 14000
  val cows = binomialCoeficients(6, 3)            //> cows  : Double = 20.0
  val pigs = binomialCoeficients(5, 2)            //> pigs  : Double = 10.0
  val chickens = binomialCoeficients(8, 4)        //> chickens  : Double = 70.0
  cows * pigs * chickens                          //> res1: Double = 14000.0
  
  // 6.2 COMBINATIONS WITH REPETITIONS
  // M = 4 kinds of cookies. Find the number of ways a person can buy r = 8 of the cookies.
  // Formula: R + M − 1
  // 8 + 4 - 1 = 11
  // M =C(11,8)=C(11,3)
  // Theorem 6.1
  // C(r + M − 1, r) = C(r + M − 1, M − 1)
  // C(8 + 4 - 1, 8) = C(8 + 4 - 1, 4 - 1)
  binomialCoeficients(11, 8)                      //> res2: Double = 165.0
  binomialCoeficients(11, 3)                      //> res3: Double = 165.0
  
  // Example 6.1
  // Find the number m of non negative integer solutions of x + y + z = 18
  // C(r + M − 1, r) = C(r + M − 1, M − 1)
  binomialCoeficients(18 + 3 - 1, 3 - 1)          //> res4: Double = 190.0
  // binomialCoeficients(18 + 3 - 1, 18) // Error: 18 is too big to factorial
  fac(18)                                         //> fac(18): -898433024
                                                  //| res5: Int = -898433024
  
}