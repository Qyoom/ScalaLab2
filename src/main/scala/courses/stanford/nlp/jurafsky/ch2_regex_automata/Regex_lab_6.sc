package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_lab_6 {

	val regEx_start_end = new Regex("""^The fox jumped\.$""")
                                                  //> regEx_start_end  : scala.util.matching.Regex = ^The fox jumped\.$
	val regEx_start_end_wild = new Regex("""^The.*fox.*jumped.*dog\.$""")
                                                  //> regEx_start_end_wild  : scala.util.matching.Regex = ^The.*fox.*jumped.*dog\.
                                                  //| $
	
	val regEx_boundary = new Regex("""\bthe\b""")
                                                  //> regEx_boundary  : scala.util.matching.Regex = \bthe\b
	val regEx_non_boundary = new Regex("""\Bthe\B""")
                                                  //> regEx_non_boundary  : scala.util.matching.Regex = \Bthe\B
	
	val regEx_the = new Regex("""the""")      //> regEx_the  : scala.util.matching.Regex = the
	
	// ------ tests ---------------------------------------- //
	regEx_start_end findFirstIn "The fox jumped."
                                                  //> res0: Option[String] = Some(The fox jumped.)
	regEx_start_end findFirstIn "The quick fox jumped."
                                                  //> res1: Option[String] = None
	regEx_start_end findFirstIn "The fox."    //> res2: Option[String] = None
	regEx_start_end findFirstIn "The fox jumped up."
                                                  //> res3: Option[String] = None
	
	regEx_start_end_wild findFirstIn "The quick fox jumped over the lazy dog."
                                                  //> res4: Option[String] = Some(The quick fox jumped over the lazy dog.)
	regEx_start_end_wild findFirstIn "The fox hates that dog."
                                                  //> res5: Option[String] = None
	regEx_start_end_wild findFirstIn "The fox jumped over the dog."
                                                  //> res6: Option[String] = Some(The fox jumped over the dog.)
	
	regEx_boundary findFirstIn "Other than the fact that..."
                                                  //> res7: Option[String] = Some(the)
	regEx_boundary findFirstIn "Other than that..."
                                                  //> res8: Option[String] = None
	
	regEx_non_boundary findFirstIn "Other than that..."
                                                  //> res9: Option[String] = Some(the)
	
	regEx_the findFirstIn "Other than that..."//> res10: Option[String] = Some(the)
	
	
}