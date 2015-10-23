package lab.math.vectorspace

object line_function_lab_1 {

  /* y = mx + b
   * i.e. Take two pairs of x,y coordinates and calculate slope and intercept,
   * returning function that takes any x input and produces y output according
  	 * to calculated slope and intercept.
  	 */
  	type T = Double
  def line (x0: T, y0: T) (x1: T, y1: T) = {
  		val slope = (y1 - y0) / (x1 - x0) // delta_y / delta_x
  		// b = y - mx
  		val intercept = y0 - slope * x0
  		
  		println("slope:" + slope + " intercept:" + intercept)
  		
  		// Return function(any_x) => y_output
  		// new_y = m*new_x + b
  		(new_x:T) => slope * new_x + intercept // solving for new_y
  	}                                         //> line: (x0: lab.math.vectorspace.line_function_lab_1.T, y0: lab.math.vectorsp
                                                  //| ace.line_function_lab_1.T)(x1: lab.math.vectorspace.line_function_lab_1.T, y
                                                  //| 1: lab.math.vectorspace.line_function_lab_1.T)lab.math.vectorspace.line_func
                                                  //| tion_lab_1.T => Double
  	
  val f1 = line(-3, -6) (5, 4)                    //> slope:1.25 intercept:-2.25
                                                  //| f1  : lab.math.vectorspace.line_function_lab_1.T => Double = <function1>
  f1(7)                                           //> res0: Double = 6.5
  f1(-2)                                          //> res1: Double = -4.75
  f1(-3)                                          //> res2: Double = -6.0
  f1(5)                                           //> res3: Double = 4.0
  
  val f2 = line(-6,-2)(-3,-6)                     //> slope:-1.3333333333333333 intercept:-10.0
                                                  //| f2  : lab.math.vectorspace.line_function_lab_1.T => Double = <function1>
}
/*






*/