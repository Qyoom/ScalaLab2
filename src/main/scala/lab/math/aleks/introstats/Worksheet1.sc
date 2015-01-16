package lab.math.aleks.introstats

import breeze.linalg._
import breeze.stats._
import breeze.math._
import breeze.numerics._



object Worksheet1 {
  val sorted = List(7,2,37,32,27,22,16,11,6,1,36,31,40,40,40,34,34,29,29,24,24,9).sorted
                                                  //> sorted  : List[Int] = List(1, 2, 6, 7, 9, 11, 16, 22, 24, 24, 27, 29, 29, 31
                                                  //| , 32, 34, 34, 36, 37, 40, 40, 40)
	val dropped = sorted.drop(sorted.indexWhere(x => x > 6))
                                                  //> dropped  : List[Int] = List(7, 9, 11, 16, 22, 24, 24, 27, 29, 29, 31, 32, 34
                                                  //| , 34, 36, 37, 40, 40, 40)
  dropped.splitAt(dropped.indexWhere(x => x > (11)))
                                                  //> res0: (List[Int], List[Int]) = (List(7, 9, 11),List(16, 22, 24, 24, 27, 29, 
                                                  //| 29, 31, 32, 34, 34, 36, 37, 40, 40, 40))
  val sorted_double = sorted.map(x => x.toDouble) //> sorted_double  : List[Double] = List(1.0, 2.0, 6.0, 7.0, 9.0, 11.0, 16.0, 22
                                                  //| .0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 36.0, 37.0, 40.0, 
                                                  //| 40.0, 40.0)
  val sorted_array = sorted_double.toArray        //> sorted_array  : Array[Double] = Array(1.0, 2.0, 6.0, 7.0, 9.0, 11.0, 16.0, 2
                                                  //| 2.0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 36.0, 37.0, 40.0,
                                                  //|  40.0, 40.0)
  val v1 = DenseVector[Double](sorted_double.toArray)
                                                  //> v1  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 6.0, 7.0, 9.
                                                  //| 0, 11.0, 16.0, 22.0, 24.0, 24.0, 27.0, 29.0, 29.0, 31.0, 32.0, 34.0, 34.0, 3
                                                  //| 6.0, 37.0, 40.0, 40.0, 40.0)
  breeze.stats.mean(v1)                           //> res1: Double = 24.136363636363637
  mean(sorted_array)                              //> res2: Double = 24.136363636363637
  median(v1)                                      //> res3: Double = 28.0
  //median(sorted_array) // error
  breeze.stats.variance(v1)                       //> res4: Double = 168.59956709956708
  variance(v1)                                    //> res5: Double = 168.59956709956708
  variance(sorted_array)                          //> res6: Double = 168.59956709956708
  breeze.stats.DescriptiveStats.percentile(v1.toArray, .25)
                                                  //> res7: Double = 10.5

}