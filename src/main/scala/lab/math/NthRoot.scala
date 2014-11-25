package lab.math

import math.pow

// http://rosettacode.org/wiki/Nth_root#Scala
object NthRoot extends App {

	def nthRoot(a: Double, n: Int): Double = {
    
		def inter(x0: Double) : Double = {
			//println("x0:" + x0)
			val x1 = (1.0d/n * ((n - 1) * x0 + a/pow(x0, n-1)))
			if (x0 <= x1) x0
			else inter(x1)
		}

		return inter(a/2)
	}
  
	//.............................//
  
	//println("nthRoot(32, 3) ====> " + nthRoot(32, 3))
	//println("nthRoot(625, 4) ====> " + nthRoot(625, 4))
	
	
}