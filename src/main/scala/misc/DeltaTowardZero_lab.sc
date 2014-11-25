package misc

object DeltaTowardZero_lab {
	import math._
	
	5 * 0.1                                   //> res0: Double(0.5) = 0.5
	(-5) * 0.1                                //> res1: Double(-0.5) = -0.5
	
	def difference(x1: Double, x2: Double): Double = {
		abs(x1 - x2)
	}                                         //> difference: (x1: Double, x2: Double)Double
		
	difference(8, 3)                          //> res2: Double = 5.0
	difference(3, 8)                          //> res3: Double = 5.0
	difference(8, -3)                         //> res4: Double = 11.0
	difference(-3, 8)                         //> res5: Double = 11.0
	
	def closer(x1: Double, x2: Double): Double = {
		val dif = abs(x1 - x2)
		println("x1:" + x1 + " x2:" + x2 + " dif:" + dif)
		if(dif == 0) throw new NoSuchElementException("x1 - x2 == 0")
		if(dif < 0.00001) {
			println("dif:" + dif + " < 0.00001")
			x2
		}
		else {
			val newX2 = {
				if(x2 > x1) x2 - dif * .99999
				else x2 + dif * .99999
			}
			// recursion
			closer(x1, newX2)
		}
	}                                         //> closer: (x1: Double, x2: Double)Double
	
	closer(8, 3)                              //> x1:8.0 x2:3.0 dif:5.0
                                                  //| x1:8.0 x2:7.99995 dif:4.999999999988347E-5
                                                  //| x1:8.0 x2:7.9999999995 dif:5.000000413701855E-10
                                                  //| dif:5.000000413701855E-10 < 0.00001
                                                  //| res6: Double = 7.9999999995
	closer(3, 8)                              //> x1:3.0 x2:8.0 dif:5.0
                                                  //| x1:3.0 x2:3.00005 dif:4.999999999988347E-5
                                                  //| x1:3.0 x2:3.0000000005 dif:5.000000413701855E-10
                                                  //| dif:5.000000413701855E-10 < 0.00001
                                                  //| res7: Double = 3.0000000005
  closer(8, -3)                                   //> x1:8.0 x2:-3.0 dif:11.0
                                                  //| x1:8.0 x2:7.999890000000001 dif:1.0999999999938836E-4
                                                  //| x1:8.0 x2:7.9999999989 dif:1.100000091014408E-9
                                                  //| dif:1.100000091014408E-9 < 0.00001
                                                  //| res8: Double = 7.9999999989
  closer(-3, 8)                                   //> x1:-3.0 x2:8.0 dif:11.0
                                                  //| x1:-3.0 x2:-2.9998900000000006 dif:1.0999999999938836E-4
                                                  //| x1:-3.0 x2:-2.9999999989 dif:1.100000091014408E-9
                                                  //| dif:1.100000091014408E-9 < 0.00001
                                                  //| res9: Double = -2.9999999989
}