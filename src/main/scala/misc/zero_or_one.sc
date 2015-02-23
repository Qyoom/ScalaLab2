package misc

object zero_or_one {
	// Experiment:
	// n if x = 1
	// -n if x = 0
	def f(x: Int, n: Int) = {
		 require(x == 1 || x == 0)
		 (x * n) + ((1 - x) * -n)
	}                                         //> f: (x: Int, n: Int)Int
	
	f(1, 10)                                  //> res0: Int = 10
	f(0, 10)                                  //> res1: Int = -10
	f(1, 3)                                   //> res2: Int = 3
	f(0, 3)                                   //> res3: Int = -3
}