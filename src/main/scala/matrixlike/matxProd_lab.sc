package matrixlike

import matrixlike.MatrixOps._

object matxProd_lab {
  val x = List(
  					List(2.0,4.0,6.0,8),
  					List(3.0,5.0,7.0,9),
  					List(2.0,3.0,4.0,5)
  				)                 //> x  : List[List[Double]] = List(List(2.0, 4.0, 6.0, 8.0), List(3.0, 5.0, 7.0,
                                                  //|  9.0), List(2.0, 3.0, 4.0, 5.0))
  				
  val y = List(
  					List(2.0,4.0,6.0,8),
  					List(3.0,5.0,7.0,9),
  					List(2.0,3.0,4.0,5)
  				)                 //> y  : List[List[Double]] = List(List(2.0, 4.0, 6.0, 8.0), List(3.0, 5.0, 7.0,
                                                  //|  9.0), List(2.0, 3.0, 4.0, 5.0))
  				
  val w = List(
  					List(2.0,4.0,6.0,8),
  					List(3.0,5.0,7.0,9)
  				)                 //> w  : List[List[Double]] = List(List(2.0, 4.0, 6.0, 8.0), List(3.0, 5.0, 7.0,
                                                  //|  9.0))
 
 	val prod1 = matxProd(x, transpose(y))     //> prod1  : List[List[Double]] = List(List(120.0, 140.0, 80.0), List(140.0, 164
                                                  //| .0, 94.0), List(80.0, 94.0, 54.0))
 	val prod2 = matxProd(x, transpose(w))     //> prod2  : List[List[Double]] = List(List(120.0, 140.0), List(140.0, 164.0), L
                                                  //| ist(80.0, 94.0))
 	size(x)                                   //> res0: (Double, Double) = (3.0,4.0)
  size(y)                                         //> res1: (Double, Double) = (3.0,4.0)
  size(w)                                         //> res2: (Double, Double) = (2.0,4.0)
 	size(prod1)                               //> res3: (Double, Double) = (3.0,3.0)
 	size(prod2)                               //> res4: (Double, Double) = (3.0,2.0)
 	
}