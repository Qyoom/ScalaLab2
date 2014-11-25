package lab.random

// Dice simulation
object Random2 {
    val randGen = new scala.util.Random()         //> randGen  : scala.util.Random = scala.util.Random@485329c5
    
    val oneHalf = 1.0/2.0                         //> oneHalf  : Double = 0.5
    val oneThird = 1.0/3.0                        //> oneThird  : Double = 0.3333333333333333
    val oneSixth = 1.0/6.0                        //> oneSixth  : Double = 0.16666666666666666
    
    val outcome = Map(
    		1 -> oneHalf,
    		2 -> oneHalf,
    		3 -> oneHalf,
    		4 -> oneThird,
    		5 -> oneThird,
    		6 -> oneSixth
		)                                 //> outcome  : scala.collection.immutable.Map[Int,Double] = Map(5 -> 0.333333333
                                                  //| 3333333, 1 -> 0.5, 6 -> 0.16666666666666666, 2 -> 0.5, 3 -> 0.5, 4 -> 0.3333
                                                  //| 333333333333)
		
		def roll = randGen.nextInt(6)+1   //> roll: => Int
		
    //-------------------------------------------/
    for(
    		i <- 1 to 10
    ) yield {println("probability--> " + outcome(roll))}
                                                  //> probability--> 0.16666666666666666
                                                  //| probability--> 0.16666666666666666
                                                  //| probability--> 0.5
                                                  //| probability--> 0.5
                                                  //| probability--> 0.3333333333333333
                                                  //| probability--> 0.16666666666666666
                                                  //| probability--> 0.5
                                                  //| probability--> 0.5
                                                  //| probability--> 0.3333333333333333
                                                  //| probability--> 0.5
                                                  //| res0: scala.collection.immutable.IndexedSeq[Unit] = Vector((), (), (), (), (
                                                  //| ), (), (), (), (), ())
}