package lab.controlstrucs

object Zip_lab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val a = List(1,2,3,4)                           //> a  : List[Int] = List(1, 2, 3, 4)
  val b = List(5,6,7,8)                           //> b  : List[Int] = List(5, 6, 7, 8)
  val c = List(9,10,11,12)                        //> c  : List[Int] = List(9, 10, 11, 12)
  
  a zip b                                         //> res0: List[(Int, Int)] = List((1,5), (2,6), (3,7), (4,8))
  a zip b zip c map {
  	case ((a,b),c) => (a,b,c)
  }                                               //> res1: List[(Int, Int, Int)] = List((1,5,9), (2,6,10), (3,7,11), (4,8,12))
  
  List(a,b,c).transpose                           //> res2: List[List[Int]] = List(List(1, 5, 9), List(2, 6, 10), List(3, 7, 11), 
                                                  //| List(4, 8, 12))
}