package lab.math.aleks.introstats

import lab.math.aleks.introstats.Frequency_lab_1._

object Frequency_tests_2 {

	val data1 = List(13,9,5,11,6,3,12,10,12,12,12,9,9,4,4,2,2,10)
                                                  //> data1  : List[Int] = List(13, 9, 5, 11, 6, 3, 12, 10, 12, 12, 12, 9, 9, 4, 4
                                                  //| , 2, 2, 10)
  data1.length                                    //> res0: Int = 18
  groupByClassSize(data1, 1.5, 2)                 //> ---------------------------------------
                                                  //| initial:1.5
                                                  //| frequency:3 midpoint:2.5 upperBound:3.5
                                                  //| frequency:3 midpoint:4.5 upperBound:5.5
                                                  //| frequency:1 midpoint:6.5 upperBound:7.5
                                                  //| frequency:3 midpoint:8.5 upperBound:9.5
                                                  //| frequency:3 midpoint:10.5 upperBound:11.5
                                                  //| frequency:5 midpoint:12.5 upperBound:13.5
  
  val data2 = List(57,53,50,46,42,35,31,56,52,49,45,41,37,34,48,48,48,44,44,40)
                                                  //> data2  : List[Int] = List(57, 53, 50, 46, 42, 35, 31, 56, 52, 49, 45, 41, 37
                                                  //| , 34, 48, 48, 48, 44, 44, 40)
  data2.length                                    //> res1: Int = 20
  groupByClassSize(data2, 30.5, 6)                //> ---------------------------------------
                                                  //| initial:30.5
                                                  //| frequency:3 midpoint:33.5 upperBound:36.5
                                                  //| frequency:4 midpoint:39.5 upperBound:42.5
                                                  //| frequency:7 midpoint:45.5 upperBound:48.5
                                                  //| frequency:4 midpoint:51.5 upperBound:54.5
                                                  //| frequency:2 midpoint:57.5 upperBound:60.5
}