package lab.math.coursera.ohio.calculus.seriesandsequences

import lab.math.coursera.ohio.calculus.seriesandsequences.Tribinacci_seq._

object Tribinacci_seq_ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  b(0)                                            //> res0: Double = 1.0
  b(1)                                            //> res1: Double = 1.0
  b(2)                                            //> res2: Double = 3.0
  b(3)                                            //> res3: Double = 1.6666666666666667
  5/3d                                            //> res4: Double(1.6666666666666667) = 1.6666666666666667
  b(4)                                            //> res5: Double = 1.8
  9/5d                                            //> res6: Double(1.8) = 1.8
  b(5)                                            //> res7: Double = 1.8888888888888888
  17/9d                                           //> res8: Double(1.8888888888888888) = 1.8888888888888888
  b(6)                                            //> res9: Double = 1.8235294117647058
  31/17d                                          //> res10: Double(1.8235294117647058) = 1.8235294117647058
  // Approaching limit 1.839...
  b(10)                                           //> res11: Double = 1.839378238341969
  57/31d                                          //> res12: Double(1.8387096774193548) = 1.8387096774193548
  b(20)                                           //> res13: Double = 1.8392867582578194
  35/19d                                          //> res14: Double(1.8421052631578947) = 1.8421052631578947
  b(21)                                           //> res15: Double = 1.839286735958806
  193/105d                                        //> res16: Double(1.838095238095238) = 1.838095238095238
  // b(50) time out
}