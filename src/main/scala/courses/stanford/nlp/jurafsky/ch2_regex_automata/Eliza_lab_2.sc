package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Eliza_lab_2 {

	val rx1 = new Regex("""(I'm.*)(depressed|sad)""")
                                                  //> rx1  : scala.util.matching.Regex = (I'm.*)(depressed|sad)
	
	val s1 = "My boyfriend says that I'm always depressed."
                                                  //> s1  : String = My boyfriend says that I'm always depressed.
	val s2 = "My boyfriend says that I'm sad all the time."
                                                  //> s2  : String = My boyfriend says that I'm sad all the time.
	
	val response1 = "I'm sorry to hear you are "
                                                  //> response1  : String = "I'm sorry to hear you are "
  val hit1 = rx1 findAllIn s1                     //> hit1  : scala.util.matching.Regex.MatchIterator = non-empty iterator
  val feeling1 = hit1 group 2                     //> feeling1  : String = depressed
  
  rx1 findFirstIn s1                              //> res0: Option[String] = Some(I'm always depressed)
  val hit2 = rx1 findAllIn s2                     //> hit2  : scala.util.matching.Regex.MatchIterator = non-empty iterator
  rx1 findAllIn s2 mkString(",")                  //> res1: String = I'm sad
  
  hit1 group 2                                    //> res2: String = depressed
  hit2 group 2                                    //> res3: String = sad
  
  response1 + (hit1 group 2)                      //> res4: String = I'm sorry to hear you are depressed
  response1 + (hit2 group 2)                      //> res5: String = I'm sorry to hear you are sad
}