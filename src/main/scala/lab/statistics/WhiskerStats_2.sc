package lab.statistics

//    http://www.miniwebtool.com/quartile-calculator/
//    https://www.mathsisfun.com/data/quartiles.html

object WhiskerStats_2 {
  
  def median(X0: Vector[Double]): Double = {
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
	}                                         //> median: (X0: Vector[Double])Double
	
	def whiskerValues(X0: Vector[Double]): (Double, Double, Double, Double, Double) = {
		val X = X0.sorted
		val min_ = X(0)
		val max_ = X(X.length - 1)
		val median_ = median(X)
		val Q1 = median(X.take(X.length/2))
		val Q3 = {
			if(X.length % 2 == 0) median(X.drop(X.length/2))
			else                  median(X.drop(X.length/2 + 1))
		}
		(min_, Q1, median_, Q3, max_)
	}                                         //> whiskerValues: (X0: Vector[Double])(Double, Double, Double, Double, Double)
	
	def quartiles(X0: Vector[Double]): (Double, Double, Double) = {
		val X = X0.sorted
		val median_ = median(X)
		val Q1 = median(X.take(X.length/2))
		val Q3 = {
			if(X.length % 2 == 0) median(X.drop(X.length/2))
			else                  median(X.drop(X.length/2 + 1))
		}
		(Q1, median_, Q3)
	}                                         //> quartiles: (X0: Vector[Double])(Double, Double, Double)
	
	def iqr(X0: Vector[Double]): Double = quartiles(X0) match {
		case (lowerQ, _, upperQ) => upperQ - lowerQ
	}                                         //> iqr: (X0: Vector[Double])Double
	
	def mean(X0: Vector[Double]): Double = X0.reduce(_ + _) / X0.length
                                                  //> mean: (X0: Vector[Double])Double
	
	// ------ tests -------------------- //
  
  val v1 = Vector.range(1, 101, 1).map(_.toDouble)//> v1  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0, 4.0
                                                  //| , 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 
                                                  //| 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.
                                                  //| 0, 31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0, 40.0, 41.0, 42.0, 
                                                  //| 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0, 51.0, 52.0, 53.0, 54.0, 55.
                                                  //| 0, 56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 62.0, 63.0, 64.0, 65.0, 66.0, 67.0, 
                                                  //| 68.0, 69.0, 70.0, 71.0, 72.0, 73.0, 74.0, 75.0, 76.0, 77.0, 78.0, 79.0, 80.
                                                  //| 0, 81.0, 82.0, 83.0, 84.0, 85.0, 86.0, 87.0, 88.0, 89.0, 90.0, 91.0, 92.0, 
                                                  //| 93.0, 94.0, 95.0, 96.0, 97.0, 98.0, 99.0, 100.0)
  whiskerValues(v1)                               //> res0: (Double, Double, Double, Double, Double) = (1.0,25.5,50.5,75.5,100.0)
                                                  //| 
  quartiles(v1)                                   //> res1: (Double, Double, Double) = (25.5,50.5,75.5)
  iqr(v1)                                         //> res2: Double = 50.0
  mean(v1)                                        //> res3: Double = 50.5

  val v2 = Vector.range(1, 5).map(_.toDouble)     //> v2  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0, 4.0
                                                  //| )
  
  whiskerValues(v2)                               //> res4: (Double, Double, Double, Double, Double) = (1.0,1.5,2.5,3.5,4.0)
  quartiles(v2)                                   //> res5: (Double, Double, Double) = (1.5,2.5,3.5)
  iqr(v2)                                         //> res6: Double = 2.0
  mean(v2)                                        //> res7: Double = 2.5
  
  val v3 = Vector.range(1, 6).map(_.toDouble)     //> v3  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0, 4.0
                                                  //| , 5.0)
  whiskerValues(v3)                               //> res8: (Double, Double, Double, Double, Double) = (1.0,1.5,3.0,4.5,5.0)
  quartiles(v3)                                   //> res9: (Double, Double, Double) = (1.5,3.0,4.5)
  iqr(v3)                                         //> res10: Double = 3.0
  mean(v3)                                        //> res11: Double = 3.0
  
  val v4 = Vector(1d,3,3,4,5,6,6,7,8,8)           //> v4  : scala.collection.immutable.Vector[Double] = Vector(1.0, 3.0, 3.0, 4.0
                                                  //| , 5.0, 6.0, 6.0, 7.0, 8.0, 8.0)
  whiskerValues(v4)                               //> res12: (Double, Double, Double, Double, Double) = (1.0,3.0,5.5,7.0,8.0)
  quartiles(v4)                                   //> res13: (Double, Double, Double) = (3.0,5.5,7.0)
  iqr(v4)                                         //> res14: Double = 4.0
  mean(v4)                                        //> res15: Double = 5.1
}