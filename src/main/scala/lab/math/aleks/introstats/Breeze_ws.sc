package lab.math.aleks.introstats
import breeze.linalg._

object Breeze_ws {
  val v1 = DenseVector(58,27,44,23,91,68,-90,-81,-89,-91,18,-74,5,99)
                                                  //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(58, 27, 44, 23, 91, 68, -
                                                  //| 90, -81, -89, -91, 18, -74, 5, 99)
  
  (v1 :* -10).sum                                 //> res0: Int = -80
  
  v1                                              //> res1: breeze.linalg.DenseVector[Int] = DenseVector(58, 27, 44, 23, 91, 68, -
                                                  //| 90, -81, -89, -91, 18, -74, 5, 99)
}