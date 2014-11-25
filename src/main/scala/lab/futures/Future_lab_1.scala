package lab.futures

import scala.concurrent._
import ExecutionContext.Implicits.global

// http://docs.scala-lang.org/overviews/core/futures.html

object Future_lab_1 extends App{

    	val f = future {
    		2 / 0
    	}
    	for (exc <- f.failed) println("f failed: " + exc)
    	
    	@volatile var res = 0
    	def getRes = res
    	
    	val f2 = future {
    		4 / 2
    	} map { exc => 
    	    res = exc
    	    println("map<1> f2 success, exc: " + exc)
    	    println("map<1> f2 success, res: " + res)
    	    println("map<1> f2 success, getRes: " + getRes)
    	}
    	
    	println("Why does this print first? res: " + res)
    	f2 map {exc => println("map<2> f2 success: " + exc)}
    	for (exc <- f2.failed) yield println("f2 failed: " + exc)
    	for (exc <- f2) yield println("f2 success: " + exc)
    	
}