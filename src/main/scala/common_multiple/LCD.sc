package common_multiple

object LCD {
  
  // least common multiple
  def lcd(first: Int, second: Int): Int = {
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
  }                                               //> lcd: (first: Int, second: Int)Int
  
  //lcd(20, 25)
  //lcd(10, 12)
  //lcd(35,56)
  //lcd(8,11)
  //lcd(6,7)
  //lcd(9,12)
  
}