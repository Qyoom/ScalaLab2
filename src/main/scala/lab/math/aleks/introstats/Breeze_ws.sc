package lab.math.aleks.introstats
import breeze.linalg._

object Breeze_ws {
  val v1 = DenseVector(58,27,44,23,91,68,-90,-81,-89,-91,18,-74,5,99)
                                                  //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(58, 27, 44, 23, 91, 68, -
                                                  //| 90, -81, -89, -91, 18, -74, 5, 99)
  
  (v1 :* -10).sum                                 //> res0: Int = -80
  v1 * -10                                        //> res1: breeze.linalg.DenseVector[Int] = DenseVector(-580, -270, -440, -230, -
                                                  //| 910, -680, 900, 810, 890, 910, -180, 740, -50, -990)
  
  v1                                              //> res2: breeze.linalg.DenseVector[Int] = DenseVector(58, 27, 44, 23, 91, 68, -
                                                  //| 90, -81, -89, -91, 18, -74, 5, 99)
}