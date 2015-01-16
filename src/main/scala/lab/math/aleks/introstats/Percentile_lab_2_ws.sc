package lab.math.aleks.introstats

import scala.math._

object Percentile_lab_2_ws {

	def whiskerValues(X0: List[Double]): (Double, Double, Double, Double, Double) = {
		val X = X0.sorted
		val min_ = X(0)
		val max_ = X(X.length - 1)
		val median_ = medianByHand(X)
		val Q1 = medianByHand(X.take(X.length/2))
		val Q3 = medianByHand(X.drop(X.length/2))
		(min_, Q1, median_, Q3, max_)
	}                                         //> whiskerValues: (X0: List[Double])(Double, Double, Double, Double, Double)
	
	def medianByHand(X: List[Double]): Double = {
		val X_sorted = X.sorted
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
	
	//val dollars = List(11d, 15, 15, 27, 28, 31, 32, 39, 40, 42, 50, 50)
	//val grades = List(90d,91,83,71,73,55,87,84,66,95,76,71,70,86,75,94)
  //val hours = List(66d, 44, 56, 61, 42, 54, 41, 35, 62, 53, 57, 69, 42, 52, 52, 65, 41)
  //val channels = List(21d,18,7,25,21,26,20,40,34,6,16,5,10,9,11,16,8,35)
  val temps = List(58d,56,80,70,64,67,59,50,70,67,51,53,54,57,71,74,55,60,64)
                                                  //> temps  : List[Double] = List(58.0, 56.0, 80.0, 70.0, 64.0, 67.0, 59.0, 50.0
                                                  //| , 70.0, 67.0, 51.0, 53.0, 54.0, 57.0, 71.0, 74.0, 55.0, 60.0, 64.0)
  

  
  // ------ Tests ----------------------------- //
  
  temps.length                                    //> res0: Int = 19
  whiskerValues(temps)                            //> res1: (Double, Double, Double, Double, Double) = (50.0,55.0,60.0,68.5,80.0)
                                                  //| 
  //dollars.length
  //whiskerValues(dollars)
  //grades.length
  //whiskerValues(grades)
  //hours.length
  //whiskerValues(hours)
  //channels.length
  //whiskerValues(channels)
}
/*



*/