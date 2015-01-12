package lab.math.aleks.introstats

import lab.math.Rounding_lab_1.roundAt

object Frequency_lab_2 {
  
  def groupByClassSize(data0: List[Int], startAt: Double, classSize: Int) {
    
	  val sorted = data0.sorted
	  val data1 = sorted.drop(sorted.indexWhere((x => x >= startAt)))
	  val round = roundAt(3)_ // util
	  
	  def inter(data: List[Int], upperBound: Double, accum: List[(Int, Double, Int, Double, Double, Double)])
	  	: List[(Int, Double, Int, Double, Double, Double)] = {
		  val split = data.splitAt(data.indexWhere(x => x > upperBound))
		  //println(split)
		  
		  val freq = if(split._1 == Nil) split._2.length else split._1.length
		  val relFreq = round(freq / data1.length.toDouble)
		  val cumFreq = if(accum != Nil) freq + accum.head._3 else freq
		  val cumRelFreq = if(accum != Nil) round(relFreq + accum.head._4) else relFreq
		  val midpoint = upperBound - (classSize / 2d)
		  val newAccum = (freq, relFreq, cumFreq, cumRelFreq, midpoint, upperBound) :: accum
		  
		  if(split._1 == Nil) {
			  // TODO: This doesn't account for empty classes between populated classes.
			  newAccum
		  }
		  else {
			  inter(split._2, upperBound + classSize, newAccum)
		  }
	  }
	  
	  // accum is (frequency, relative freq, cumulative freq, cum rel freq, midpoint, upperBound)
	  val grouped = inter(data1, startAt + classSize, List[(Int, Double, Int, Double, Double, Double)]())
	  println("---------------------------------------")
	  println("initial:" + startAt)
	  grouped.reverse.foreach { c =>
	    println("frequency:" + c._1 + " relative freq:" + c._2 + " cumulative freq:" + c._3
	        + " cumulative relative freq:" + c._4 + " midpoint:" + c._5 + " upperBound:" + c._6)
	  }
  }

}