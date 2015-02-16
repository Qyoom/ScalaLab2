package misc

object Regression_lab_1 {

	val x = 8.0                               //> x  : Double = 8.0
	val y = 5.0                               //> y  : Double = 5.0
	val alpha = 1                             //> alpha  : Int = 1
	
	def shave(x: Double, y: Double, alpha: Double)(iter: Int): Double = {
		println("x:" + x + " y:" + y + " alpha:" + alpha + " iter:" + iter)
		
		def inter(x0: Double)(iter0: Int): Double = {
			val x1 = x0 - (1d/2) * (x0 - y)
			println("x1: " + x1)
			
			if(iter0 <= 0) x1
			else inter(x1)(iter0 - 1)
		}
		
		inter(x)(iter)
	}                                         //> shave: (x: Double, y: Double, alpha: Double)(iter: Int)Double
	
	// ----- Tests ------------------ //
	
	val ex1 = shave(x,y,alpha)_               //> ex1  : Int => Double = <function1>
	ex1(30)                                   //> x:8.0 y:5.0 alpha:1.0 iter:30
                                                  //| x1: 6.5
                                                  //| x1: 5.75
                                                  //| x1: 5.375
                                                  //| x1: 5.1875
                                                  //| x1: 5.09375
                                                  //| x1: 5.046875
                                                  //| x1: 5.0234375
                                                  //| x1: 5.01171875
                                                  //| x1: 5.005859375
                                                  //| x1: 5.0029296875
                                                  //| x1: 5.00146484375
                                                  //| x1: 5.000732421875
                                                  //| x1: 5.0003662109375
                                                  //| x1: 5.00018310546875
                                                  //| x1: 5.000091552734375
                                                  //| x1: 5.0000457763671875
                                                  //| x1: 5.000022888183594
                                                  //| x1: 5.000011444091797
                                                  //| x1: 5.000005722045898
                                                  //| x1: 5.000002861022949
                                                  //| x1: 5.000001430511475
                                                  //| x1: 5.000000715255737
                                                  //| x1: 5.000000357627869
                                                  //| x1: 5.000000178813934
                                                  //| x1: 5.000000089406967
                                                  //| x1: 5.000000044703484
                                                  //| x1: 5.000000022351742
                                                  //| x1: 5.000000011175871
                                                  //| x1: 5.0000000055879354
                                                  //| x1: 5.000000002793968
                                                  //| x1: 5.000000001396984
                                                  //| res0: Double = 5.000000001396984
}
/*


*/