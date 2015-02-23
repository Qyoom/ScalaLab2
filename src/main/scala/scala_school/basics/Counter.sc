package scala_school.basics

	object Counter {
	  var count = 0                           //> count  : Int = 0
	
	  def currentCount: Long = {
	    count += 1
	    count
	  }                                       //> currentCount: => Long
	  
	  currentCount                            //> res0: Long = 1
	  currentCount                            //> res1: Long = 2
	  currentCount                            //> res2: Long = 3
	}