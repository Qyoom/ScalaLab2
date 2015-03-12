package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_lab_1 {

	val rx1 = new Regex("""(S|s)cala""")      //> rx1  : scala.util.matching.Regex = (S|s)cala
	
	rx1.findFirstMatchIn("Scala is scalable and cool.")
                                                  //> res0: Option[scala.util.matching.Regex.Match] = Some(Scala)
	
	rx1.findAllIn("Scala is scalable and cool.").mkString(", ")
                                                  //> res1: String = Scala, scala
                                                  
  val rx2 = new Regex("""(cat|dog)""")            //> rx2  : scala.util.matching.Regex = (cat|dog)
  
  rx2 findFirstMatchIn "It's raining cats and dogs."
                                                  //> res2: Option[scala.util.matching.Regex.Match] = Some(cat)
  
  rx2 findAllIn "It's raining cats and dogs." mkString(", ")
                                                  //> res3: String = cat, dog

	val rx3 = new Regex("""gupp(y|ies)""")    //> rx3  : scala.util.matching.Regex = gupp(y|ies)
	
	rx3 findAllIn "One guppy instead of two guppies." mkString(", ")
                                                  //> res4: String = guppy, guppies
	
	val rx4 = new Regex("""(Column [0-9] *)""")
                                                  //> rx4  : scala.util.matching.Regex = (Column [0-9] *)
	
	rx4 findAllIn "Column 1Column 2     Column 3     Column 4" mkString
                                                  //> res5: String = Column 1Column 2     Column 3     Column 4
}
/*




*/