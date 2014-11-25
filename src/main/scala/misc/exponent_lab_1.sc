package misc
import math._
object exponent_lab_1 {
	pow(3,4)                                  //> res0: Double = 81.0
	pow(3, .0073)                             //> res1: Double = 1.008052115005728
	pow(3, 1)                                 //> res2: Double = 3.0
	pow(3, 0)                                 //> res3: Double = 1.0
	pow(3, 1.5)                               //> res4: Double = 5.196152422706632
	
	//nx^n-1
	3*pow(5,3-1)                              //> res5: Double = 75.0
	pow((3*5),3-1)                            //> res6: Double = 225.0
}