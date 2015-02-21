package lab.math.projeuler._4_palind

object Other_peoples_solutions {

	// This is by kleetang. Much better than my initial implmentation.
	def palindromic(n:Int):Boolean = {
    n.toString.reverse == n.toString
  }                                               //> palindromic: (n: Int)Boolean
  
  def largestPalindromic:Seq[Int] = {
    for {
      i <- 100 to 999
      j <- 100 to 999
      if (palindromic(i*j))
    } yield i*j
  }                                               //> largestPalindromic: => Seq[Int]
	
  largestPalindromic.toList.max                   //> res0: Int = 906609
  
  // This is by petermic.
  def isPalindrome(n: Int) = {
    def reverse(n: Int, r: Int = 0): Int = n match {
      case 0 => r
      case _ => reverse(n / 10, r * 10 + n % 10)
    }
    n == reverse(n)
  }                                               //> isPalindrome: (n: Int)Boolean
	(100 to 999).flatMap(n => (n to 999).map(_ * n)).filter(isPalindrome).max
                                                  //> res1: Int = 906609
	
	// This is by
	val palindromes = for{
		i <- 100 to 999;
    j <- 100 to 999;
    val product=i*j;
    if (product.toString()== product.toString().reverse)
	} yield (product)                         //> palindromes  : scala.collection.immutable.IndexedSeq[Int] = Vector(10201, 11
                                                  //| 211, 12221, 13231, 14241, 15251, 16261, 17271, 18281, 19291, 20402, 21412, 2
                                                  //| 2422, 23432, 24442, 25452, 26462, 27472, 28482, 29492, 30603, 31613, 32623, 
                                                  //| 33633, 34643, 35653, 36663, 37673, 38683, 39693, 40804, 41814, 42824, 43834,
                                                  //|  44844, 45854, 46864, 47874, 48884, 49894, 20502, 21012, 41514, 42024, 62526
                                                  //| , 63036, 83538, 84048, 21012, 26162, 42024, 47174, 63036, 68186, 84048, 8919
                                                  //| 8, 21112, 27872, 42224, 48984, 63336, 80808, 84448, 88088, 50505, 53235, 557
                                                  //| 55, 58485, 21412, 23532, 25652, 27772, 29892, 40704, 42824, 44944, 25252, 45
                                                  //| 154, 65056, 73937, 93839, 27972, 29592, 46764, 48384, 63936, 65556, 67176, 8
                                                  //| 2728, 84348, 15151, 64746, 74447, 79897, 84148, 89598, 99299, 11211, 12321, 
                                                  //| 13431, 14541, 15651, 16761, 17871, 18981, 20202, 21312, 22422, 23532, 24642,
                                                  //|  25752, 26862, 27972, 30303, 31413, 32523, 33633, 34743, 35853, 36963, 40404
                                                  //| , 41514, 42624, 43734, 4
                                                  //| Output exceeds cutoff limit.
	println(palindromes.max)                  //> 906609
}