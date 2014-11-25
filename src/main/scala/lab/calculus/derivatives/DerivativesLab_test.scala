package lab.calculus.derivatives

import lab.calculus.derivatives.DerivativesLab2._
import math._

object DerivativesLab_test { 

    def main(args: Array[String]): Unit = {
        
        // Two different functions to derive derviatives for
        def f1 = (x: Double) => pow(x,2)
        def f2 = (x: Double) => pow(x,2) * 1.5
        
        // same line inputs for each
        var x1 = 3
        var x2 = 7
        
        // slope derivative results for each
        println("derive slope for f1 with x1=" + x1 + " x2=" + x2)
        println("final slope for f1: " + deriveSlope(f1) (x1, x2) + "\n")
        println("derive slope for f2 with x1=" + x1 + " x2=" + x2)
        println("final slope for f2: " + deriveSlope(f2) (x1, x2)  + "\n")
        
        // reverse same input
        x1 = 7
        x2 = 3
        
        // slope results
        println("derive slope for f1 with x1=" + x1 + " x2=" + x2)
        println("final slope for f1: " + deriveSlope(f1) (x1, x2) + "\n")
        println("derive slope for f2 with x1=" + x1 + " x2=" + x2)
        println("final slope for f2: " + deriveSlope(f2) (x1, x2)  + "\n")
        
/*        // some different input
        x1 = 5
        x2 = 12
        
        // new slope results
        println("regression of slope for f1:\n" + deriveSlope(f1) (x1, x2))
        println("regression of slope for f2:\n" + deriveSlope(f2) (x1, x2)  + "\n")
                
        // some input with negative values
        x1 = -5
        x2 = 12
        
        // new slope results
        println("regression of slope for f1:\n" + deriveSlope(f1) (x1, x2))
        println("regression of slope for f2:\n" + deriveSlope(f2) (x1, x2)  + "\n")
                
        // and reversed with negative values
        x1 = 12
        x2 = -5
        
        // new slope results
        println("regression of slope for f1:\n" + deriveSlope(f1) (x1, x2))
        println("regression of slope for f2:\n" + deriveSlope(f2) (x1, x2)  + "\n")  
*/ 
    } // end - main

}