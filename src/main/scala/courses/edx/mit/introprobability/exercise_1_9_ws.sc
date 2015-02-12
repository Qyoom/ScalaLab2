package courses.edx.mit.introprobability

object exercise_1_9_ws {
  val aircraftStates = List("present", "NOT present")
                                                  //> aircraftStates  : List[String] = List(present, NOT present)
  val radarStates = List("alarm", "NO alarm")     //> radarStates  : List[String] = List(alarm, NO alarm)
  
  for{
  		a <- aircraftStates
  		r <- radarStates
  } yield (a,r)                                   //> res0: List[(String, String)] = List((present,alarm), (present,NO alarm), (NO
                                                  //| T present,alarm), (NOT present,NO alarm))
}