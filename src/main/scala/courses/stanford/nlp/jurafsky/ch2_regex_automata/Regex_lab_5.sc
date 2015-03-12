package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_lab_5 {
	
	val regEx_wild = new Regex("""Beg.n""")   //> regEx_wild  : scala.util.matching.Regex = Beg.n
	
	regEx_wild findFirstIn "Begin"            //> res0: Option[String] = Some(Begin)
	regEx_wild findFirstIn "Began"            //> res1: Option[String] = Some(Began)
	regEx_wild findFirstIn "Begone"           //> res2: Option[String] = Some(Begon)
	regEx_wild findFirstIn "Begoin"           //> res3: Option[String] = None
	regEx_wild findFirstIn "Begn"             //> res4: Option[String] = None
	regEx_wild findFirstIn "Beg n"            //> res5: Option[String] = Some(Beg n)
	regEx_wild findFirstIn "Beg"              //> res6: Option[String] = None
	
	val regEx_wild_kleene = new Regex("""aardvark.*aardvark""")
                                                  //> regEx_wild_kleene  : scala.util.matching.Regex = aardvark.*aardvark
	
	regEx_wild_kleene findFirstIn "An aardvark is an aardvark's best friend"
                                                  //> res7: Option[String] = Some(aardvark is an aardvark)
	
	val regEx_wild_kleene_2 = new Regex(""".*aardvark.*aardvark.*""")
                                                  //> regEx_wild_kleene_2  : scala.util.matching.Regex = .*aardvark.*aardvark.*
	regEx_wild_kleene_2 findFirstIn "An aardvark is an aardvark's best friend"
                                                  //> res8: Option[String] = Some(An aardvark is an aardvark's best friend)
	
	regEx_wild_kleene_2 findFirstIn "An aardvark is my best friend"
                                                  //> res9: Option[String] = None
	
	
}