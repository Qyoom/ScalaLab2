package matrixlike
import math._
import matrixlike.MatrixOps._

object fit_lab_1 {
	// convenience, transform List[] to List[List[]]
	def th(list: List[Double]): List[List[Double]] = {
		list.map(d => List(d))
	}                                         //> th: (list: List[Double])List[List[Double]]

	val theta = th(List(0.0, 0.0))            //> theta  : List[List[Double]] = List(List(0.0), List(0.0))
	
	val X = List(1.0, 2.0, 3.0, 4.0)          //> X  : List[Double] = List(1.0, 2.0, 3.0, 4.0)
	val y = List(2.0, 4.0, 9.0, 16.0)         //> y  : List[Double] = List(2.0, 4.0, 9.0, 16.0)
	val intercept = List(1.0, 1.0, 1.0, 1.0)  //> intercept  : List[Double] = List(1.0, 1.0, 1.0, 1.0)
	val X2 = List(intercept, X).transpose     //> X2  : List[List[Double]] = List(List(1.0, 1.0), List(1.0, 2.0), List(1.0, 3.
                                                  //| 0), List(1.0, 4.0))
  // theta (0,0) applied to X with intercept
	val X3 = matxProd(X2, theta).flatten      //> X3  : List[Double] = List(0.0, 0.0, 0.0, 0.0)
	size(X2)                                  //> res0: (Double, Double) = (4.0,2.0)
	size(theta)                               //> res1: (Double, Double) = (2.0,1.0)
	size(matxProd(X2, theta))                 //> res2: (Double, Double) = (4.0,1.0)
	
	// cost formula
	diff(X, y)                                //> res3: List[Double] = List(-1.0, -2.0, -6.0, -12.0)
	dotPow(diff(X, y), 2)                     //> res4: List[Double] = List(1.0, 4.0, 36.0, 144.0)
	dotPow(diff(X, y), 2).reduceRight(_+_)    //> res5: Double = 185.0
	dotPow(diff(X, y), 2).reduceRight(_+_)/2  //> res6: Double = 92.5
	
	// cost function (see formula above)
	def cost(in: List[Double], target: List[Double]): Double = {
		dotPow(diff(in, target), 2).reduceRight(_+_)/2
	}                                         //> cost: (in: List[Double], target: List[Double])Double
	
	cost(X, y)                                //> res7: Double = 92.5
	
	cost(X3, y)                               //> res8: Double = 178.5
	
	// some theta adjustments (by hand)
	val theta2 = th(List(0.1, 0.1))           //> theta2  : List[List[Double]] = List(List(0.1), List(0.1))
	val X4 = matxProd(X2, theta2).flatten     //> X4  : List[Double] = List(0.2, 0.30000000000000004, 0.4, 0.5)
	cost(X4, y)                               //> res9: Double = 165.57
	
	val theta3 = th(List(1.0, 1.0))           //> theta3  : List[List[Double]] = List(List(1.0), List(1.0))
	val X5 = matxProd(X2, theta3).flatten     //> X5  : List[Double] = List(2.0, 3.0, 4.0, 5.0)
	cost(X5, y)                               //> res10: Double = 73.5
	
	val theta4 = th(List(1.0, 2.0))           //> theta4  : List[List[Double]] = List(List(1.0), List(2.0))
	val X6 = matxProd(X2, theta4).flatten     //> X6  : List[Double] = List(3.0, 5.0, 7.0, 9.0)
	cost(X6, y)                               //> res11: Double = 27.5
	
	val theta5 = th(List(1.0, 2.5))           //> theta5  : List[List[Double]] = List(List(1.0), List(2.5))
	val X7 = matxProd(X2, theta5).flatten     //> X7  : List[Double] = List(3.5, 6.0, 8.5, 11.0)
	cost(X7, y)                               //> res12: Double = 15.75
	
	val theta6 = th(List(-1.0, 3.5))          //> theta6  : List[List[Double]] = List(List(-1.0), List(3.5))
	val X8 = matxProd(X2, theta6).flatten     //> X8  : List[Double] = List(2.5, 6.0, 9.5, 13.0)
	cost(X8, y)                               //> res13: Double = 6.75
	
	val theta7 = th(List(-2.0, 4.0))          //> theta7  : List[List[Double]] = List(List(-2.0), List(4.0))
	val X9 = matxProd(X2, theta7).flatten     //> X9  : List[Double] = List(2.0, 6.0, 10.0, 14.0)
	cost(X9, y)                               //> res14: Double = 4.5
	
	val theta8 = th(List(-2.7, 4.3))          //> theta8  : List[List[Double]] = List(List(-2.7), List(4.3))
	val X10 = matxProd(X2, theta8).flatten    //> X10  : List[Double] = List(1.5999999999999996, 5.8999999999999995, 10.2, 14
                                                  //| .5)
	cost(X10, y)                              //> res15: Double = 3.7299999999999986
}