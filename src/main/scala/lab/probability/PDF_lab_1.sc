package lab.probability

object PDF_lab_1 {
  
  def f(x: Double) = {
  		if(1 > x && x > 0 ) 2 * x
  		else 0
  }                                               //> f: (x: Double)Double
  
  f(.7)                                           //> res0: Double = 1.4
  f(1.1)                                          //> res1: Double = 0.0
}