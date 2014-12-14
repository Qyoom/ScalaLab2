package lab.scalaindepth.ch11

object CategoryTheory_lab_1 {
	
	def lift3[A,B,C,D](f: Function3[A,B,C,D]) = {
		(oa: Option[A], ob: Option[B], oc: Option[C]) => 
		  	for(a <- oa; b <- ob; c <- oc) yield f(a,b,c)
	}
	/* What ScalaIDE sees/understands from this def:
	 * def lift3[A, B, C, D](f: (A, B, C) => D): (Option[A], Option[B], Option[C]) => Option[D]
	 * 
	 * Scala’s for expressions are syntactic sugar for the map, flatMap, foreach, and 
	 * withFilter operations defined on a class.
	 */

}