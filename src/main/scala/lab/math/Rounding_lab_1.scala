package lab.math

object Rounding_lab_1 {
	
	/* http://stackoverflow.com/questions/11106886/scala-doubles-and-precision
	 * double n and precision p, using currying 
	 */
	def roundAt(prec: Int)(n: Double): Double = {
	  	val scale = math pow(10, prec)
	  	//println("scale: " + scale)
	  	(math round n * scale) / scale
	}

}