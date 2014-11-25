package lab.math

object SumLab2 extends App {
    def sum(xs: List[Int]): Int = {
		if(xs.isEmpty) 0
		else xs.head + sum(xs.tail) // head recursion
	}                                         
	
	println(sum(List(3,5,2)))                       
	println(sum(List(2)))                             
	sum(List(8, -3))                          

}