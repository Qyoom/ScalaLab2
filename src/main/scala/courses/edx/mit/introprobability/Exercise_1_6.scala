package courses.edx.mit.introprobability

object Exercise_1_6 {
	
  	// ----- Sample Space ------------- //
	
	object Coin extends Enumeration {
	  	type Coin = Value
		val Heads, Tails = Value
  	}
  	val H = Coin.Heads
  	val T = Coin.Tails
  	val sides = Coin.values.toList
  	
  	// Events are possible sequences of a uniform number of coin tosses
  	// List of events
  	type TossSeq = List[List[Coin.Value]]
  
	// Sample space for this experiment is all combinations of three coin tosses
	// Order of elements matters, i.e. (H,H,T) != (H,T,H)
	val sampleSpace:TossSeq = for{
  		_1st_coin <- sides
  		_2nd_coin <- sides
  		_3rd_coin <- sides
	} yield List(_1st_coin, _2nd_coin, _3rd_coin)
	
	// ----- log sample space ------------ //
  
	println("sampleSpace.length: " + sampleSpace.length) 
	
	val sampleSpace_log = for{
		event <- sampleSpace
	} yield {
		event match {
			case List(a, b, c) => (a, b, c)
		}                                 
	}
}