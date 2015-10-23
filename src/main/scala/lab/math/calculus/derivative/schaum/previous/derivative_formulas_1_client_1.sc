package lab.math.calculus.derivative.schaum.previous

object derivative_formulas_1_client_1 {
  import lab.math.calculus.derivative.schaum.previous.Derivative_formulas_1._

    // example 1
  def f(x: Double) = 1/x // scalar-to-scalar function
                                                  //> f: (x: Double)Double
  
  derivative(f, 3)                                //> res0: Double = -0.11111112030448567
  derivative(f, 2)                                //> res1: Double = -0.25000002068509275
  val temp2 = -1/4d                               //> temp2  : Double = -0.25
  derivative(f, -4)                               //> res2: Double = -0.06250000517127319
  val temp1 = -1/16d                              //> temp1  : Double = -0.0625
  
  f_deriv(3, 5, f)                                //> res3: Double = -0.06666666666666665
  f_deriv(1, 10, f)                               //> res4: Double = -0.1
  f_deriv(1, 100, f)                              //> res5: Double = -0.01
  f_deriv(1, 2, f)                                //> res6: Double = -0.5
  f_deriv(5, 3, f)                                //> res7: Double = -0.06666666666666665
  f_deriv(100, 1, f)                              //> res8: Double = -0.01
  f_deriv(50, 51, f)                              //> res9: Double = -3.9215686274509873E-4
  f_deriv(51, 50, f)                              //> res10: Double = -3.9215686274509873E-4
  f_deriv(7, 8, f)                                //> res11: Double = -0.01785714285714285
  f_deriv(15,17, f)                               //> res12: Double = -0.00392156862745098
}