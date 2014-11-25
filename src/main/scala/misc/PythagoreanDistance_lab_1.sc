package misc

import math._

object PythagoreanDistance_lab_1 {

	/* Pythagorean Theorum: The square of the hypotenuse of a right triangle
	 * is equal to the sum of the squares of the other two sides.
	 */
	def hypoDist(x1:Double, y1:Double)(x2:Double, y2:Double): Double = {
		sqrt(pow(x2-x1, 2) + pow(y2-y1, 2))
	}                                         //> hypoDist: (x1: Double, y1: Double)(x2: Double, y2: Double)Double
	
	hypoDist(7,2)(4,6)                        //> res0: Double = 5.0
	hypoDist(7,2)(4,6.7)                      //> res1: Double = 5.57584074378026
	
	
}