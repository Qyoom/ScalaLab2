package lab.math.calculus.derivative

import scala.math._

object PowerRule_1 {

  // https://www.mathsisfun.com/calculus/derivatives-rules.html
  
  def powerRule(n: Int)(x: Double): Double = {
    n * pow(x, n-1)
  }                                               //> powerRule: (n: Int)(x: Double)Double
  
  // ------------------------- //
  
  def derivPow2 = powerRule(2)_                   //> derivPow2: => Double => Double
  def derivPow3 = powerRule(3)_                   //> derivPow3: => Double => Double

  derivPow2(2)                                    //> res0: Double = 4.0
  derivPow2(3)                                    //> res1: Double = 6.0
  derivPow2(4)                                    //> res2: Double = 8.0
  
  derivPow3(2)                                    //> res3: Double = 12.0
  derivPow3(3)                                    //> res4: Double = 27.0
  derivPow3(4)                                    //> res5: Double = 48.0
  
  '''                                             //> res6: Char('\'') = '
}