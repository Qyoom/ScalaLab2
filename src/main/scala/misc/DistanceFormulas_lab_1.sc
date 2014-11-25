package misc

import math._

object DistanceFormulas_lab_1 {

	/* Pythagorean Theorum: The square of the hypotenuse of a right triangle
	 * is equal to the sum of the squares of the other two sides.
	 */
	def hypotDist(x1:Double, y1:Double)(x2:Double, y2:Double): Double = {
		sqrt(pow(x2-x1, 2) + pow(y2-y1, 2))
	}                                         //> hypotDist: (x1: Double, y1: Double)(x2: Double, y2: Double)Double
	
	hypotDist(7,2)(4,6)                       //> res0: Double = 5.0
	hypotDist(7,2)(4,6.7)                     //> res1: Double = 5.57584074378026
	hypotDist(2,9)(-1,13)                     //> res2: Double = 5.0
	hypotDist(0,0)(-2,-3)                     //> res3: Double = 3.605551275463989
	hypotDist(6,1)(-7,1)                      //> res4: Double = 13.0

}