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
  
	val obs1 = (Red, DenseVector(0d, 3, 0))   //> obs1  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Red,DenseVector(0.0, 3.0, 0.0))
	val obs2 = (Red, DenseVector(2d, 0, 0))   //> obs2  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Red,DenseVector(2.0, 0.0, 0.0))
	val obs3 = (Red, DenseVector(0d, 1, 3))   //> obs3  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Red,DenseVector(0.0, 1.0, 3.0))
	val obs4 = (Green, DenseVector(0d, 1, 2)) //> obs4  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Green,DenseVector(0.0, 1.0, 2.0))
	val obs5 = (Green, DenseVector(-1d, 0, 1))//> obs5  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Green,DenseVector(-1.0, 0.0, 1.0))
	val obs6 = (Red, DenseVector(1d, 1, 1))   //> obs6  : (courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value, 
                                                  //| breeze.linalg.DenseVector[Double]) = (Red,DenseVector(1.0, 1.0, 1.0))
	val obss = List[LabeledPt](obs1, obs2, obs3, obs4, obs5, obs6)
                                                  //> obss  : List[(courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Va
                                                  //| lue, breeze.linalg.DenseVector[Double])] = List((Red,DenseVector(0.0, 3.0, 0
                                                  //| .0)), (Red,DenseVector(2.0, 0.0, 0.0)), (Red,DenseVector(0.0, 1.0, 3.0)), (G
                                                  //| reen,DenseVector(0.0, 1.0, 2.0)), (Green,DenseVector(-1.0, 0.0, 1.0)), (Red,
                                                  //| DenseVector(1.0, 1.0, 1.0)))
	
	val testPoint = DenseVector(0d, 0, 0)     //> testPoint  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0)
	
	// --------------------------------- //
	
	// Measure Euclidean distance between each labeled data point and the test point
	val dists = for(obs <- obss) yield {
		val distance = eucDist(obs._2, testPoint)
    (distance, obs)
	}                                         //> Apr 09, 2015 10:59:18 AM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader8015454054699741299netlib-native_system-osx-x86_64.jnilib
                                                  //| dists  : List[(Double, (courses.stanford.statlearning.K_nearest_neighbor_2_
                                                  //| ws.Color.Value, breeze.linalg.DenseVector[Double]))] = List((3.0,(Red,Dense
                                                  //| Vector(0.0, 3.0, 0.0))), (2.0,(Red,DenseVector(2.0, 0.0, 0.0))), (3.1622776
                                                  //| 601683795,(Red,DenseVector(0.0, 1.0, 3.0))), (2.23606797749979,(Green,Dense
                                                  //| Vector(0.0, 1.0, 2.0))), (1.4142135623730951,(Green,DenseVector(-1.0, 0.0, 
                                                  //| 1.0))), (1.7320508075688772,(Red,DenseVector(1.0, 1.0, 1.0))))
  // Order results by distance
  // inefficient performance, I suspect...
	val obsByDist = dists.sortBy(_._1)        //> obsByDist  : List[(Double, (courses.stanford.statlearning.K_nearest_neighbo
                                                  //| r_2_ws.Color.Value, breeze.linalg.DenseVector[Double]))] = List((1.41421356
                                                  //| 23730951,(Green,DenseVector(-1.0, 0.0, 1.0))), (1.7320508075688772,(Red,Den
                                                  //| seVector(1.0, 1.0, 1.0))), (2.0,(Red,DenseVector(2.0, 0.0, 0.0))), (2.23606
                                                  //| 797749979,(Green,DenseVector(0.0, 1.0, 2.0))), (3.0,(Red,DenseVector(0.0, 3
                                                  //| .0, 0.0))), (3.1622776601683795,(Red,DenseVector(0.0, 1.0, 3.0))))
	
	// k = 1
	// also inefficient...
	val nn1: List[LabeledPt] = obsByDist.take(1).map(obd => obd._2)
                                                  //> nn1  : List[(courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Co
                                                  //| lor, breeze.linalg.DenseVector[Double])] = List((Green,DenseVector(-1.0, 0.
                                                  //| 0, 1.0)))
  // k = 3
	val nn3: List[LabeledPt] = obsByDist.take(3).map(obd => obd._2)
                                                  //> nn3  : List[(courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Co
                                                  //| lor, breeze.linalg.DenseVector[Double])] = List((Green,DenseVector(-1.0, 0.
                                                  //| 0, 1.0)), (Red,DenseVector(1.0, 1.0, 1.0)), (Red,DenseVector(2.0, 0.0, 0.0)
                                                  //| ))
	
  def assignLabel(nn: List[LabeledPt]): Color.Value = {
  		// this will work for binary solution
  		val count = for(n <- nn) yield {
  			if(n._1 == Red) 1.0
  			else 0.0
  		}
  		val res = count.sum / count.length
  		if(res > 0.5) Red
  		else Green
  }                                               //> assignLabel: (nn: List[(courses.stanford.statlearning.K_nearest_neighbor_2_
                                                  //| ws.Color.Color, breeze.linalg.DenseVector[Double])])courses.stanford.statle
                                                  //| arning.K_nearest_neighbor_2_ws.Color.Value
  // Solutions to nearest neighbor labeling depending on k
  assignLabel(nn1)                                //> res0: courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value = G
                                                  //| reen
  assignLabel(nn3)                                //> res1: courses.stanford.statlearning.K_nearest_neighbor_2_ws.Color.Value = R
                                                  //| ed
}
/*



*/