package lab.regex.tutorialspoint

import scala.util.matching.Regex

object RegEx_1 {
	// http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
	
	val r1 = "(S|s)cala".r                    //> r1  : scala.util.matching.Regex = (S|s)cala
  r1 findFirstMatchIn "Scala is scalable and cool"//> res0: Option[scala.util.matching.Regex.Match] = Some(Scala)
  r1 findAllIn "Scala is scalable and cool" mkString(",")
                                                  //> res1: String = Scala,scala
  r1 replaceFirstIn ("Scala is scalable and cool--NOT!", "Python")
                                                  //> res2: String = Python is scalable and cool--NOT!
  
	
}