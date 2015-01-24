package lab.math.vectorspace

import breeze.linalg._

// COMPARISON OF TWO WAYS TO DERIVE REGRESSION MODEL
object SimpleLinearRegression_lab_2_ws {

  	// Data and model: http://www.mathsisfun.com/data/correlation.html
	val Temp = DenseVector(14.2d, 16.4, 11.9, 15.2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
                                                  //> Temp  : breeze.linalg.DenseVector[Double] = DenseVector(14.2, 16.4, 11.9, 15
                                                  //| .2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
  val Sales = DenseVector(215d, 325, 185, 332, 406, 522, 412, 614, 544, 421, 445, 408)
                                                  //> Sales  : breeze.linalg.DenseVector[Double] = DenseVector(215.0, 325.0, 185.0
                                                  //| , 332.0, 406.0, 522.0, 412.0, 614.0, 544.0, 421.0, 445.0, 408.0)
  // Simpler model
  def deriveModel1(X: DenseVector[Double], Y: DenseVector[Double]) =
  		lab.math.vectorspace.SimpleLinearRegression_lab_1.deriveModel(X,Y)
                                                  //> deriveModel1: (X: breeze.linalg.DenseVector[Double], Y: breeze.linalg.DenseV
                                                  //| ector[Double])(Double, Double)
  val model1, (slope1, intercept1) = deriveModel1(Temp, Sales)
                                                  //> model1  : (Double, Double) = (30.0878617942452,-159.47415234086242)
                                                  //| slope1  : Double = 30.0878617942452
                                                  //| intercept1  : Double = -159.47415234086242
  
  // Uses correlation and standard deviation
  def deriveModel2(X: DenseVector[Double], Y: DenseVector[Double]) =
  		lab.math.vectorspace.SimpleLinearRegression_lab_2.deriveModel(X,Y)
                                                  //> deriveModel2: (X: breeze.linalg.DenseVector[Double], Y: breeze.linalg.DenseV
                                                  //| ector[Double])(Double, Double)
	val model2, (slope2, intercept2) = deriveModel2(Temp, Sales)
                                                  //> Jan 23, 2015 11:29:19 AM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader7175239026309033459netlib-native_system-osx-x86_64.jnilib
                                                  //| model2  : (Double, Double) = (30.087861794245182,-159.47415234086208)
                                                  //| slope2  : Double = 30.087861794245182
                                                  //| intercept2  : Double = -159.47415234086208
  
}