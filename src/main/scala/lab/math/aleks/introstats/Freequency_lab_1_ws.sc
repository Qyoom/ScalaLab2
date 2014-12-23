package lab.math.aleks.introstats
 
import lab.math.aleks.introstats.Frequency_lab_1._

object Freequency_lab_1_ws {
  val data1 = List(57, 53, 50, 46, 42, 35, 45, 45, 41, 41, 41, 37, 37, 37)
                                                  //> data1  : List[Int] = List(57, 53, 50, 46, 42, 35, 45, 45, 41, 41, 41, 37, 37
                                                  //| , 37)
  groupByClassSize(data1, 34.5, 7)                //> ---------------------------------------
                                                  //| initial:34.5
                                                  //| frequency:7 midpoint:38.0 upperBound:41.5
                                                  //| frequency:4 midpoint:45.0 upperBound:48.5
                                                  //| frequency:2 midpoint:52.0 upperBound:55.5
                                                  //| frequency:1 midpoint:59.0 upperBound:62.5
	val data2 = List(7,2,37,32,27,22,16,11,6,1,36,31,40,40,40,34,34,29,29,24,24,9)
                                                  //> data2  : List[Int] = List(7, 2, 37, 32, 27, 22, 16, 11, 6, 1, 36, 31, 40, 40
                                                  //| , 40, 34, 34, 29, 29, 24, 24, 9)
  data2.length                                    //> res0: Int = 22
  groupByClassSize(data2, .5, 9)                  //> ---------------------------------------
                                                  //| initial:0.5
                                                  //| frequency:5 midpoint:5.0 upperBound:9.5
                                                  //| frequency:2 midpoint:14.0 upperBound:18.5
                                                  //| frequency:4 midpoint:23.0 upperBound:27.5
                                                  //| frequency:7 midpoint:32.0 upperBound:36.5
                                                  //| frequency:4 midpoint:41.0 upperBound:45.5
	val data3 = List(25,22,18,35,37,34,31,27,24,21,18,39,36,23,23,23,20,20,20)
                                                  //> data3  : List[Int] = List(25, 22, 18, 35, 37, 34, 31, 27, 24, 21, 18, 39, 36
                                                  //| , 23, 23, 23, 20, 20, 20)
  data3.length                                    //> res1: Int = 19
  groupByClassSize(data3, 17.5, 5)                //> ---------------------------------------
                                                  //| initial:17.5
                                                  //| frequency:7 midpoint:20.0 upperBound:22.5
                                                  //| frequency:6 midpoint:25.0 upperBound:27.5
                                                  //| frequency:1 midpoint:30.0 upperBound:32.5
                                                  //| frequency:4 midpoint:35.0 upperBound:37.5
                                                  //| frequency:1 midpoint:40.0 upperBound:42.5
	val data4 = List(19,15,43,39,35,31,27,22,18,14,42,26,26,21,21,21,17)
                                                  //> data4  : List[Int] = List(19, 15, 43, 39, 35, 31, 27, 22, 18, 14, 42, 26, 26
                                                  //| , 21, 21, 21, 17)
  data4.length                                    //> res2: Int = 17
  (48.5 - 13.5) / 5                               //> res3: Double = 7.0
 	groupByClassSize(data4, 13.5, 7)          //> ---------------------------------------
                                                  //| initial:13.5
                                                  //| frequency:5 midpoint:17.0 upperBound:20.5
                                                  //| frequency:7 midpoint:24.0 upperBound:27.5
                                                  //| frequency:1 midpoint:31.0 upperBound:34.5
                                                  //| frequency:2 midpoint:38.0 upperBound:41.5
                                                  //| frequency:2 midpoint:45.0 upperBound:48.5
  val data5 = List(25,22,18,35,37,34,31,27,24,21,18,39,36,17,17,32,32,35,35,32,32,29,29)
                                                  //> data5  : List[Int] = List(25, 22, 18, 35, 37, 34, 31, 27, 24, 21, 18, 39, 36
                                                  //| , 17, 17, 32, 32, 35, 35, 32, 32, 29, 29)
  data5.length                                    //> res4: Int = 23
  groupByClassSize(data5, 16.5, 5)                //> ---------------------------------------
                                                  //| initial:16.5
                                                  //| frequency:5 midpoint:19.0 upperBound:21.5
                                                  //| frequency:3 midpoint:24.0 upperBound:26.5
                                                  //| frequency:4 midpoint:29.0 upperBound:31.5
                                                  //| frequency:9 midpoint:34.0 upperBound:36.5
                                                  //| frequency:2 midpoint:39.0 upperBound:41.5
  val data6 = List(26,23,44,41,38,35,31,28,37,37,37,34,34,31,31,31)
                                                  //> data6  : List[Int] = List(26, 23, 44, 41, 38, 35, 31, 28, 37, 37, 37, 34, 34
                                                  //| , 31, 31, 31)
	data6.length                              //> res5: Int = 16
	(47.5 - 22.5) / 5d                        //> res6: Double = 5.0
	groupByClassSize(data6, 22.5, 5)          //> ---------------------------------------
                                                  //| initial:22.5
                                                  //| frequency:2 midpoint:25.0 upperBound:27.5
                                                  //| frequency:5 midpoint:30.0 upperBound:32.5
                                                  //| frequency:6 midpoint:35.0 upperBound:37.5
                                                  //| frequency:2 midpoint:40.0 upperBound:42.5
                                                  //| frequency:1 midpoint:45.0 upperBound:47.5
  val data7 = List(62,82,79,76,73,70,67,64,61,80,79,63,63,63,60,60,60,71,71)
                                                  //> data7  : List[Int] = List(62, 82, 79, 76, 73, 70, 67, 64, 61, 80, 79, 63, 63
                                                  //| , 63, 60, 60, 60, 71, 71)
  data7.length                                    //> res7: Int = 19
  groupByClassSize(data7, 59.5, 5)                //> ---------------------------------------
                                                  //| initial:59.5
                                                  //| frequency:9 midpoint:62.0 upperBound:64.5
                                                  //| frequency:1 midpoint:67.0 upperBound:69.5
                                                  //| frequency:4 midpoint:72.0 upperBound:74.5
                                                  //| frequency:3 midpoint:77.0 upperBound:79.5
                                                  //| frequency:2 midpoint:82.0 upperBound:84.5
  val data8 = List(62,82,79,76,73,70,67,64,61,80,79,75,72,60,60,60,71,71,71)
                                                  //> data8  : List[Int] = List(62, 82, 79, 76, 73, 70, 67, 64, 61, 80, 79, 75, 7
                                                  //| 2, 60, 60, 60, 71, 71, 71)
  groupByClassSize(data8, 59.5, 5)                //> ---------------------------------------
                                                  //| initial:59.5
                                                  //| frequency:6 midpoint:62.0 upperBound:64.5
                                                  //| frequency:1 midpoint:67.0 upperBound:69.5
                                                  //| frequency:6 midpoint:72.0 upperBound:74.5
                                                  //| frequency:4 midpoint:77.0 upperBound:79.5
                                                  //| frequency:2 midpoint:82.0 upperBound:84.5
}