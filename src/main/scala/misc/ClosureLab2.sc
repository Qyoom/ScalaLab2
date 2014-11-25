package misc

class Class3 {

	var free = 1

	def addFree(x: Int) = {
		val result = x + free
		println("addFree called with " + x + " adding free:" + free)
		free = free + 1
		result
	}
	
	val list1 = List(1, 1, 1).map(addFree)
	override def toString = "list1: " + list1
}

object Object4 {
	val cl31 = new Class3                     //> addFree called with 1 adding free:1
                                                  //| addFree called with 1 adding free:2
                                                  //| addFree called with 1 adding free:3
                                                  //| cl31  : misc.Class3 = list1: List(2, 3, 4)
  val origList = List(1, 1, 1)                    //> origList  : List[Int] = List(1, 1, 1)
	val list2 = origList.map(cl31.addFree)    //> addFree called with 1 adding free:4
                                                  //| addFree called with 1 adding free:5
                                                  //| addFree called with 1 adding free:6
                                                  //| list2  : List[Int] = List(5, 6, 7)
	val cl32 = new Class3                     //> addFree called with 1 adding free:1
                                                  //| addFree called with 1 adding free:2
                                                  //| addFree called with 1 adding free:3
                                                  //| cl32  : misc.Class3 = list1: List(2, 3, 4)
  val list3 = origList.map(cl32.addFree)          //> addFree called with 1 adding free:4
                                                  //| addFree called with 1 adding free:5
                                                  //| addFree called with 1 adding free:6
                                                  //| list3  : List[Int] = List(5, 6, 7)
	
}