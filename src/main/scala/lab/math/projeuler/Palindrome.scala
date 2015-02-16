package lab.math.projeuler

object Palindrome {
  
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
}