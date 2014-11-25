package misc

object BooleanLab {

    def main(args: Array[String]): Unit = {
        val score:Int = 3
        val chars = List()
        val res = chars match {
	        	case Nil => {
	        	    if(score != 3) false
	        	}
	        	case _ => {
	        	    false
	        	}
        }
        println("res: " + res)
    }

}