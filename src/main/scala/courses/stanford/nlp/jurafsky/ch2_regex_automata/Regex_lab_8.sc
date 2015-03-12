package courses.stanford.nlp.jurafsky.ch2_regex_automata

/*
 * This class delegates to the java.util.regex package of the Java Platform.
 * See the documentation for java.util.regex.Pattern for details about the
 * regular expression syntax for pattern strings.
 */
import scala.util.matching.Regex

object Regex_lab_8 {

	val rx1 = new Regex("""\b[T|t]he\b""")    //> rx1  : scala.util.matching.Regex = \b[T|t]he\b
	
	val rx2 = new Regex("""\b(T|t)he\b""")    //> rx2  : scala.util.matching.Regex = \b(T|t)he\b
	
	val rx3 = new Regex("""\b[T|t]he\B""")    //> rx3  : scala.util.matching.Regex = \b[T|t]he\B
	
	// Not able to get this to "The therapy"
	val rx4 = new Regex("""\b[T|t]he.* """)   //> rx4  : scala.util.matching.Regex = \b[T|t]he.* 
	
	rx1 findAllIn "The therapy session" mkString(",")
                                                  //> res0: String = The
	
	rx2 findAllIn "The therapy session" mkString(",")
                                                  //> res1: String = The
	
	rx3 findAllIn "The therapy session" mkString(",")
                                                  //> res2: String = the
	
	rx4 findAllIn "The therapy session" mkString(",")
                                                  //> res3: String = "The therapy "
		
	val rx7 = new Regex("""(^|[^a-zA-Z])[tT]he([^a-zA-Z]|$)""")
                                                  //> rx7  : scala.util.matching.Regex = (^|[^a-zA-Z])[tT]he([^a-zA-Z]|$)
	rx7 findAllIn "The the the." mkString(",")//> res4: String = The , the.
	
	rx7 findAllIn "The duck the true the." mkString(",")
                                                  //> res5: String = The , the , the.
	// This doesn't seem to be working as intended... Scala's RegEx patterns must differ from PERLs, which is what the Jarafsky book uses.
	rx7 findAllIn "The therapy session is in their back office." mkString(",")
                                                  //> res6: String = "The "
}
/*




*/