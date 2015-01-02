package lab.math.vectorspace

object line_function_lab_1 {

  /* y = mx + b
   * i.e. Take two pairs of x,y coordinates and calulate slope and intercept,
   * returning function that takes any x input and produces y output according
  	 * to calculated slope and intercept.
  	 */
  def line (x: Double, y: Double) (x2: Double, y2: Double) = {
  		val slope = (y2 - y) / (x2 - x)
  		// b = y - mx
  		val intercept = y - slope*x
  		
  		println("slope:" + slope + " intercept:" + intercept)
  		
  		// Return function(any_x) => y_output
  		// new_y = m*new_x + b
  		(new_x:Double) => slope*new_x + intercept // solving for new_y
  	}                                         //> line: (x: Double, y: Double)(x2: Double, y2: Double)Double => Double
  	
  val f1 = line(-3, -6) (5, 4)                    //> slope:1.25 intercept:-2.25
                                                  //| f1  : Double => Double = <function1>
  f1(7)                                           //> res0: Double = 6.5
  f1(-2)                                          //> res1: Double = -4.75
  f1(-3)                                          //> res2: Double = -6.0
  f1(5)                                           //> res3: Double = 4.0
}