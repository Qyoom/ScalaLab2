package lab.lift

// http://stackoverflow.com/questions/17965059/what-is-lifting-in-scala
object lift_lab_1 {
  
  /** PartialFunction **/
  val pf: PartialFunction[Int, Boolean] = { case i if i > 0 => i % 2 == 0 }
                                                  //> pf  : PartialFunction[Int,Boolean] = <function1>
  
  val liftMe = pf.lift                            //> liftMe  : Int => Option[Boolean] = <function1>
  
  liftMe(-1)                                      //> res0: Option[Boolean] = None
  liftMe(1)                                       //> res1: Option[Boolean] = Some(false)
  liftMe(2)                                       //> res2: Option[Boolean] = Some(true)
  liftMe(3)                                       //> res3: Option[Boolean] = Some(false)
  liftMe(4)                                       //> res4: Option[Boolean] = Some(true)
  liftMe(72)                                      //> res5: Option[Boolean] = Some(true)
  
  /** Method **/
  def times2(i: Int) = i * 2                      //> times2: (i: Int)Int
  
 	// Note the fundamental difference between methods and functions. Result is an instance (i.e. it is a value) of the (function) type (Int => Int)
 	val doubleMe = times2 _                   //> doubleMe  : Int => Int = <function1>
 	doubleMe(1)                               //> res6: Int = 2
 	doubleMe(42)                              //> res7: Int = 84
 	doubleMe(-42)                             //> res8: Int = -84
 	
 	// but what's the big deal?
 	times2(42)                                //> res9: Int = 84
}