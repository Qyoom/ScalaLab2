package lab.math

object Sum_lab {

	def sum(xs: List[Int]): Int = {
		if(xs.isEmpty) 0
		else xs.head + sum(xs.tail)
	}                                         //> sum: (xs: List[Int])Int
	
	sum(List(3,5,2))                          //> res0: Int = 10
	sum(List(2))                              //> res1: Int = 2
	sum(List(8, -3))                          //> res2: Int = 5
}