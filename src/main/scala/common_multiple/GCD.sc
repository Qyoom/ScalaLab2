package common_multiple

object GCD {
  def gcd(x: Int, y: Int): Long = {
	  var a = x
	  var b = y
	  //println("xa:" + a + " yb:" + b)
	  while (a != 0) {
			val temp = a
			//println("temp=a:" + temp)
			a = b % a
			//println("a=b%a:" + a)
			b = temp
			//println("b=temp:" + b)
		}
		b
	}                                         //> gcd: (x: Int, y: Int)Long
	
	//--------------------------------------//
	gcd(27, 90)                               //> res0: Long = 9
	gcd(22, 20)                               //> res1: Long = 2
	gcd(27, 81)                               //> res2: Long = 27
	gcd(8, 28)                                //> res3: Long = 4
	gcd(10, 25)                               //> res4: Long = 5
	gcd(24, 18)                               //> res5: Long = 6
	gcd(20, 24)                               //> res6: Long = 4
	
}