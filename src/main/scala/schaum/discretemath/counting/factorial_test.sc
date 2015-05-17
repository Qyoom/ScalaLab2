package schaum.discretemath.counting

import Factorial.fac

object factorial_test {
	fac(10)                                   //> 3.036344593938168E64
                                                  //| 5.381780668201844E65
                                                  //| 3598695.6187410373
                                                  //| 2.852561716306302E7
                                                  //| fac(10): 3628800
                                                  //| res0: Int = 3628800
  fac(6)                                          //> fac(6): 720
                                                  //| res1: Int = 720
  fac(1)                                          //> fac(1): 1
                                                  //| res2: Int = 1
	fac(0)                                    //> fac(0): 1
                                                  //| res3: Int = 1
	
}