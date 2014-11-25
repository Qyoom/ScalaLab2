package lab.random

// Dice simulation, An Introduction to Probability.pdf, p.4(14)
object Dice3 {
    val randGen = new scala.util.Random()         //> randGen  : scala.util.Random = scala.util.Random@485329c5
    
		
		def roll = randGen.nextInt(6)+1   //> roll: => Int
		
    //-------------------------------------------/
    // Look at all these VARs! BAD!!
    val seriesSize = 1000                         //> seriesSize  : Int = 1000
    val rollsPerSeries = 25                       //> rollsPerSeries  : Int = 25
    var	seriesCounter = seriesSize                //> seriesCounter  : Int = 1000
    var numRolls = rollsPerSeries                 //> numRolls  : Int = 25
    var pairOfSixes = false                       //> pairOfSixes  : Boolean = false
    var totalPairsOfSixes = 0                     //> totalPairsOfSixes  : Int = 0
    
    // Series iterator
    while(seriesCounter > 0) {
      // Rolls within each series
	    while(numRolls > 0) {
	    		val die1 = roll
	    		val die2 = roll
	    		// Outcome of interest
	    		if(die1 == 6 && die2 == 6) {
	    			pairOfSixes = true
	    		}
	    		numRolls -= 1 // increment
	    }
	    
	    // Outcome of interest
	    if(pairOfSixes) {
	    		totalPairsOfSixes += 1
    		}
	    
	    pairOfSixes = false // reset
	    seriesCounter -= 1 // increment
	    numRolls = rollsPerSeries // reset
    }
    println("totalPairsOfSixes:" + totalPairsOfSixes)
                                                  //> totalPairsOfSixes:504
    println("seriesSize:" + seriesSize)           //> seriesSize:1000
                              
    
   	//http://stackoverflow.com/questions/11106886/scala-doubles-and-precision
    val outcome_percentage = BigDecimal((totalPairsOfSixes.toDouble/seriesSize) * 100)
    		.setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble + "%"
                                                  //> outcome_percentage  : String = 50.4%


}