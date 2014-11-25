package schaum.discretemath.counting

// Example 5.12a
object Trees1 {
  println("Schaum Discrete Math p.95")            //> Schaum Discrete Math p.95
  
  val A = List("1", "2")                          //> A  : List[String] = List(1, 2)
  val B = List("a", "b", "c")                     //> B  : List[String] = List(a, b, c)
  val C = List("X", "Y")                          //> C  : List[String] = List(X, Y)
  
  val combos1 = for{
  		a <- A
  		b <- B
  		c <- C
  } yield(a, b, c)                                //> combos1  : List[(String, String, String)] = List((1,a,X), (1,a,Y), (1,b,X), 
                                                  //| (1,b,Y), (1,c,X), (1,c,Y), (2,a,X), (2,a,Y), (2,b,X), (2,b,Y), (2,c,X), (2,c
                                                  //| ,Y))
 	combos1.size                              //> res0: Int = 12
 	
 	val combos2 = for{
  		a <- A
  		b <- B
  		c <- C
  		if ((c != "Y") && !(a == "1"))
  } yield (a, b, c)                               //> combos2  : List[(String, String, String)] = List((2,a,X), (2,b,X), (2,c,X))
  combos2.size                                    //> res1: Int = 3
  
}