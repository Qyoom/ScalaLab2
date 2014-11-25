package schaum.discretemath.counting

import math._

object Factorial extends Application {
    
	def fac(n: Int): Int = {
	    if (n < 0) throw new IllegalArgumentException("Input must be greater than 0")
	    val orig = n // diagnostic
	    def recurse(n: Int, prod: Int): Int = {
	        if (n <= 1) {
	            println("fac(" + orig + "): " + prod)
	            prod // return result
	        }
	        else recurse(n-1, n*prod)
	    }
	    recurse(n, 1)
	}
	
	// NOTE: These versions of Sterling's Approximation do not appear to be very accurate.
	def sterlings(n: Int): Double = {
	    sqrt(2 * Pi * n) * pow((n / E), n)
	}
	
	def sterlings2(n: Int): Double = {
	    ((2 * n) + (1/3)) * Pi * pow(n, n) * (1 / pow(E, n))
	}
	
	/******* TESTS ***************/
	
	println(sterlings(50))
	println(sterlings2(50))
	println(sterlings(10))
	println(sterlings2(10))
	
	/*
	println("fac(5): " + fac(5))
	println("fac(0): " + fac(0))
	println("fac(1): " + fac(1))
	println("fac(2): " + fac(2))
	println("fac(10): " + fac(10))
	*/
	//println(fac(-1)) // exception thrown
	
	//println("fac(52): " + fac(52)) // NOT ABLE TO HANDLE BIG NUMBERS LIKE THIS!!
	
}