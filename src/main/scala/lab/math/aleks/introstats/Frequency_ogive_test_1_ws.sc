package lab.math.aleks.introstats

import lab.math.aleks.introstats.Frequency_lab_2._

object Frequency_ogive_test_1_ws {
	val data1 = List(13,9,5,11,6,3,12,10,12,12,12,9,9,4,4,2,2,10)
                                                  //> data1  : List[Int] = List(13, 9, 5, 11, 6, 3, 12, 10, 12, 12, 12, 9, 9, 4, 4
                                                  //| , 2, 2, 10)
  data1.length                                    //> res0: Int = 18
  groupByClassSize(data1, 1.5, 2)                 //> ---------------------------------------
                                                  //| initial:1.5
                                                  //| frequency:3 relative freq:0.167 cumulative freq:3 cumulative relative freq:0
                                                  //| .167 midpoint:2.5 upperBound:3.5
                                                  //| frequency:3 relative freq:0.167 cumulative freq:6 cumulative relative freq:0
                                                  //| .334 midpoint:4.5 upperBound:5.5
                                                  //| frequency:1 relative freq:0.056 cumulative freq:7 cumulative relative freq:0
                                                  //| .39 midpoint:6.5 upperBound:7.5
                                                  //| frequency:3 relative freq:0.167 cumulative freq:10 cumulative relative freq:
                                                  //| 0.557 midpoint:8.5 upperBound:9.5
                                                  //| frequency:3 relative freq:0.167 cumulative freq:13 cumulative relative freq:
                                                  //| 0.724 midpoint:10.5 upperBound:11.5
                                                  //| frequency:5 relative freq:0.278 cumulative freq:18 cumulative relative freq:
                                                  //| 1.002 midpoint:12.5 upperBound:13.5
  
}