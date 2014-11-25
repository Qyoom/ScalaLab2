package lab.random

// Dice simulation, An Introduction to Probability.pdf, p.4(14)
object Dice4 {
    val randGen = new scala.util.Random()         //> randGen  : scala.util.Random = scala.util.Random@1f292d26
    
		
		def roll = randGen.nextInt(6)+1   //> roll: => Int
		
    //-------------------------------------------/
    // Look at all these VARs! BAD!!
    val seriesSize = 10000                        //> seriesSize  : Int = 10000
    val rollsPerSeries = 4                        //> rollsPerSeries  : Int = 4
    var	seriesCounter = seriesSize                //> seriesCounter  : Int = 10000
    var numRolls = rollsPerSeries                 //> numRolls  : Int = 4
    var targetOutcome = false                     //> targetOutcome  : Boolean = false
    var totalTargeOutcome = 0                     //> totalTargeOutcome  : Int = 0
    
    // Series iterator
    while(seriesCounter > 0) {
      // Rolls within each series
	    while(numRolls > 0) {
	    		val die1 = roll
	    		// Outcome of interest
	    		if(die1 == 6) {
	    			targetOutcome = true
	    		}
	    		numRolls -= 1 // increment
	    }
	    
	    // Outcome of interest
	    if(targetOutcome) {
	    		totalTargeOutcome += 1
    		}
	    
	    targetOutcome = false // reset
	    seriesCounter -= 1 // increment
	    numRolls = rollsPerSeries // reset
    }
    println("totalPairsOfSixes:" + totalTargeOutcome)
                                                  //> totalPairsOfSixes:5176
    println("seriesSize:" + seriesSize)           //> seriesSize:10000
                              
    
   	//http://stackoverflow.com/questions/11106886/scala-doubles-and-precision
    val outcome_percentage = BigDecimal((totalTargeOutcome.toDouble/seriesSize) * 100)
    		.setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble + "%"
                                                  //> outcome_percentage  : String = 51.8%
                                                   
}