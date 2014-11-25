package misc

class Class1(n: Int) {

	val free = n

	def multByFree(x: Int) = x * free
	
	val huh = List(1, 2, 3).map(multByFree)
	huh.foreach(println)
}

object Objec2 {

	val cl1 = new Class1(4)                   //> 4
                                                  //| 8
                                                  //| 12
                                                  //| cl1  : misc.Class1 = misc.Class1@1d807ca8
	
	List(4, 5, 6).map(cl1.multByFree)         //> res0: List[Int] = List(16, 20, 24)
	cl1.huh                                   //> res1: List[Int] = List(4, 8, 12)
}