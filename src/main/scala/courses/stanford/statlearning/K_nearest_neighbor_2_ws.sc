package courses.stanford.statlearning

import breeze.linalg._
import breeze.numerics._
import lab.math.vectorspace.EuclideanLabBreeze2._
 
/*
 * An Introduction to Statistical Learning with R
 * Ch.2 p.53 question 7
 */
object K_nearest_neighbor_2_ws {
  // Utility types
	object Color extends Enumeration {
    type Color = Value
    val Red, Green = Value
  }
  import Color._
  
	type LabeledPt = (Color, DenseVector[Double])
	
  // ------- Data (LabeledPt) -------------------------- //
  
  // Vectors define points in n-dimentional Cartesian space
  
	val obs1 = (Red, DenseVector(0d, 3, 0))
	val obs2 = (Red, DenseVector(2d, 0, 0))
	val obs3 = (Red, DenseVector(0d, 1, 3))
	val obs4 = (Green, DenseVector(0d, 1, 2))
	val obs5 = (Green, DenseVector(-1d, 0, 1))
	val obs6 = (Red, DenseVector(1d, 1, 1))
	val obss = List[LabeledPt](obs1, obs2, obs3, obs4, obs5, obs6)
	
	val testPoint = DenseVector(0d, 0, 0)
	
	// --------------------------------- //
	
	// Measure Euclidean distance between each labeled data point and the test point
	val dists = for(obs <- obss) yield {
		val distance = eucDist(obs._2, testPoint)
    (distance, obs)
	}
  // Order results by distance
  // inefficient performance, I suspect...
	val obsByDist = dists.sortBy(_._1)
	
	// k = 1
	// also inefficient...
	val nn1: List[LabeledPt] = obsByDist.take(1).map(obd => obd._2)
  // k = 3
	val nn3: List[LabeledPt] = obsByDist.take(3).map(obd => obd._2)
	
  def assignLabel(nn: List[LabeledPt]): Color.Value = {
  		// this will work for binary solution
  		val count = for(n <- nn) yield {
  			if(n._1 == Red) 1.0
  			else 0.0
  		}
  		val res = count.sum / count.length
  		if(res > 0.5) Red
  		else Green
  }
  // Solutions to nearest neighbor labeling depending on k
  assignLabel(nn1)
  assignLabel(nn3)
}
/*



*/