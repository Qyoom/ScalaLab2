package calculus_lab
import math._
 
object KhanLimit_lab_1 {
	def limEx1(x: Double) = (2.0 / (pow(E, x) - 1.0)) - 2.0/x
                                                  //> limEx1: (x: Double)Double
  limEx1(0.2)                                     //> res0: Double = -0.9666888677460115
  limEx1(0.1)                                     //> res1: Double = -0.9833361104499154
  limEx1(0.01)                                    //> res2: Double = -0.9983333361089706
  limEx1(0.001)                                   //> res3: Double = -0.9998333334219751
  
  // atan is the same as tan^-1 i.e. inverse of tangent
	def limEx2(x: Double) = x / (atan(4*x))   //> limEx2: (x: Double)Double
	
	// 0.2628
	// 0.2964
	// 0.3424
  limEx2(-0.01)                                   //> res4: Double = 0.25013327649207334
  limEx2(-0.1)                                    //> res5: Double = 0.26280768474602895
  limEx2(-0.2)                                    //> res6: Double = 0.2964100553034719
  limEx2(-0.3)                                    //> res7: Double = 0.3424430604743062
  
  limEx2(-0.001)                                  //> res8: Double = 0.25000133332764446
  
  /*
		 t			 f(t)
		-1.1		-2.331
		-1.01		-2.030301
		-1.001
		-0.999
		-0.99		-1.970299
		-0.9		-1.729
  */
  def limEx3(t: Double) = (pow(t,6) - 1) / (pow(t,3) + 1)
                                                  //> limEx3: (t: Double)Double
  limEx3(-1.1)                                    //> res9: Double = -2.3309999999999995
  limEx3(-1.01)                                   //> res10: Double = -2.0303009999999957
  limEx3(-1.001)                                  //> res11: Double = -2.003003000999952
  limEx3(-0.999)                                  //> res12: Double = -1.9970029990000013
  limEx3(-0.99)                                   //> res13: Double = -1.9702990000000016
  limEx3(-0.9)                                    //> res14: Double = -1.7290000000000003
  
  def limEx3_5(t: Double) = pow(t, 3) - 1         //> limEx3_5: (t: Double)Double
  limEx3_5(-1.1)                                  //> res15: Double = -2.3310000000000004
  limEx3_5(-1.01)                                 //> res16: Double = -2.030301
  
  
  /*
		t	f(t)
		0.99		-0.340022
		0.999		-0.334000
		0.9999	-0.333400
		1.0001
		1.001	-0.332667
		1.01		-0.326689
  */
  def limEx4(t: Double) = ((pow(t,3)) - (2*pow(t,2)) + 1) / (pow(t,3) - 1)
                                                  //> limEx4: (t: Double)Double
  limEx4(0.99)                                    //> res17: Double = -0.3400222214740274
  limEx4(0.999)                                   //> res18: Double = -0.33400022222213044
  limEx4(0.9999)                                  //> res19: Double = -0.3334000022216686
  limEx4(1.0001)                                  //> res20: Double = -0.3332666688888989
  limEx4(1.001)                                   //> res21: Double = -0.3326668888887343
  limEx4(1.01)                                    //> res22: Double = -0.326688888155501
  
  limEx4(0.999999)                                //> res23: Double = -0.33333400003526215
  limEx4(1.000001)                                //> res24: Double = -0.3333326667067527
}