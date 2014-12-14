package lab.math.aleks.introstats

object Worksheet1 {
  val sorted = List(7,2,37,32,27,22,16,11,6,1,36,31,40,40,40,34,34,29,29,24,24,9).sorted
                                                  //> sorted  : List[Int] = List(1, 2, 6, 7, 9, 11, 16, 22, 24, 24, 27, 29, 29, 31
                                                  //| , 32, 34, 34, 36, 37, 40, 40, 40)
	val dropped = sorted.drop(sorted.indexWhere(x => x > 6))
                                                  //> dropped  : List[Int] = List(7, 9, 11, 16, 22, 24, 24, 27, 29, 29, 31, 32, 34
                                                  //| , 34, 36, 37, 40, 40, 40)
  dropped.splitAt(dropped.indexWhere(x => x > (11)))
                                                  //> res0: (List[Int], List[Int]) = (List(7, 9, 11),List(16, 22, 24, 24, 27, 29, 
                                                  //| 29, 31, 32, 34, 34, 36, 37, 40, 40, 40))
}