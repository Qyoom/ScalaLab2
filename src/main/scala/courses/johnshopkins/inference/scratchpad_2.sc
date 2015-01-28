package courses.johnshopkins.inference

//import math._
import lab.math.Rounding_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.math._
import breeze.stats._

// WARNING: The correctness of anything on this page is highly suspect!!

object scratchpad_2 {
	val round = roundAt(3)_                   //> round  : Double => Double = <function1>
	
  val XA = -4                                     //> XA  : Int = -4
  val XB = 1                                      //> XB  : Int = 1
  val pXA = -4 * .2                               //> pXA  : Double = -0.8
  val pXB = 1 * .8                                //> pXB  : Double = 0.8
  val mu = (pXA + pXB) / 2                        //> mu  : Double = 0.0
  val XA_resid = XA - mu                          //> XA_resid  : Double = -4.0
  val XB_resid = XB - mu                          //> XB_resid  : Double = 1.0
  val varXA = math.pow(XA_resid, 2) * .2          //> varXA  : Double = 3.2
  val varXB = math.pow(XB_resid, 2) * .8          //> varXB  : Double = 0.8
  // Variance. This is just a total, no average
  val vari = (varXA + varXB)                      //> vari  : Double = 4.0
  
  // ------------------------------------- //
  
  val x = DenseVector(2d,3,4,5)                   //> x  : breeze.linalg.DenseVector[Double] = DenseVector(2.0, 3.0, 4.0, 5.0)
  val p = DenseVector(.1, .2, .3, .4)             //> p  : breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2, 0.3, 0.4)
  
 	(x.map(x => pow(x,2)) :* p).sum - pow((x :* p).sum, 2)
                                                  //> res0: Double = 1.0
                                                  
  // ------------------------------------- //
  
  val X = DenseVector(1.0,  2.0,  3.0,  4.0)      //> X  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 2.0, 3.0, 4.0)
  val Prob = DenseVector(0.1,  0.2,  0.3,  0.4)   //> Prob  : breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2, 0.3, 0.4)
  (X :* Prob).sum                                 //> res1: Double = 3.0
  X dot Prob                                      //> Jan 27, 2015 8:51:44 AM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader2263660906091817153netlib-native_system-osx-x86_64.jnilib
                                                  //| res2: Double = 3.0
  
  // ----- Variance and Standard Deviation ------------- //
  
  val X_mean = X.sum / X.length                   //> X_mean  : Double = 2.5
  mean(X)                                         //> res3: Double = 2.5
  (X :- X_mean).sum                               //> res4: Double = 0.0
  X.map(x => (x - X_mean)).sum                    //> res5: Double = 0.0
  X :- X_mean                                     //> res6: breeze.linalg.DenseVector[Double] = DenseVector(-1.5, -0.5, 0.5, 1.5)
                                                  //| 
  X.map(x => (x - X_mean))                        //> res7: breeze.linalg.DenseVector[Double] = DenseVector(-1.5, -0.5, 0.5, 1.5)
                                                  //| 
  X.map(x => pow(x - X_mean, 2))                  //> res8: breeze.linalg.DenseVector[Double] = DenseVector(2.25, 0.25, 0.25, 2.2
                                                  //| 5)
  pow(X :- X_mean, 2)                             //> res9: breeze.linalg.DenseVector[Double] = DenseVector(2.25, 0.25, 0.25, 2.2
                                                  //| 5)
  X.map(x => pow(x - X_mean, 2)).sum              //> res10: Double = 5.0
  pow(X :- X_mean, 2).sum                         //> res11: Double = 5.0
  
  pow(X :- X_mean, 2).sum                         //> res12: Double = 5.0
  
  val empiricalVariance = pow(X :- X_mean, 2).sum / X.length - 1
                                                  //> empiricalVariance  : Double = 0.25
  variance(X)                                     //> res13: Double = 1.6666666666666667
  // empirical standard deviation
  val empSD_X = sqrt(empiricalVariance)           //> empSD_X  : Double = 0.5
  stddev(X)                                       //> res14: Double = 1.2909944487358056
  // The data defined by Xi/s have empirical standard deviation 1. This is called "scaling" the data.
	X :/ empSD_X                              //> res15: breeze.linalg.DenseVector[Double] = DenseVector(2.0, 4.0, 6.0, 8.0)
	
	// ----- Normalization ------------- //
	
	// The process of centering then scaling the data is called "normalizing" the data.
	// The data defined by
	val Z = 	(X :- X_mean) / empSD_X   //> Z  : breeze.linalg.DenseVector[Double] = DenseVector(-3.0, -1.0, 1.0, 3.0)
	// have empirical mean zero and empirical standard deviation 1
	mean(Z)                                   //> res16: Double = 0.0
	stddev(Z)                                 //> res17: Double = 2.581988897471611
	
	// ----- Empirical Covariance ----------------- //
	
	val Y = DenseVector(1.7,  2.3,  3.8,  4.5)//> Y  : breeze.linalg.DenseVector[Double] = DenseVector(1.7, 2.3, 3.8, 4.5)
	X - mean(X)                               //> res18: breeze.linalg.DenseVector[Double] = DenseVector(-1.5, -0.5, 0.5, 1.5
                                                  //| )
	(Y - mean(Y)).map(x => round(x))          //> res19: breeze.linalg.DenseVector[Double] = DenseVector(-1.375, -0.775, 0.72
                                                  //| 5, 1.425)
	
  // Covariance
  val covXY = variance(X) * variance(Y)           //> covXY  : Double = 2.804166666666667
  val coStDevXY = stddev(X) * stddev(Y)           //> coStDevXY  : Double = 1.67456462003312
  // Correlation
  covXY / coStDevXY                               //> res20: Double = 1.67456462003312
}
//
//
//
//
//