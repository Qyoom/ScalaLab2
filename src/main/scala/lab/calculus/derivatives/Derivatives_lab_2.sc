package lab.calculus.derivatives

import lab.calculus.derivatives.Derivative3._
import scala.math._

object Derivatives_lab_2 {

	/** Collins Intro Calculus, Ch.3 Derivatives - Tangent lines (slope), p.88, Ex.3.1(a) **/
	
	def fa(x: Double) = 4 * x - 6             //> fa: (x: Double)Double
	val x0 = 1                                //> x0  : Int = 1
	val x1 = -2                               //> x1  : Int = -2
	
	// ----- model A --------------- //
	
	val dmA_fa = derivative_model_A(fa)_      //> dmA_fa  : Double => Double = <function1>
	// This is correct per book and my by-hand work.
	dmA_fa(x0)                                //> initial slope: 4.0
                                                  //| derivative step: 4.0
                                                  //| res0: Double = 4.0
	
	// Variations indicate linear function
	val dmA_fa_v2 = derivative_model_A(fa, x1)(x0)
                                                  //> initial slope: 4.0
                                                  //| derivative step: 4.0
                                                  //| derivative step: 4.0
                                                  //| dmA_fa_v2  : Double = 4.0
  dmA_fa(2)                                       //> initial slope: 4.0
                                                  //| derivative step: 4.0
                                                  //| derivative step: 4.0
                                                  //| res1: Double = 4.0
  dmA_fa(3)                                       //> initial slope: 4.0
                                                  //| derivative step: 4.0
                                                  //| derivative step: 4.0
                                                  //| res2: Double = 4.0
  dmA_fa(5)                                       //> initial slope: 4.0
                                                  //| derivative step: 4.0
                                                  //| derivative step: 4.0
                                                  //| res3: Double = 4.0
  // ----- model B --------------- //
  
  val dmB_fa = derivative_model_B(fa)_            //> dmB_fa  : Double => Double = <function1>
  dmB_fa(x0)                                      //> res4: Double = 4.000000330961484
  dmB_fa(2)                                       //> res5: Double = 4.000000330961484
  dmB_fa(5)                                       //> res6: Double = 4.000000330961484
  
  /** Collins Intro Calculus, Ch.3 Derivatives, p.88, Ex.3.1(b) **/
  
  def fb(x: Double) = pow(x,2) - 3*x              //> fb: (x: Double)Double
  
  // ----- model A --------------- //
  
  val dmA_fb = derivative_model_B(fb)_            //> dmA_fb  : Double => Double = <function1>
  // This is correct per the book and by hand
  dmA_fb(-1)                                      //> res7: Double = -5.000000413701855
  
	val dmA_fb_v2 = derivative_model_A(fb, 4)(-1)
                                                  //> initial slope: 0.0
                                                  //| derivative step: -4.999949999995863
                                                  //| derivative step: -5.0
                                                  //| dmA_fb_v2  : Double = -5.0
	// Variations indicate non-linear function
	dmA_fb(-2)                                //> res8: Double = -7.000000579182597
	dmA_fb(2)                                 //> res9: Double = 1.000000082740371
	
	// ----- model B --------------- //
  
  val dmB_fb = derivative_model_B(fb)_            //> dmB_fb  : Double => Double = <function1>
  dmB_fb(-1)                                      //> res10: Double = -5.000000413701855
  dmB_fb(-2)                                      //> res11: Double = -7.000000579182597
  dmB_fb(2)                                       //> res12: Double = 1.000000082740371
}
/*



*/