package lab.math.aleks.introstats

import scala.math._

object Percentile_lab_2_ws {

	def whiskerValues(X0: List[Double]): (Double, Double, Double) = {
		val X = X0.sorted
		val min_ = X(1)
		val max_ = X(X.length - 1)
		val median_ = medianByHand(X)
		
		(min_, max_, median_)
	}                                         //> whiskerValues: (X0: List[Double])(Double, Double, Double)
	
	def percentileByHand(X0: List[Double]) = {
	
	}                                         //> percentileByHand: (X0: List[Double])Unit
	
	def medianByHand(X: List[Double]): Double = {
		val X_sorted = X.sorted
		println(X_sorted)
		if(X_sorted.length % 2 == 0) {
			//println("length even")
			val under = X_sorted((X.length/2) - 1)
			val over = X_sorted(X.length/2)
			(under + over) / 2d
		}
		else {
			//println("length odd, div by 2: " + X.length/2)
			val half_length = X_sorted.length/2d
			val floor_ = floor(half_length)
			
			//println("length odd, div by 2: " + X_sorted.length/2)
			//println("floor_: " + floor_)
			
			X_sorted(floor_.toInt)
		}
	}                                         //> medianByHand: (X: List[Double])Double
	
	// ------- Lists of numbers ----------------- //
	
	val dollars = List(11d, 15, 15, 27, 28, 31, 32, 39, 40, 42, 50, 50)
                                                  //> dollars  : List[Double] = List(11.0, 15.0, 15.0, 27.0, 28.0, 31.0, 32.0, 39.
                                                  //| 0, 40.0, 42.0, 50.0, 50.0)
  
  //val test_odd = List(-1d,2,3,4,5,6,70)
  /*val test_odd_2 = List(-1d,2,3,4,5,6,7,8,9,10,110)
  val test_even = List(-1d,2,3,4,5,60)
  val test_even_2 = List(-1d,2,3,4,5,6,7,8,9,100)
  
  val test1 = List(4d, -1, 6, 3, 6)
  */
  
  // ------ Tests ----------------------------- //
  
	dollars.length                            //> res0: Int = 12
	//medianByHand(dollars)
  whiskerValues(dollars)                          //> List(11.0, 15.0, 15.0, 27.0, 28.0, 31.0, 32.0, 39.0, 40.0, 42.0, 50.0, 50.0
                                                  //| )
                                                  //| res1: (Double, Double, Double) = (15.0,50.0,31.5)
  
	/*
	test_odd.length
	test_odd.length/2
	test_odd(test_odd.length/2)
	test_odd_2(test_odd_2.length/2)
	
	test_even.length
	test_even((test_even.length/2) - 1)
	test_even(test_even.length/2)
	test_even_2((test_even_2.length/2) - 1)
	test_even_2(test_even_2.length/2)
	medianByHand(test_odd)
	medianByHand(test_odd_2)
	medianByHand(test_even)
	medianByHand(test_even_2)
	
	medianByHand(test1)
  */
}
/*



*/