package matrixlike

object VectorLike_lab_1 {
  
  val v1 = List(5.0, 4.0, 3.0, 2.0)               //> v1  : List[Double] = List(5.0, 4.0, 3.0, 2.0)
  val v2 = List(2.0, 2.0, 2.0, 2.0)               //> v2  : List[Double] = List(2.0, 2.0, 2.0, 2.0)
  
  def diff(v1: List[Double], v2: List[Double]): List[Double] = {
  	require(v1.length == v2.length, "diff - inputs must be of equal length.")
  	val zipped = v1 zip v2
  	val difRes = zipped map { tup: (Double, Double) => tup._1 - tup._2 }
  	difRes
  }                                               //> diff: (v1: List[Double], v2: List[Double])List[Double]
  
  diff(v1, v2)                                    //> res0: List[Double] = List(3.0, 2.0, 1.0, 0.0)
}