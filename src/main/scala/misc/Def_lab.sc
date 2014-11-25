package misc

object Def_lab {
	def x = 1                                 //> x: => Int
	x                                         //> res0: Int = 1
	def double(x:Int) = x*2                   //> double: (x: Int)Int
	double(1)                                 //> res1: Int = 2
	double(2)                                 //> res2: Int = 4
	
	val y = 1                                 //> y  : Int = 1
	val triple = (n:Int) => n*3               //> triple  : Int => Int = <function1>
	triple(1)                                 //> res3: Int = 3
	triple(2)                                 //> res4: Int = 6
}