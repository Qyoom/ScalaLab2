package lab.typestudy2

object TypeClass_lab {
	// http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
	// This is a type class version of lab.statistics.WhiskerStats_2
	
	// Type class with implicits
  object Math {
  		import annotation.implicitNotFound
  		@implicitNotFound("No member of type class NumberLike in scope for ${T}")
  		trait NumberLike[T] {
  			def plus(x:T, y:T): T
  			def divide(x:T, y:Int): T
  			def minus(x:T, y:T): T
  		}
  		object NumberLike {
  			implicit object NumberLikeDouble extends NumberLike[Double] {
  				def plus(x:Double, y:Double): Double = x + y
	  			def divide(x:Double, y:Int): Double = x / y
	  			def minus(x:Double, y:Double): Double = x - y
  			}
  			implicit object NumberLikeInt extends NumberLike[Int] {
  				def plus(x:Int, y:Int): Int = x + y
	  			def divide(x:Int, y:Int): Int = x / y
	  			def minus(x:Int, y:Int): Int = x - y
  			}
  		}
  } // End Math
  
  // ------- Clients of type class NumberLike ------------------- //
  
  object Statistics {
	  import Math.NumberLike
	  
	  def mean[T](X0: Vector[T])(implicit ev: NumberLike[T]): T = {
	  		ev.divide(X0.reduce(ev.plus(_, _)), X0.length)
	  }
	  	  
	  def median[T: NumberLike](X: Vector[T]): T = {
	  		// TODO: Having to forgo sorting because I don't know how to do it implicitly for type class yet.
			if(X.length % 2 == 0) {
				val under = X((X.length/2) - 1)
				val over = X(X.length/2)
				implicitly[NumberLike[T]].divide(implicitly[NumberLike[T]].plus(under, over), 2)
			}
			else {
				val middle_ = X.length/2
				X(middle_.toInt)
			}
		} // End median
    		
		def quartiles[T: NumberLike](X: Vector[T]): (T, T, T) = {
			// TODO: Having to forgo sorting because I don't know how to do it implicitly for type class yet.
			val median_ = median(X)
			val Q1 = median(X.take(X.length/2))
			val Q3 = {
				if(X.length % 2 == 0) median(X.drop(X.length/2))
				else                  median(X.drop(X.length/2 + 1))
			}
			(Q1, median_, Q3)
		} // End quartiles
    
    def iqr[T: NumberLike](X: Vector[T]): T = quartiles(X) match {
			case (lowerQ, _, upperQ) => implicitly[NumberLike[T]].minus(upperQ, lowerQ)
		}
			    
	} // End Statistics
	
	// ------- Tests -------------------------------- //
	
	import Statistics._
	
	//.......Double......//
	val v3 = Vector.range(1, 6).map(_.toDouble)
                                                  //> v3  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0, 4.0
                                                  //| , 5.0)
	mean(v3)                                  //> res0: Double = 3.0
	quartiles(v3)                             //> res1: (Double, Double, Double) = (1.5,3.0,4.5)
	iqr(v3)                                   //> res2: Double = 3.0
	
	//.......Int.......//
	
	val v6 = Vector.range(1, 6)               //> v6  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)
	mean(v6)                                  //> res3: Int = 3
	quartiles(v6)                             //> res4: (Int, Int, Int) = (1,3,4)
	iqr(v6)                                   //> res5: Int = 3
	
	//.......Double.......//
	
	val numbers = Vector[Double](13, 23.0, 42, 45, 61, 73, 96, 100, 199, 420, 900, 3839)
                                                  //> numbers  : scala.collection.immutable.Vector[Double] = Vector(13.0, 23.0, 4
                                                  //| 2.0, 45.0, 61.0, 73.0, 96.0, 100.0, 199.0, 420.0, 900.0, 3839.0)
	println(Statistics.mean(numbers))         //> 484.25
	
	//....... String .......//
	
	val strings = Vector[String]("cat", "dog", "mouse", "house", "parakeet")
                                                  //> strings  : scala.collection.immutable.Vector[String] = Vector(cat, dog, mou
                                                  //| se, house, parakeet)
	//mean(strings) // Exception: No member of type class NumberLike in scope for String
}
/*



*/