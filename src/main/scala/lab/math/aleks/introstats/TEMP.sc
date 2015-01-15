package lab.math.aleks.introstats

import lab.math.vectorspace.SimpleLinearRegression_lab_1._
import breeze.linalg._
import breeze.numerics._
import breeze.stats.mean

object TEMP {

	val Temp = DenseVector(14.2d, 16.4, 11.9, 15.2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
                                                  //> Temp  : breeze.linalg.DenseVector[Double] = DenseVector(14.2, 16.4, 11.9, 15
                                                  //| .2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2)
  val Sales = DenseVector(215d, 325, 185, 332, 406, 522, 412, 614, 544, 421, 445, 408)
                                                  //> Sales  : breeze.linalg.DenseVector[Double] = DenseVector(215.0, 325.0, 185.0
                                                  //| , 332.0, 406.0, 522.0, 412.0, 614.0, 544.0, 421.0, 445.0, 408.0)
	val model, (slope, intercept) = deriveModel(Temp, Sales)
                                                  //> slope:30.0878617942452 intercept:-159.47415234086242
                                                  //| slope:30.0878617942452 intercept:-159.47415234086242
                                                  //| model  : (Double, Double) = (30.0878617942452,-159.47415234086242)
                                                  //| slope  : Double = 30.0878617942452
                                                  //| intercept  : Double = -159.47415234086242
}