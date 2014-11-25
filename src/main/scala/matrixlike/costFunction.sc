package matrixlike

import matrixlike.MatrixOps._

object costFunction {
  val x = List(2.1, 4.5, 5.8, 7.6, 11.0, 11.8)    //> x  : List[Double] = List(2.1, 4.5, 5.8, 7.6, 11.0, 11.8)
  val y = List(1.1, 3.4, 4.9, 5.2, 8.0, 10)       //> y  : List[Double] = List(1.1, 3.4, 4.9, 5.2, 8.0, 10.0)
  
  val theta1 = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0) //> theta1  : List[Double] = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
	  
	val prod1 = elemWiseProd(x, theta1)       //> prod1  : List[Double] = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
	diff(prod1, y)                            //> res0: List[Double] = List(-1.1, -3.4, -4.9, -5.2, -8.0, -10.0)
	val sqrErrs = elemWisePow(diff(prod1, y), 2)
                                                  //> sqrErrs  : List[Double] = List(1.2100000000000002, 11.559999999999999, 24.01
                                                  //| 0000000000005, 27.040000000000003, 64.0, 100.0)
	val J = 1.0 / (2.0 * x.length) * sqrErrs.reduceLeft(_+_)
                                                  //> J  : Double = 18.985
}