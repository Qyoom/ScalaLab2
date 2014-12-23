package lab.math.coursera.ohio.calculus.seriesandsequences

object Week1_quiz1 {
  
	def b(n: Int): Double = {
  		require(n >= 0)
  		n match {
  			case 0 => 5.0
  			case 1 => -2.0
  			case _ => {
  				((-b(n - 1)) * (b(n - 2))) - b(n - 2)
  			}
  		}
	} // end def b
	
	def a(m: Int): Double = {
		m match {
		  case 0 => 5.0
		  case 1 => -4.0
		  case _ => {
			  (a(m-1)*a(m-2)) + a(m-1) + (2*(a(m-2)))
		  }
		}
	} // end def a
}