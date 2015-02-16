package lab.math.projeuler

import lab.math.projeuler.Palindrome._

object Palindrome_test_1 {

	// TRUE
  isPal(12321)                                    //> res0: Boolean = true
  isPal(55555)                                    //> res1: Boolean = true
  isPal(323)                                      //> res2: Boolean = true
  isPal(1)                                        //> res3: Boolean = true
  isPal(22)                                       //> res4: Boolean = true
  isPal(2002)                                     //> res5: Boolean = true
  
  // FALSE
  isPal(12341)                                    //> res6: Boolean = false
  isPal(12345)                                    //> res7: Boolean = false
  isPal(55545)                                    //> res8: Boolean = false
  isPal(12)                                       //> res9: Boolean = false
  isPal(2012)                                     //> res10: Boolean = false
}