package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_lab_3 {

	// Jurafsky-Martin-Speech-and-Language-Processing-2ed-Draft.pdf
	
	val regEx1 = new Regex("""([ab]*)""")     //> regEx1  : scala.util.matching.Regex = ([ab]*)
	
	val str1 = "a"                            //> str1  : String = a
	val str2 = "b"                            //> str2  : String = b
	val str3 = "ab"                           //> str3  : String = ab
	val str4 = "aa.aa"                        //> str4  : String = aa.aa
	val str5 = "ababab"                       //> str5  : String = ababab
	val str6 = "abababa"                      //> str6  : String = abababa
	val str7 = "bab"                          //> str7  : String = bab
	val str8 = "babx"                         //> str8  : String = babx
	val str9 = "xbabx"                        //> str9  : String = xbabx
	val str10 = "bxabx"                       //> str10  : String = bxabx
	
	regEx1 findFirstMatchIn str1              //> res0: Option[scala.util.matching.Regex.Match] = Some(a)
	regEx1 findFirstMatchIn str2              //> res1: Option[scala.util.matching.Regex.Match] = Some(b)
	regEx1 findFirstMatchIn str3              //> res2: Option[scala.util.matching.Regex.Match] = Some(ab)
	regEx1 findFirstMatchIn str4              //> res3: Option[scala.util.matching.Regex.Match] = Some(aa)
	regEx1 findFirstMatchIn str5              //> res4: Option[scala.util.matching.Regex.Match] = Some(ababab)
	regEx1 findFirstMatchIn str6              //> res5: Option[scala.util.matching.Regex.Match] = Some(abababa)
	regEx1 findFirstMatchIn str7              //> res6: Option[scala.util.matching.Regex.Match] = Some(bab)
	regEx1 findFirstMatchIn str8              //> res7: Option[scala.util.matching.Regex.Match] = Some(bab)
	regEx1 findFirstMatchIn str9              //> res8: Option[scala.util.matching.Regex.Match] = Some()
	regEx1 findFirstMatchIn str10             //> res9: Option[scala.util.matching.Regex.Match] = Some(b)
		
	val res = for (
		_match <- regEx1 findFirstMatchIn str1
	) yield _match                            //> res  : Option[scala.util.matching.Regex.Match] = Some(a)
	
	res                                       //> res10: Option[scala.util.matching.Regex.Match] = Some(a)
	
	// ---------------------------------------------------------------- //
	// http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
	
	val pattern1 = "Scala".r                  //> pattern1  : scala.util.matching.Regex = Scala
  val str05 = "Scala is Scalable and cool"        //> str05  : String = Scala is Scalable and cool
  println(pattern1 findFirstIn str05)             //> Some(Scala)
  
  val pattern2 = new Regex("(S|s)cala")           //> pattern2  : scala.util.matching.Regex = (S|s)cala
  val str06 = "Scala is scalable and cool"        //> str06  : String = Scala is scalable and cool
  println((pattern2 findAllIn str06).mkString(","))
                                                  //> Scala,scala
}