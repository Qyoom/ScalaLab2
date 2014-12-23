package lab.math

import scala.math._
import lab.math.NthRoot._

object Root_lab_1 {

  // Two representations of square root

	sqrt(25)                                  //> res0: Double = 5.0
  pow(25, 1d/2)                                   //> res1: Double = 5.0
  
  sqrt(8)                                         //> res2: Double = 2.8284271247461903
  pow(8, 1d/2)                                    //> res3: Double = 2.8284271247461903
 
  sqrt(36)                                        //> res4: Double = 6.0
  pow(36, 1d/2)                                   //> res5: Double = 6.0
  
  sqrt(36.1)                                      //> res6: Double = 6.008327554319921
  pow(36.1, 1d/2)                                 //> res7: Double = 6.008327554319921
  
  // Cube root
  
  nthRoot(8, 3)                                   //> res8: Double = 2.0
  pow(8, 1d/3)                                    //> res9: Double = 2.0
  
  nthRoot(8.1, 3)                                 //> res10: Double = 2.0082988502465082
  pow(8.1, 1d/3)                                  //> res11: Double = 2.0082988502465087
  
  nthRoot(27, 3)                                  //> res12: Double = 3.0
  pow(27, 1d/3)                                   //> res13: Double = 3.0
  
}