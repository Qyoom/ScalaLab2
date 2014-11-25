package lab.monad

object monad_lab_1 {
  
  // http://debasishg.blogspot.com/2008/03/monads-another-way-to-abstract.html
  // FINISH READING THIS article
  
  // 'for' comprehension is syntactic sugar for 'map'
  for {
  		x <- List(1, 2)
  } yield(x + 2)                                  //> res0: List[Int] = List(3, 4)
  
  List(1, 2) map (x => x + 2)                     //> res1: List[Int] = List(3, 4)
  
  val list1 = List(1, 2)                          //> list1  : List[Int] = List(1, 2)
  val list2  = List(8, 9)                         //> list2  : List[Int] = List(8, 9)
  val last = List("ab", "cde", "fghi")            //> last  : List[String] = List(ab, cde, fghi)
  
  //"The key abstraction is the flatMap, which binds the computation through chaining"
  
	//(A) NOTE: The order of A's and B's cannot be reversed!!
  list1 flatMap {
	  valueFromList1 => list2 map {
	    valueFromList2 => valueFromList1 * valueFromList2
	  }                                       //> res2: List[Int] = List(8, 9, 16, 18)
	}
	
	//(A)
	list1 flatMap {
	  i => list2 flatMap {
	    j => last map {
	      k => i * j * k.length
	    }
	  }                                       //> res3: List[Int] = List(16, 24, 32, 18, 27, 36, 32, 48, 64, 36, 54, 72)
	}
 	
 	//(B) NOTE: The order of these two expression types (A and B) cannot be reversed!!
 	// This probably has to do with the use of iterators which are emptied as they are used.
 	// Note that in a for comprehension the quality of hierarchical nesting (like nested for-loops)
	for {
	  i <- list1
	  j <- list2
	}
	yield(i * j)                              //> res4: List[Int] = List(8, 9, 16, 18)
	
	val result2 = for {
	  i <- 1 until 10
	  j <- 1 until (i-1)
	  if((i + j) % 2 == 0) // 'if' guard
	} yield (i + j)                           //> result2  : scala.collection.immutable.IndexedSeq[Int] = Vector(4, 6, 6, 8, 
                                                  //| 8, 10, 8, 10, 12, 10, 12, 14, 10, 12, 14, 16)
	
	//(B)
	for {
	  i <- list1
	  j <- list2
	  k <- last
	}
	yield(i * j * k.length)                   //> res5: List[Int] = List(16, 24, 32, 18, 27, 36, 32, 48, 64, 36, 54, 72)
	
	
}