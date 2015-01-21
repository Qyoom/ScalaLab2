package common_multiple

object LCM {
  
  // least common multiple
  def lcm(first: Int, second: Int): Int = {
  		def inner(f: Int, s: Int): Int = {
	  		println("f:" + f + " s:" + s)
	  		if(f == s) {
	  			println("f:" + f + " == s:" + s + " ? " + (f==s))
	  			f
	  		}
	  		else if(f < s) inner(f + first, s)
	  		else inner(f, s + second)
  		}
  		inner(first, second)
  }                                               //> lcm: (first: Int, second: Int)Int
  
  lcm(24, 18)                                     //> f:24 s:18
                                                  //| f:24 s:36
                                                  //| f:48 s:36
                                                  //| f:48 s:54
                                                  //| f:72 s:54
                                                  //| f:72 s:72
                                                  //| f:72 == s:72 ? true
                                                  //| res0: Int = 72
  //lcd(20, 25)
  //lcd(10, 12)
  //lcd(35,56)
  //lcd(8,11)
  //lcd(6,7)
  //lcd(9,12)
  
}