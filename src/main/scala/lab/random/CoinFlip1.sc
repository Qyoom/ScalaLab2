package lab.random

object CoinFlip1 {

	//-------- Mechanism ---------------------/
	
  val randGen = new scala.util.Random             //> randGen  : scala.util.Random = scala.util.Random@31f26605
  
  val outcome = Map(
    		0 -> "H",
    		1 -> "T"
	)                                         //> outcome  : scala.collection.immutable.Map[Int,String] = Map(0 -> H, 1 -> T)
  
  def flip = randGen.nextInt(2)                   //> flip: => Int
  
  //-------- Set up -----------------------/
  
  val numberOfFlips = 10000                       //> numberOfFlips  : Int = 10000
  
  //--------- Experiment ------------------/
    val outcomes = for(
    		i <- 1 to numberOfFlips
    ) yield { outcome(flip) }                     //> outcomes  : scala.collection.immutable.IndexedSeq[String] = Vector(T, T, H, 
                                                  //| T, T, H, H, H, H, H, H, H, T, H, T, T, T, T, T, H, H, T, H, T, T, T, H, T, T
                                                  //| , T, H, H, T, T, H, H, T, H, H, T, H, H, T, T, H, T, H, T, T, T, T, H, H, T,
                                                  //|  H, T, T, T, H, T, T, H, T, H, T, T, T, H, H, H, H, H, H, H, H, T, T, H, T, 
                                                  //| H, T, T, H, T, T, T, H, T, H, H, H, H, H, T, T, H, H, T, T, H, H, H, T, T, T
                                                  //| , H, H, T, T, T, T, T, H, T, T, T, H, H, T, T, H, T, T, H, T, H, H, T, T, H,
                                                  //|  T, T, T, H, T, H, H, T, T, T, T, T, T, T, H, H, T, H, T, T, H, T, H, T, T, 
                                                  //| T, H, T, H, T, T, H, H, H, T, H, H, H, T, H, T, H, T, T, T, H, H, H, T, H, H
                                                  //| , H, H, H, T, H, T, H, H, H, H, H, T, H, H, T, T, T, T, T, T, T, T, T, H, H,
                                                  //|  T, T, H, T, T, T, T, H, H, T, H, H, T, T, T, T, H, H, H, H, H, T, H, H, H, 
                                                  //| H, T, H, H, T, T, H, T, H, H, T, T, T, T, H, H, T, H, T, H, T, T, H, T, T, H
                                                  //| , T, H, T, H, T, H, T, H, T, T, H, T, T, H, T, H, T, T, H, H, T, T, H, T, T,
                                                  //|  T, T, T, H, T, T, H, H,
                                                  //| Output exceeds cutoff limit.
  
    
    val numberOfHeads = outcomes.count(_ == "H")  //> numberOfHeads  : Int = 5071
    
    //http://stackoverflow.com/questions/11106886/scala-doubles-and-precision
    val outcome_percentage = BigDecimal((numberOfHeads.toDouble/numberOfFlips) * 100)
    		.setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble + "%"
                                                  //> outcome_percentage  : String = 50.7%
      
}