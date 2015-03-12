package courses.courses.davidson.applicationslinearalgebra

object MagicTrick {
	
	def magic(n: Int) = {
		require(n > 0 && n <= 20)
		(n * 2 + 8) / 2 - n
	}                                         //> magic: (n: Int)Int
	
	magic(3)                                  //> res0: Int = 4
	magic(7)                                  //> res1: Int = 4
	magic(9)                                  //> res2: Int = 4
	magic(1)                                  //> res3: Int = 4
	magic(20)                                 //> res4: Int = 4
	
	for(n <- 1 to 20) yield magic(n)          //> res5: scala.collection.immutable.IndexedSeq[Int] = Vector(4, 4, 4, 4, 4, 4, 
                                                  //| 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4)
}