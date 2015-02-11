package courses.edx.mit.introprobability

object Exercise_1_7 {
	
	// ----- Sample Space ------------- //
  	
  	// Sample space for this experiment is all combinations of two die rolls.
	// X is first roll, Y is second roll.
	// Order of elements matters, i.e. (1,3) != (3,1)
	val sides = List(1,2,3,4)
	type RollSeq = List[List[Int]]
	val sampleSpace:RollSeq = for{
  		X <- sides
  		Y <- sides
	} yield List(X, Y)
	
	// ----- log sample space ------------ //
	
	println("sampleSpace.length: " + sampleSpace.length)
	
	val sampleSpace_log = for{
		event <- sampleSpace
	} yield {
		event match {
			case List(x, y) => (x, y)
		}                                 
	}
}




