package lab.apply

object Apply_lab_1 {
  
  class Foo(x: Int) {
  		def apply(y: Int): Int = {
  			x*x + y+y
  		}
  		def apply(y: String): String = {
  			x*x + (y + y)
  		}
  }
  
  val f = new Foo(3)                              //> f  : lab.apply.Apply_lab_1.Foo = lab.apply.Apply_lab_1$Foo@7e80fa6f
  
  f(6)                                            //> res0: Int = 21
  f("huh")                                        //> res1: String = 9huhhuh
  
}