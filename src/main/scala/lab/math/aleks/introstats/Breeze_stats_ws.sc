package lab.math.aleks.introstats

import breeze.linalg._
import breeze.stats._
import breeze.stats.DescriptiveStats._
import breeze.math._
import breeze.numerics._

object Breeze_stats_ws {
  val sorted = List(7,2,37,32,27,22,16,11,6,1,36,31,40,40,40,34,34,29,29,24,24,9).sorted
                                                  //> sorted  : List[Int] = List(1, 2, 6, 7, 9, 11, 16, 22, 24, 24, 27, 29, 29, 31
                                                  //| , 32, 34, 34, 36, 37, 40, 40, 40)
  val sorted_double = sorted.map(x => x.toDouble) //> sorted_double  : List[Double] = List(1.0, 2.0, 6.0, 7.0, 9.0, 11.0, 16.0, 22
                                                  //| .0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 36.0, 37.0, 40.0, 
                                                  //| 40.0, 40.0)
  val sorted_array = sorted_double.toArray        //> sorted_array  : Array[Double] = Array(1.0, 2.0, 6.0, 7.0, 9.0, 11.0, 16.0, 2
                                                  //| 2.0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 36.0, 37.0, 40.0,
                                                  //|  40.0, 40.0)
  val v1 = DenseVector[Double](sorted_array)      //> v1  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 6.0, 7.0, 9.
                                                  //| 0, 11.0, 16.0, 22.0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 3
                                                  //| 6.0, 37.0, 40.0, 40.0, 40.0)
  breeze.stats.mean(v1)                           //> res0: Double = 24.136363636363637
  mean(sorted_array)                              //> res1: Double = 24.136363636363637
  median(v1)                                      //> res2: Double = 28.0
  //median(sorted_array) // error
  breeze.stats.variance(v1)                       //> res3: Double = 168.59956709956708
  variance(v1)                                    //> res4: Double = 168.59956709956708
  variance(sorted_array)                          //> res5: Double = 168.59956709956708
  percentile(sorted_array, .25)                   //> res6: Double = 10.5
  // percentile(v1, .25) // error
  percentile(sorted_array, .75)                   //> res7: Double = 34.5
  min(v1)                                         //> res8: Double = 1.0
  min(sorted_array)                               //> res9: Double = 1.0
  max(v1)                                         //> res10: Double = 40.0
  max(sorted_array)                               //> res11: Double = 40.0
  
  // This does not appear to be accurate.
  // See my "hand made" version in Percentile_lab_2_ws
  def percentileBreeze(X: DenseVector[Double]) = {
  		val X_arr = X.toArray
  		val min_ = min(X)
  		val firstQ = percentile(X_arr, .25)
  		val med = median(v1)
  		val thirdQ = percentile(X_arr, .75)
  		val max_ = max(X)
  		(min_, firstQ, med, thirdQ, max_)
  }                                               //> percentileBreeze: (X: breeze.linalg.DenseVector[Double])(Double, Double, Do
                                                  //| uble, Double, Double)
  
  val dollars = DenseVector[Double](11, 15, 15, 27, 28, 31, 32, 39, 40, 42, 50, 50)
                                                  //> dollars  : breeze.linalg.DenseVector[Double] = DenseVector(11.0, 15.0, 15.0
                                                  //| , 27.0, 28.0, 31.0, 32.0, 39.0, 40.0, 42.0, 50.0, 50.0)
  percentileBreeze(dollars)                       //> res12: (Double, Double, Double, Double, Double) = (11.0,18.0,28.0,41.5,50.0
                                                  //| )

}