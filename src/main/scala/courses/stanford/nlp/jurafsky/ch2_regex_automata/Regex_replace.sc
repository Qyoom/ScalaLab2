package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_replace {
	
	// http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
	
	val r1 = "(S|s)cala".r                    //> r1  : scala.util.matching.Regex = (S|s)cala
  r1 findFirstMatchIn "Scala is scalable and cool"//> res0: Option[scala.util.matching.Regex.Match] = Some(Scala)
  r1 findAllIn "Scala is scalable and cool" mkString(",")
                                                  //> res1: String = Scala,scala
  r1 replaceFirstIn ("Scala is scalable and cool--NOT!", "Python")
                                                  //> res2: String = Python is scalable and cool--NOT!
  val r2 = "s.w".r                                //> r2  : scala.util.matching.Regex = s.w
  r2 findAllIn "see saw sow sew" mkString(",")    //> res3: String = saw,sow,sew
  
  val r3 = "[Rr]uby".r                            //> r3  : scala.util.matching.Regex = [Rr]uby
  r3 findAllIn "Ruby ruby ruby baby" mkString(",")//> res4: String = Ruby,ruby,ruby
  
  val r4 = ".[aeiou].".r                          //> r4  : scala.util.matching.Regex = .[aeiou].
  r4 findAllIn "See saw sew soy sit" mkString(",")//> res5: String = See,saw,sew,soy,sit
  
  val r5 = "\\b.[a-z].\\b".r                      //> r5  : scala.util.matching.Regex = \b.[a-z].\b
  r5 findAllIn "ABCD ABcD bcd FFF" mkString(",")  //> res6: String = bcd
  
  val r6 = new Regex("abl[ae]\\d+")               //> r6  : scala.util.matching.Regex = abl[ae]\d+
  r6 findAllIn "ablaw is able12 and cool" mkString(",")
                                                  //> res7: String = able12
}