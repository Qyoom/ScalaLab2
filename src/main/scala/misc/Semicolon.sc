package misc

object Semicolon {

	val a = 1; // This semicolon is required! //> a  : Int = 1
	{
  	val a = 2 // Compiles just fine
			println(a)
		}                                 //> 2
	println(a)                                //> 1
}