package lab.calculus.derivatives

import lab.calculus.derivatives.DerivativesLab2._
import math._

object DerivativesLab_test_2 { 

    def main(args: Array[String]): Unit = {
        
        // Two different functions to derive derviatives for
        def f1 = (x: Double) => pow(x,2)
        def f2 = (x: Double) => pow(x,2) * 1.5
        
        // testing inputs for x1 and x2
        val params = List((3,7), (7,3), (5,12), (-5,12))
        
        params.foreach { x =>
            val x1 = x._1
            val x2 = x._2
            // slope derivative results for each
	        println("derive slope for f1 with x1=" + x1 + " x2=" + x2)
	        println("final slope for f1: " + deriveSlope(f1) (x1, x2) + "\n")
	        println("derive slope for f2 with x1=" + x1 + " x2=" + x2)
	        println("final slope for f2: " + deriveSlope(f2) (x1, x2)  + "\n")
        }
    }
}