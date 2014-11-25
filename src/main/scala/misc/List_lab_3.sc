package misc

object List_lab_3 {
  val l1 = List(1,2,3)                            //> l1  : List[Int] = List(1, 2, 3)
  l1 match {
  		case x :: xs => println(x)
  }                                               //> 1
  val l2 = Nil                                    //> l2  : scala.collection.immutable.Nil.type = List()
  val l3 = List()                                 //> l3  : List[Nothing] = List()
  l3 :: Nil                                       //> res0: List[List[Nothing]] = List(List())
}