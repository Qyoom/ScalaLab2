package lab.math.vectorspace

import breeze.linalg._
import breeze.numerics._
import breeze.math._
import breeze.stats._

object SimpleLinearRegression_lab_2_ws {
  
  // ------ Simple Linear Regression Model------ //
  // Referencing John Hopkins Least squares estimation of regression lines
	// Referencing file:///Users/hieronymus/Development/Courses/Coursera/Signature%20courses/Johns%20Hopkins%20-%20Data%20Science%20Series/github_teaching_materials_v2/courses/07_RegressionModels/01_03_ols/index.html#4
	
	// Following http://www.mathsisfun.com/data/correlation.html
	def pearsons(X: DenseVector[Double], Y: DenseVector[Double]): Double = {
	
		val a = X :- mean(X)
		val a_sq = pow(a, 2)
		val a_sq_sum = a_sq.sum
				
		val b = Y :- mean(Y)
		val b_sq = pow(b, 2)
		val b_sq_sum = b_sq.sum
		
		val ab_dot = a dot b
		val sqrt_ab = sqrt(a_sq_sum * b_sq_sum)
		
		val result = ab_dot / sqrt_ab
		
		// Diagnostic
		/*
		println("a:" + a)
		println("a_sq:" + a_sq)
		println("a_sq_sum:" + a_sq_sum)
		println("b:" + b)
		println("b_sq:" + b_sq)
		println("b_sq_sum:" + b_sq_sum)
		println("ab_prod:" + ab_dot)
		*/
		
		result
	}                                         //> pearsons: (X: breeze.linalg.DenseVector[Double], Y: breeze.linalg.DenseVect
                                                  //| or[Double])Double
	
	// Derive model from observations
	// Returns slope and intercept
	def deriveModel(X: DenseVector[Double], Y: DenseVector[Double]) = {
		val slope = pearsons(Y,X) * (stddev(Y) / stddev(X))
		val intercept = mean(Y) - slope * mean(X)
		
		println("slope:" + slope + " intercept:" + intercept)
		(slope, intercept)
	}                                         //> deriveModel: (X: breeze.linalg.DenseVector[Double], Y: breeze.linalg.DenseV
                                                  //| ector[Double])(Double, Double)
	
	val Temp = DenseVector(14.2d, 16.4, 11.9, 15.2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
                                                  //> Temp  : breeze.linalg.DenseVector[Double] = DenseVector(14.2, 16.4, 11.9, 1
                                                  //| 5.2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
  val Sales = DenseVector(215d, 325, 185, 332, 406, 522, 412, 614, 544, 421, 445, 408)
                                                  //> Sales  : breeze.linalg.DenseVector[Double] = DenseVector(215.0, 325.0, 185.
                                                  //| 0, 332.0, 406.0, 522.0, 412.0, 614.0, 544.0, 421.0, 445.0, 408.0)
  deriveModel(Temp, Sales)                        //> Jan 14, 2015 4:49:47 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader1432748053294550156netlib-native_system-osx-x86_64.jnilib
                                                  //| slope:30.087861794245182 intercept:-159.47415234086208
                                                  //| res0: (Double, Double) = (30.087861794245182,-159.47415234086208)
	
	//val X = DenseVector(216.3, 237.3, 255.8, 285.0, 296.7)
	//val Y = DenseVector(210.9, 245.1, 247.1, 301.4, 295.4)
  //mean(X)
  //stddev(X)
  //pearsons(X,Y)
}