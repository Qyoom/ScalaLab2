package lab.random

// Dice simulation
object Dice2 {
    val randGen = new scala.util.Random()         //> randGen  : scala.util.Random = scala.util.Random@1f292d26
    
		
		def roll = randGen.nextInt(6)+1   //> roll: => Int
		
    //-------------------------------------------/
    // THIS IS NOT ACCURATE!! BECAUSE 6 MAY INCREMENT TWICE IN ONE SERIES!!
    
    val seriesSize = 10000                        //> seriesSize  : Int = 10000
    val rollsPerSeries = 4                        //> rollsPerSeries  : Int = 4
    val hasSix = for(
    		series <- 1 to seriesSize;
    		outcome <- 1 to rollsPerSeries
    		if (roll == 6)
    ) yield { roll	}                         //> hasSix  : scala.collection.immutable.IndexedSeq[Int] = Vector(5, 6, 2, 3, 2,
                                                  //|  3, 2, 3, 4, 5, 4, 1, 3, 2, 1, 5, 4, 2, 2, 2, 4, 3, 3, 1, 4, 4, 1, 5, 1, 2, 
                                                  //| 3, 1, 6, 2, 1, 3, 1, 2, 2, 5, 2, 6, 4, 2, 6, 1, 6, 3, 1, 6, 6, 6, 2, 3, 3, 3
                                                  //| , 3, 4, 3, 2, 4, 3, 2, 4, 6, 1, 4, 6, 3, 4, 6, 2, 3, 1, 2, 2, 6, 4, 1, 6, 2,
                                                  //|  5, 3, 1, 5, 5, 2, 1, 4, 4, 3, 5, 6, 6, 5, 5, 5, 3, 5, 1, 4, 4, 5, 1, 4, 1, 
                                                  //| 5, 2, 5, 4, 2, 4, 6, 3, 6, 1, 6, 4, 5, 5, 2, 6, 4, 2, 4, 3, 4, 6, 1, 5, 1, 5
                                                  //| , 3, 2, 2, 2, 5, 3, 3, 6, 3, 5, 4, 5, 2, 1, 5, 1, 2, 4, 5, 5, 4, 3, 3, 1, 3,
                                                  //|  6, 3, 3, 5, 6, 2, 3, 3, 2, 3, 5, 4, 3, 5, 3, 2, 5, 4, 4, 2, 6, 2, 2, 2, 4, 
                                                  //| 4, 6, 4, 4, 2, 6, 4, 1, 6, 2, 5, 3, 1, 6, 1, 6, 1, 5, 2, 3, 6, 6, 5, 1, 6, 2
                                                  //| , 6, 5, 1, 1, 6, 1, 3, 4, 4, 2, 6, 3, 2, 4, 5, 5, 2, 5, 1, 2, 4, 6, 5, 2, 6,
                                                  //|  1, 2, 4, 5, 6, 6, 2, 2, 5, 2, 4, 1, 4, 4, 5, 1, 4, 1, 1, 2, 3, 2, 6, 3, 5, 
                                                  //| 5, 6, 6, 3, 5, 2, 3, 4, 5, 2, 1, 1, 6, 1, 4, 6, 6, 3, 6, 1, 1, 1, 2, 2, 5, 3
                                                  //| , 3, 5, 4, 4, 1, 1, 6, 6
                                                  //| Output exceeds cutoff limit.
   	//http://stackoverflow.com/questions/11106886/scala-doubles-and-precision
    val outcome_percentage = BigDecimal((hasSix.length.toDouble/seriesSize) * 100)
    		.setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble + "%"
                                                  //> outcome_percentage  : String = 65.7%
}