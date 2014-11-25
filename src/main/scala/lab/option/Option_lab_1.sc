object Option_lab_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val greeting: Option[String] = Some("Hello world")
                                                  //> greeting  : Option[String] = Some(Hello world)
  greeting                                        //> res0: Option[String] = Some(Hello world)
  
  val bar = Some(1) match {
  		case Some(1) => "Some(1)"
  		case _ => "Nope"
  }                                               //> res1: String = Some(1)
  
  val foo = Some(1) match {
  		case Some(1) => true
  		case _ => false
  }                                               //> res2: Boolean = true
}