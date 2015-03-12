package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_lab_4 {

	val numRegEx_single = new Regex("""([0-9])""")
                                                  //> numRegEx_single  : scala.util.matching.Regex = ([0-9])
	val numRegEx_any = new Regex("""([0-9][0-9]*)""")
                                                  //> numRegEx_any  : scala.util.matching.Regex = ([0-9][0-9]*)
  // compare findFirstIn "x72810"
	val numRegEx_huh = new Regex("""([0-9]*)""")
                                                  //> numRegEx_huh  : scala.util.matching.Regex = ([0-9]*)
  // Kleene
	val numRegEx_kleene = new Regex("""([0-9]+)""")
                                                  //> numRegEx_kleene  : scala.util.matching.Regex = ([0-9]+)
	
	val _1 = "1"                              //> _1  : String = 1
	val _3 = "3"                              //> _3  : String = 3
	val _43 = "43"                            //> _43  : String = 43
	
	numRegEx_single findFirstIn _1            //> res0: Option[String] = Some(1)
	numRegEx_single findFirstIn _3            //> res1: Option[String] = Some(3)
	numRegEx_single findFirstIn _43           //> res2: Option[String] = Some(4)
	
	numRegEx_any findFirstIn "123"            //> res3: Option[String] = Some(123)
	numRegEx_any findFirstIn "72810"          //> res4: Option[String] = Some(72810)
	numRegEx_any findFirstIn "x72810"         //> res5: Option[String] = Some(72810)
	numRegEx_any findFirstIn "728x10"         //> res6: Option[String] = Some(728)
	
	numRegEx_huh findFirstIn "123123"         //> res7: Option[String] = Some(123123)
	numRegEx_huh findFirstIn _1               //> res8: Option[String] = Some(1)
	// compare numRegEx_any findFirstIn "x72810"
	numRegEx_huh findFirstIn "x72810"         //> res9: Option[String] = Some()
	numRegEx_kleene findFirstIn "x72810"      //> res10: Option[String] = Some(72810)
	numRegEx_huh findFirstIn "728x10"         //> res11: Option[String] = Some(728)
}