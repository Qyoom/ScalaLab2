package common_multiple

object GCD {
  def gcdLoop(x: Int, y: Int): Long = {
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
	}                                         //> gcdLoop: (x: Int, y: Int)Long
	
	//--------------------------------------//
	gcdLoop(27, 90)                           //> res0: Long = 9
	gcdLoop(22, 20)                           //> res1: Long = 2
	gcdLoop(27, 81)                           //> res2: Long = 27
	gcdLoop(8, 28)                            //> res3: Long = 4
}