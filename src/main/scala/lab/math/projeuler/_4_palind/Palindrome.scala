package lab.math.projeuler._4_palind

object Palindrome {
  
	// TODO: This per-character parsing is unnecessary. Use reverse (below) instead.
	/*
	def isPal(n: Int): Boolean = {
  		def inter(nStr: String): Boolean = {
  			val len = nStr.length
	  		if(len > 1) {
	  			val left = nStr(0)
	  			val right = nStr(len - 1)
	  			if(left != right) false
	  			else {
	  				val newStr = nStr.substring(1, nStr.length - 1)
	  				inter(newStr)
	  			}
	  		}
	  		else true
  		}
  		inter(n.toString)
	}
	*/
	
	def isPal(n: Int): Boolean = {
	  val nStr = n.toString()
	  nStr == nStr.reverse
	}
}