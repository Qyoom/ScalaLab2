package lab.functions

object function_objects_lab {
	
	def isEven(x: Int): Boolean = x % 2 == 0  //> isEven: (x: Int)Boolean
	
	(x: Int) => isEven(x)                     //> res0: Int => Boolean = <function1>
	
	def f(x: Int) = isEven(x)                 //> f: (x: Int)Boolean
	
	f(43)                                     //> res1: Boolean = false
	
	def sqr(x: Int): Int = {
		x*x
	}                                         //> sqr: (x: Int)Int
	
	sqr(-3)                                   //> res2: Int = 9
	
}