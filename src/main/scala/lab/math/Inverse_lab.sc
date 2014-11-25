package lab.math
import math._

// The inverse function of f(x) is the function that "un-does" what ever f does so that
// the original x is returned
object Inverse_lab {
	def cube = (x: Double) => pow(x, 3)       //> cube: => Double => Double
	def cubeRoot = (x: Double) => pow(x, 1.0/3)
                                                  //> cubeRoot: => Double => Double
  cube(3)                                         //> res0: Double = 27.0
  cubeRoot(27)                                    //> res1: Double = 3.0
  
  cube(cubeRoot(27))                              //> res2: Double = 27.0
  cubeRoot(cube(3))                               //> res3: Double = 3.0
  
  cube(5)                                         //> res4: Double = 125.0
  cubeRoot(125)                                   //> res5: Double = 5.0
  
  cube(cubeRoot(125))                             //> res6: Double = 125.0
  cubeRoot(cube(5))                               //> res7: Double = 5.0
}