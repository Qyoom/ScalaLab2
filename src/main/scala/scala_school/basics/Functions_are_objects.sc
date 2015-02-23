package scala_school.basics

object Functions_are_objects {

	// A function is an object
	object addOne extends Function[Int, Int] {
		def apply(m: Int) = m + 1
	}
	
	addOne(3)                                 //> res0: Int = 4
	
	object addOther extends Function2[Int, Int, Int] {
		def apply(m: Int, n: Int) = m + n
	}
	
	addOther(3,2)                             //> res1: Int = 5
	addOther(55,63)                           //> res2: Int = 118
	
	object specialFunc3 extends Function3[Double, Double, Double, Double] {
		def apply(m: Double, n: Double, o: Double) = m / n + o
	}
	
	val special_f = specialFunc3(5.0, 7.3, 8.0)
                                                  //> special_f  : Double = 8.684931506849315
	
	// --------------------------------- //
	
	// classes can also extend Function
	class AddOne extends Function[Int, Int] {
		def apply(m: Int) = m + 1
	}
	
	val plusOne = new AddOne                  //> plusOne  : scala_school.basics.Functions_are_objects.AddOne = <function1>
	plusOne(3)                                //> res3: Int = 4
	//AddOne(3)
	//new AddOne(3)
	
	case class AddOne_companion extends Function[Int, Int] {
		def apply(m: Int) = m + 1
	}
	
	// Note that the parentheses are required here
	val plusOne_comp = AddOne_companion()     //> plusOne_comp  : scala_school.basics.Functions_are_objects.AddOne_companion =
                                                  //|  <function1>
	plusOne_comp(3)                           //> res4: Int = 4
	
	//val plusOne_comp = new AddOne_companion
	//plusOne_comp(3)
	
	// --------------------------------- //
}
/*




*/