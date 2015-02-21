package lab.filter

object filter_lab_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val list_1 = List("Mike", "Jake", "Ben", "Jeff", "Moh")
                                                  //> list_1  : List[String] = List(Mike, Jake, Ben, Jeff, Moh)
  val list_2 = List("Jake", "Moh")                //> list_2  : List[String] = List(Jake, Moh)
  
  val filtered = for {
  		n1 <- list_1
  		n2 <- list_2
  		if n1 == n2
  } yield n2                                      //> filtered  : List[String] = List(Jake, Moh)
}