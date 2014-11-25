package lab.controlstrucs

object ForComprehension_lab_1 {
  
  val huh = for{
  		i <- (1 to 20)
  		val hi = "Hi"
  } yield hi                                      //> huh  : scala.collection.immutable.IndexedSeq[String] = Vector(Hi, Hi, Hi, Hi
                                                  //| , Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi, Hi)
  
  def foo(i: Int) = i * 2                         //> foo: (i: Int)Int
  
  val huh2 = for{
  		i <- (1 to 20)
  		val hi = foo(i)
  } yield hi                                      //> huh2  : scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 
                                                  //| 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40)
  //
  //
  def bar(arg: Int): List[Int] = {
	  	val huh3 = for{
		  	i <- (1 to arg)
		  	//arg = arg + i
	  } yield i
		huh3.toList
	}                                         //> bar: (arg: Int)List[Int]
	  
}