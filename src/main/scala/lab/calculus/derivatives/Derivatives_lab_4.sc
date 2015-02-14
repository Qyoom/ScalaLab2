package lab.calculus.derivatives

import lab.calculus.derivatives.Derivative3._
import scala.math._

object Derivatives_lab_4 {

	/** Collins Intro Calculus, Ch.3 Derivatives - Finding Slope in General, p.89, Ex.3.2(c) **/
	
	def fc(x: Double) = sqrt(x + 2)           //> fc: (x: Double)Double
	
	// ----- Model A ----------------------- //
	
	val dmA_fc = derivative_model_A(fc)_      //> dmA_fc  : Double => Double = <function1>
	dmA_fc(1)                                 //> initial slope: 0.31783724519578205
                                                  //| derivative step: 0.28867537516095537
                                                  //| res0: Double = 0.28867537516095537
	dmA_fc(2)                                 //> initial slope: 0.2928932188134524
                                                  //| derivative step: 0.25000031250835253
                                                  //| derivative step: 0.25
                                                  //| res1: Double = 0.25
	dmA_fc(-1)                                //> initial slope: 0.41421356237309515
                                                  //| derivative step: 0.4999987500054477
                                                  //| res2: Double = 0.4999987500054477
	dmA_fc(-2)                                //> initial slope: 0.7071067811865476
                                                  //| derivative step: 223.6067977504878
                                                  //| derivative step: 70710.67519334107
                                                  //| res3: Double = 70710.67519334107
  dmA_fc(5)                                       //> initial slope: 0.2463075497382991
                                                  //| derivative step: 0.1889825739724812
                                                  //| derivative step: 0.18898214761524115
                                                  //| res4: Double = 0.18898214761524115
  dmA_fc(-5)                                      //> initial slope: NaN
                                                  //| derivative step: NaN
                                                  //| derivative step: NaN
                                                  //| res5: Double = NaN
  dmA_fc(.1)                                      //> initial slope: 0.34924112245848793
                                                  //| derivative step: 0.3450328207584721
                                                  //| res6: Double = 0.3450328207584721
  dmA_fc(-0.1)                                    //> initial slope: 0.3580868716407304
                                                  //| derivative step: 0.3627380773526237
                                                  //| res7: Double = 0.3627380773526237
	
	// ----- Model B ----------------------- //
	
	val dmB_fc = derivative_model_B(fc)_      //> dmB_fc  : Double => Double = <function1>
	dmB_fc(1)                                 //> res8: Double = 0.2886757499709347
	dmB_fc(2)                                 //> res9: Double = 0.25000002068509275
	dmB_fc(-1)                                //> res10: Double = 0.5000000413701855
	dmB_fc(-2)                                //> res11: Double = 100000.00413701846
  dmB_fc(5)                                       //> res12: Double = 0.18898216325169415
  dmB_fc(-5)                                      //> res13: Double = NaN
  dmB_fc(.1)                                      //> res14: Double = 0.3450328911469569
  dmB_fc(-0.1)                                    //> res15: Double = 0.3627387279436789

	// ----- target, i.e. derived algorithm ----- //
	def f0(x: Double) = {
		1 / (2 * sqrt(x + 2))
	}                                         //> f0: (x: Double)Double
	
	f0(1)                                     //> res16: Double = 0.2886751345948129
	f0(2)                                     //> res17: Double = 0.25
	f0(-1)                                    //> res18: Double = 0.5
	f0(-2)                                    //> res19: Double = Infinity
	f0(5)                                     //> res20: Double = 0.1889822365046136
	f0(-5)                                    //> res21: Double = NaN
	f0(.1)                                    //> res22: Double = 0.34503277967117707
	f0(-0.1)                                  //> res23: Double = 0.36273812505500586
}