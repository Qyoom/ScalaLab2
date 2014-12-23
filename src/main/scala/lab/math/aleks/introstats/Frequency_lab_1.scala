package lab.math.aleks.introstats

object Frequency_lab_1 extends App {
  
  def groupByClassSize(data0: List[Int], startAt: Double, classSize: Int) {
	  val sorted = data0.sorted
	  val data1 = sorted.drop(sorted.indexWhere((x => x >= startAt)))
	  
	  def inter(data: List[Int], upperBound: Double, accum: List[(Int, Double, Double)]): List[(Int, Double, Double)] = {
		  val split = data.splitAt(data.indexWhere(x => x > upperBound))
		  //println(split)
		  
		  val midpoint = upperBound - (classSize / 2d)
		  
		  // TODO: This is flawed! It's hacked and doesn't account for empty classes between populated classes.
		  if(split._1 == Nil) {
			  (split._2.length, midpoint, upperBound) :: accum
		  }
		  else if(split._2 != Nil) {
			  inter(split._2, upperBound + classSize, (split._1.length, midpoint, upperBound) :: accum)
		  }
		  else accum
	  }
	  
	  // accum is (frequency, midpoint, upperBound)
	  val grouped = inter(data1, startAt + classSize, List[(Int, Double, Double)]())
	  println("---------------------------------------")
	  println("initial:" + startAt)
	  grouped.reverse.foreach { c =>
	    println("frequency:" + c._1 + " midpoint:" + c._2 + " upperBound:" + c._3)
	  }
  }
  
  def groupByNumClasses(data: List[Int], numClasses: Int) {
    
  }

}