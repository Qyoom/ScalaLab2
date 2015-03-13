package lab.math.aleks.introstats

import scala.math._

object Percentile_lab_2_ws {

	def whiskerValues(X0: List[Double]): (Double, Double, Double, Double, Double) = {
		val X = X0.sorted
		val min_ = X(0)
		val max_ = X(X.length - 1)
		val median_ = medianByHand(X)
		val Q1 = medianByHand(X.take(X.length/2))
		val Q3 = {
			if(X.length % 2 == 0) medianByHand(X.drop(X.length/2))
			else                  medianByHand(X.drop(X.length/2 + 1))
		}
		(min_, Q1, median_, Q3, max_)
	}                                         //> whiskerValues: (X0: List[Double])(Double, Double, Double, Double, Double)
	
	def medianByHand(X0: List[Double]): Double = {
		val X = X0.sorted
		if(X.length % 2 == 0) {
			val under = X((X.length/2) - 1)
			val over = X(X.length/2)
			(under + over) / 2d
		}
		else {
			val middle_ = X.length/2
			X(middle_.toInt)
		}
	}                                         //> medianByHand: (X0: List[Double])Double
	
	// ------- Lists of numbers ----------------- //
	
	//val dollars = List(11d, 15, 15, 27, 28, 31, 32, 39, 40, 42, 50, 50)
	//val grades = List(90d,91,83,71,73,55,87,84,66,95,76,71,70,86,75,94)
  //val hours = List(66d, 44, 56, 61, 42, 54, 41, 35, 62, 53, 57, 69, 42, 52, 52, 65, 41)
  //val channels = List(21d,18,7,25,21,26,20,40,34,6,16,5,10,9,11,16,8,35)
  //val temps = List(58d,56,80,70,64,67,59,50,70,67,51,53,54,57,71,74,55,60,64)
  //val ages = List(29d,29,47,44,49,24,45,27,26,43,54,39,39,26,37,55,46,23,41)
  val waitTimes = List(7d,17,30,8,13,25,19,5,31,19,29,23,6,11,22,24)
                                                  //> waitTimes  : List[Double] = List(7.0, 17.0, 30.0, 8.0, 13.0, 25.0, 19.0, 5.
                                                  //| 0, 31.0, 19.0, 29.0, 23.0, 6.0, 11.0, 22.0, 24.0)
  

  
  // ------ Tests ----------------------------- //
  
  waitTimes.length                                //> res0: Int = 16
  whiskerValues(waitTimes)                        //> res1: (Double, Double, Double, Double, Double) = (5.0,9.5,19.0,24.5,31.0)
  //ages.length
  //whiskerValues(ages)
  //temps.length
  //whiskerValues(temps)
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