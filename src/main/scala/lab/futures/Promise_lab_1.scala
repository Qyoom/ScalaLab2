package lab.futures

import scala.concurrent.{ future, promise }
import scala.concurrent.ExecutionContext.Implicits.global

object Promise_lab_1 extends App{
    
	val f = future { 1 }
	
	val p = promise[Int]
	
	p completeWith f
	
	p.future onSuccess {
	  	case x => println(x)
	}
}