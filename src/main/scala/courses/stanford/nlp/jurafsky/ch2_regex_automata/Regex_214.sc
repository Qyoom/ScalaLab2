package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Regex_214 {
	// Looking for “any PC with more than 500 MHz and 32 Gb of disk space for less than $1000”
	
	// Unlike Jurafsky (Perl) Java requires "$" (dollar sign) be escaped when used as a character.
	// Java is unhappy with \b word boundary so far as I can tell...
	val rx1 = new Regex("""\$[0-9]+(\.[0-9][0-9])?""")
                                                  //> rx1  : scala.util.matching.Regex = \$[0-9]+(\.[0-9][0-9])?
	val rx2 = new Regex("""(MHz|[Mm]egahertz|GHz|[Gg]igahertz)""")
                                                  //> rx2  : scala.util.matching.Regex = (MHz|[Mm]egahertz|GHz|[Gg]igahertz)
	
	val rx3 = new Regex("""(\$[0-9]+(\.[0-9][0-9])?+ *)?(MHz|[Mm]egahertz|GHz|[Gg]igahertz)?""")
                                                  //> rx3  : scala.util.matching.Regex = (\$[0-9]+(\.[0-9][0-9])?+ *)?(MHz|[Mm]ega
                                                  //| hertz|GHz|[Gg]igahertz)?
	val rx4 = new Regex("""[0-9]+ *(Mb|[Mm]egabytes?)""")
                                                  //> rx4  : scala.util.matching.Regex = [0-9]+ *(Mb|[Mm]egabytes?)
	
	val rx5 = new Regex("""[0-9]+(\.[0-9]+)? *(Gb|[Gg]igabytes?)""")
                                                  //> rx5  : scala.util.matching.Regex = [0-9]+(\.[0-9]+)? *(Gb|[Gg]igabytes?)

	// ------ tests ----------------------------------------- //
	
	rx1 findAllIn "$499.99" mkString(",")     //> res0: String = $499.99
	rx1 findAllIn "$45599.99" mkString(",")   //> res1: String = $45599.99
	rx1 findAllIn "$45599.999" mkString(",")  //> res2: String = $45599.99
	
	rx1 findAllIn "$499." mkString(",")       //> res3: String = $499
	rx1 findAllIn "499." mkString(",")        //> res4: String = ""
	
	rx2 findAllIn "Megahertz megahertz Gigahertz gigahertz" mkString(",")
                                                  //> res5: String = Megahertz,megahertz,Gigahertz,gigahertz
	rx3 findAllIn "Megahertz megahertz Gigahertz gigahertz" mkString(",")
                                                  //> res6: String = Megahertz,,megahertz,,Gigahertz,,gigahertz,
	rx3 findAllIn "$499.99 Megahertz megahertz Gigahertz gigahertz" mkString(",")
                                                  //> res7: String = $499.99 Megahertz,,megahertz,,Gigahertz,,gigahertz,
	
	rx3 findAllIn "$499.99" mkString(",")     //> res8: String = $499.99,
	rx4 findAllIn "80  Mb" mkString(",")      //> res9: String = 80  Mb
	rx4 findAllIn "80  Mb" mkString(",")      //> res10: String = 80  Mb
	rx4 findAllIn "400 megabytes" mkString(",")
                                                  //> res11: String = 400 megabytes
  // I can't get this to work
  rx5 findAllIn "10.546 gigabytes" mkString(",")  //> res12: String = 10.546 gigabytes
  
}
/*



*/