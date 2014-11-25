package matrixlike
import matrixlike.MatrixOps._

object Gradient {
  
  val x = List(2.1, 4.5, 5.8, 7.6, 11.0, 11.8)    //> x  : List[Double] = List(2.1, 4.5, 5.8, 7.6, 11.0, 11.8)
  val y = List(1.1, 3.4, 4.9, 5.2, 8.0, 10)       //> y  : List[Double] = List(1.1, 3.4, 4.9, 5.2, 8.0, 10.0)
  val bias = List(1.0, 1.0, 1.0, 1.0, 1.0, 1.0)   //> bias  : List[Double] = List(1.0, 1.0, 1.0, 1.0, 1.0, 1.0)
  
  val theta_m = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)//> theta_m  : List[Double] = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
  val theta = colVectToMatrix(List(0.0, 0.0))     //> theta  : List[List[Double]] = List(List(0.0), List(0.0))
	  
	val prod1 = elemWiseProd(x, theta_m)      //> prod1  : List[Double] = List(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
	diff(prod1, y)                            //> res0: List[Double] = List(-1.1, -3.4, -4.9, -5.2, -8.0, -10.0)
	val sqrErrs = elemWisePow(diff(prod1, y), 2)
                                                  //> sqrErrs  : List[Double] = List(1.2100000000000002, 11.559999999999999, 24.01
                                                  //| 0000000000005, 27.040000000000003, 64.0, 100.0)
	val J = 1.0 / (2.0 * x.length) * sqrErrs.reduceLeft(_+_)
                                                  //> J  : Double = 18.985
                                                  
  val X = List(bias, x).transpose                 //> X  : List[List[Double]] = List(List(1.0, 2.1), List(1.0, 4.5), List(1.0, 5.8
                                                  //| ), List(1.0, 7.6), List(1.0, 11.0), List(1.0, 11.8))
  size(X)                                         //> res1: (Double, Double) = (6.0,2.0)
  size(theta)                                     //> res2: (Double, Double) = (2.0,1.0)
  size(matxProd(X, theta))                        //> res3: (Double, Double) = (6.0,1.0)
  val totDiffs = diff(matxProd(X, theta).flatten, y)
                                                  //> totDiffs  : List[Double] = List(-1.1, -3.4, -4.9, -5.2, -8.0, -10.0)
}