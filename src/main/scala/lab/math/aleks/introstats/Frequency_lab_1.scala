package lab.math.aleks.introstats

object Frequency_lab_1 extends App {
  
  def groupByClassSize(data0: List[Int], startAt: Double, classSize: Int) {
	  val sorted = data0.sorted
	  val data1 = sorted.drop(sorted.indexWhere((x => x >= startAt)))
	  
	  def inter(data: List[Int], upperBound: Double, accum: List[(Int, Double)]): List[(Int, Double)] = {
		  val split = data.splitAt(data.indexWhere(x => x > upperBound))
		  println(split)
		  
		  // TODO: This is flawed! It's hacked and doesn't account for empty classes between populated classes.
		  if(split._1 == Nil) {
			  (split._2.length, upperBound) :: accum
		  }
		  else if(split._2 != Nil) {
			  inter(split._2, upperBound + classSize, ( split._1.length, upperBound) :: accum)
		  }
		  else accum
	  }
	  
	  val grouped = inter(data1, startAt + classSize, List[(Int, Double)]())
	  print(startAt); print(" "); println(grouped.reverse)
  }
  
  def groupByNumClasses(data: List[Int], numClasses: Int) {
    
  }

}