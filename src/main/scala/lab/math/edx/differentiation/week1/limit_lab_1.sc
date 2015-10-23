package lab.math.edx.differentiation.week1

object limit_lab_1 {
  import lab.math.calculus.derivative.schaum.previous.Derivative_formulas_1._
  import scala.math._
  
  val x = 1                                       //> x  : Int = 1
  sqrt(3d - 5d * x + pow(x, 2) + pow(x, 3)) / (x - 1)
                                                  //> res0: Double = NaN
  
  def f(x: Double) = sqrt(3d - 5d * x + pow(x, 2) + pow(x, 3)) / (x - 1)
                                                  //> f: (x: Double)Double
  f(0)                                            //> res1: Double = -1.7320508075688772
  f(0.5)                                          //> res2: Double = -1.8708286933869707
  f(0.9)                                          //> res3: Double = -1.974841765813154
  f(0.99)                                         //> res4: Double = -1.9974984355433558
  f(0.999)                                        //> res5: Double = -1.9997499843533573
  f(0.9999)                                       //> res6: Double = -1.9999749943194713
  
  f(1.5)                                          //> res7: Double = 2.1213203435596424
  f(1.1)                                          //> res8: Double = 2.0248456731316713
  f(1.01)                                         //> res9: Double = 2.00249843945087
  f(1.001)                                        //> res10: Double = 2.000249984482112
  f(1.0001)                                       //> res11: Double = 2.0000250015401098

  '''                                             //> res12: Char('\'') = '
}