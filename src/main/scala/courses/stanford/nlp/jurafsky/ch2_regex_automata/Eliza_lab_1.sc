package courses.stanford.nlp.jurafsky.ch2_regex_automata

import scala.util.matching.Regex

object Eliza_lab_1 {

	val my = """[Mm]y""".r                    //> my  : scala.util.matching.Regex = [Mm]y
	val me = """\b[Mm]e\b""".r                //> me  : scala.util.matching.Regex = \b[Mm]e\b
	
	val s1 = "My boyfriend made me come here."//> s1  : String = My boyfriend made me come here.
	
	//my findAllIn s1 mkString(",")
	//val s1_b = my replaceAllIn (s1, "Your")
	//me replaceAllIn (s1_b, "you")
	
	val rxs = List((my, "Your"), (me, "you")) //> rxs  : List[(scala.util.matching.Regex, String)] = List(([Mm]y,Your), (\b[Mm
                                                  //| ]e\b,you))
	
	def replace(s: String, rx_tups: List[(Regex, String)]): String = {
		rx_tups match {
			case x :: xs => {
				val res = x._1 replaceAllIn(s, x._2)
				replace(res, xs)
			}
			case _ => s
		}
	}                                         //> replace: (s: String, rx_tups: List[(scala.util.matching.Regex, String)])Stri
                                                  //| ng
	
	replace(s1, rxs)                          //> res0: String = Your boyfriend made you come here.
}