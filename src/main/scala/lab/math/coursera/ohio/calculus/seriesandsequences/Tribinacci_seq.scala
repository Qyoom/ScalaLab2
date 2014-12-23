package lab.math.coursera.ohio.calculus.seriesandsequences

object Tribinacci_seq {
	
	// So called Tribinacci sequence
	def a(n: Int): Double = {
		n match {
			case 0 => 1
			case 1 => 1
			case 2 => 1
			case _ => {
				a(n-1) + a(n-2) + a(n-3)
			}
		}
	}
	
	def b(n: Int): Double = {
		a(n+1) / a(n)
	}
}