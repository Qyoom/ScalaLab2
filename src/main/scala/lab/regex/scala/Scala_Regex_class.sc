package lab.regex.scala

import scala.util.matching.Regex

// http://www.scala-lang.org/api/current/index.html#scala.util.matching.Regex
object Scala_Regex_class {

	val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
                                                  //> date  : scala.util.matching.Regex = (\d\d\d\d)-(\d\d)-(\d\d)
	// To extract the capturing groups when a Regex is matched, use it as an extractor in a pattern match:
	"2004-01-20" match {
	  case date(year, month, day) => s"$year was a good year for PLs."
	}                                         //> res0: String = 2004 was a good year for PLs.
	
	// To check only whether the Regex matches, ignoring any groups, use a sequence wildcard:
	"2004-01-20" match {
	  case date(_*) => "It's a date!"
	}                                         //> res1: String = It's a date!
	
	// That works because a Regex extractor produces a sequence of strings. Extracting only the year from a date could also be expressed with a sequence wildcard:
	"2004-01-20" match {
	  case date(year, _*) => s"$year was a good year for PLs."
	}                                         //> res2: String = 2004 was a good year for PLs.
	
	// In a pattern match, Regex normally matches the entire input. However, an unanchored Regex finds the pattern anywhere in the input.
	val embeddedDate = date.unanchored        //> embeddedDate  : scala.util.matching.UnanchoredRegex = (\d\d\d\d)-(\d\d)-(\d\
                                                  //| d)
	"Date: 2004-01-20 17:25:18 GMT (10 years, 28 weeks, 5 days, 17 hours and 51 minutes ago)" match {
	  case embeddedDate("2004", "01", "20") => "A Scala is born."
	}                                         //> res3: String = A Scala is born.
	
	/* Wrong form, Match error, not unanchored
	"Date: 2004-01-20 17:25:18 GMT (10 years, 28 weeks, 5 days, 17 hours and 51 minutes ago)" match {
		case date(year, month, day) => "A Scala is born."
	}
	*/
	
	// To find or replace matches of the pattern, use the various find and replace methods. There is a flavor of each method that produces matched strings and another that produces Match objects.
	// For example, pattern matching with an unanchored Regex, as in the previous example, is the same as using findFirstMatchIn, except that the findFirst methods return an Option, or None for no match:
	val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
                                                  //> dates  : String = Important dates in history: 2004-01-20, 1958-09-05, 2010-
                                                  //| 10-06, 2011-07-15
	val firstDate_1 = date findFirstIn dates getOrElse "No date found."
                                                  //> firstDate_1  : String = 2004-01-20
	
	val firstDate_2 = date findFirstMatchIn dates getOrElse "No date found."
                                                  //> firstDate_2  : Object = 2004-01-20
	//val firstYear_1 = for (m <- date findFirstIn dates) yield m group 1  // Error: value group is not a member of String
	
	val firstYear_2 = for (m <- date findFirstMatchIn dates) yield m group 1
                                                  //> firstYear_2  : Option[String] = Some(2004)
  //To find all matches:
	val allYears = for (m <- date findAllMatchIn dates) yield m group 1
                                                  //> allYears  : Iterator[String] = non-empty iterator
  allYears.foreach(println)                       //> 2004
                                                  //| 1958
                                                  //| 2010
                                                  //| 2011
  // But findAllIn returns a special iterator of strings that can be queried for the MatchData of the last match:
	val mi = date findAllIn dates             //> mi  : scala.util.matching.Regex.MatchIterator = non-empty iterator
	val oldies = mi filter (_ => (mi group 1).toInt < 1960) map (s => s"$s: An oldie but goodie.")
                                                  //> oldies  : Iterator[String] = non-empty iterator
  oldies.foreach(println)                         //> 1958-09-05: An oldie but goodie.
  
  // Note that findAllIn finds matches that don't overlap. (See findAllIn for more examples.)
	val num = """(\d+)""".r                   //> num  : scala.util.matching.Regex = (\d+)
	val all = (num findAllIn "123").toList  // List("123"), not List("123", "23", "3")
                                                  //> all  : List[String] = List(123)
  // def findAllIn(source: CharSequence): MatchIterator
	// Return all non-overlapping matches of this Regex in the given character sequence as a scala.util.matching.Regex.MatchIterator,
	// which is a special scala.collection.Iterator that returns the matched strings but can also be queried for more data about the
	// last match, such as capturing groups and start position.
	// A MatchIterator can also be converted into an iterator that returns objects of type scala.util.matching.Regex.Match, such as is
	// normally returned by findAllMatchIn.
	// Where potential matches overlap, the first possible match is returned, followed by the next match that follows the input consumed by the first match:
	val hat  = "hat[^a]+".r                   //> hat  : scala.util.matching.Regex = hat[^a]+
	val hathaway = "hathatthattthatttt"       //> hathaway  : String = hathatthattthatttt
	val hats = (hat findAllIn hathaway).toList                     // List(hath, hattth)
                                                  //> hats  : List[String] = List(hath, hattth)
	val pos = (hat findAllMatchIn hathaway map (_.start)).toList  // List(0, 7)
                                                  //> pos  : List[Int] = List(0, 7)
  
	
	// stub to alow for trailing comments
	0                                         //> res4: Int(0) = 0
}
/*



*/