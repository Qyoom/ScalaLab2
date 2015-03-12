package courses.courses.davidson.applicationslinearalgebra

object Magic2 {

	// (n * 2 + 8) / 2 - n
	def magic(n: Int) = {
		require(n > 0 && n <= 20)
		val a = n * 2
		val b = a + 8
		val c = b / 2
		val d = c - n
		println("n:" + n + " a:" + a + " b:" + b + " c:" + c + " d:" + d)
		d
	}                                         //> magic: (n: Int)Int
	
	magic(7)                                  //> n:7 a:14 b:22 c:11 d:4
                                                  //| res0: Int = 4
	//for(n <- 1 to 20) yield magic(n)
	
}