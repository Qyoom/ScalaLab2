package lab.math.vectorspace

import lab.math.vectorspace.EuclideanLabBreeze2._
import breeze.linalg._
import breeze.numerics._

object EuclideanNorm_lab_ws {
  val A = DenseVector(4d, -3)                     //> A  : breeze.linalg.DenseVector[Double] = DenseVector(4.0, -3.0)
  // Each of these three are the same
  eucNorm(A)                                      //> res0: Double = 5.0
  sqrt(pow(A, 2).sum)                             //> res1: Double = 5.0
  sqrt(A dot A)                                   //> Jan 05, 2015 9:36:50 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader6657822692365315319netlib-native_system-osx-x86_64.jnilib
                                                  //| res2: Double = 5.0
}