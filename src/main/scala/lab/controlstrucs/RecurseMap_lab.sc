package lab.controlstrucs

object RecurseMap_lab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val row2 = List(1,2,3,4)                        //> row2  : List[Int] = List(1, 2, 3, 4)
  val row3 = List(5,6,7,8)                        //> row3  : List[Int] = List(5, 6, 7, 8)
  val row4 = List(9,10,11,12)                     //> row4  : List[Int] = List(9, 10, 11, 12)
  
  val matrix1 = List(row2, row3, row4)            //> matrix1  : List[List[Int]] = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9
                                                  //| , 10, 11, 12))
  
  val theta = List(2,3,4,5)                       //> theta  : List[Int] = List(2, 3, 4, 5)
  
  def iter(m: List[List[Int]]) {
	  	println("iter TOP")
	  	if(!m.isEmpty) {
	  		m.head.map(x => println("mapping x:" + x))
	  		iter(m.tail)
	  	}
  }                                               //> iter: (m: List[List[Int]])Unit
  
  iter(matrix1)                                   //> iter TOP
                                                  //| mapping x:1
                                                  //| mapping x:2
                                                  //| mapping x:3
                                                  //| mapping x:4
                                                  //| iter TOP
                                                  //| mapping x:5
                                                  //| mapping x:6
                                                  //| mapping x:7
                                                  //| mapping x:8
                                                  //| iter TOP
                                                  //| mapping x:9
                                                  //| mapping x:10
                                                  //| mapping x:11
                                                  //| mapping x:12
                                                  //| iter TOP
}