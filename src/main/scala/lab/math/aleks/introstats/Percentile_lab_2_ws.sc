package lab.math.aleks.introstats

import scala.math._

object Percentile_lab_2_ws {

	def whiskerValues(X0: List[Double]): (Double, Double, Double, Double, Double) = {
		val X = X0.sorted
		val min_ = X(0)
		val max_ = X(X.length - 1)
		val median_ = medianByHand(X)
		
		val Q1 = medianByHand(X.take(X.length/2))
		println("Q1: " + Q1)
		
		val Q3 = medianByHand(X.drop(X.length/2))
		println("Q3: " + Q3)
		
		(min_, Q1, median_, Q3, max_)
	}                                         //> whiskerValues: (X0: List[Double])(Double, Double, Double, Double, Double)
	
	def medianByHand(X: List[Double]): Double = {
		val X_sorted = X.sorted
		println(X_sorted)
		if(X_sorted.length % 2 == 0) {
			val under = X_sorted((X.length/2) - 1)
			val over = X_sorted(X.length/2)
			(under + over) / 2d
		}
		else {
			val middle_ = X_sorted.length/2
			X_sorted(middle_.toInt)
		}
	}                                         //> medianByHand: (X: List[Double])Double
	
	// ------- Lists of numbers ----------------- //
	
	val dollars = List(11d, 15, 15, 27, 28, 31, 32, 39, 40, 42, 50, 50)
                                                  //> dollars  : List[Double] = List(11.0, 15.0, 15.0, 27.0, 28.0, 31.0, 32.0, 39.
                                                  //| 0, 40.0, 42.0, 50.0, 50.0)
	val grades = List(90d,91,83,71,73,55,87,84,66,95,76,71,70,86,75,94)
                                                  //> grades  : List[Double] = List(90.0, 91.0, 83.0, 71.0, 73.0, 55.0, 87.0, 84.0
                                                  //| , 66.0, 95.0, 76.0, 71.0, 70.0, 86.0, 75.0, 94.0)
  

  
  // ------ Tests ----------------------------- //
  
  //dollars.length
  //whiskerValues(dollars)
  grades.length                                   //> res0: Int = 16
  whiskerValues(grades)                           //> List(55.0, 66.0, 70.0, 71.0, 71.0, 73.0, 75.0, 76.0, 83.0, 84.0, 86.0, 87.0
                                                  //| , 90.0, 91.0, 94.0, 95.0)
                                                  //| List(55.0, 66.0, 70.0, 71.0, 71.0, 73.0, 75.0, 76.0)
                                                  //| Q1: 71.0
                                                  //| List(83.0, 84.0, 86.0, 87.0, 90.0, 91.0, 94.0, 95.0)
                                                  //| Q3: 88.5
                                                  //| res1: (Double, Double, Double, Double, Double) = (55.0,71.0,79.5,88.5,95.0)
                                                  //| 
}
/*



*/