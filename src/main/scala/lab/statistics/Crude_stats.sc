package lab.statistics

// http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
// See WhiskerStats for accurate calculations
	
object Statistics {
  def median(xs: Vector[Double]): Double = xs(xs.size / 2)
                                                  //> median: (xs: Vector[Double])Double
  def quartiles(xs: Vector[Double]): (Double, Double, Double) =
    (xs(xs.size / 4), median(xs), xs(xs.size / 4 * 3))
                                                  //> quartiles: (xs: Vector[Double])(Double, Double, Double)
  def iqr(xs: Vector[Double]): Double = quartiles(xs) match {
    case (lowerQuartile, _, upperQuartile) => upperQuartile - lowerQuartile
  }                                               //> iqr: (xs: Vector[Double])Double
  def mean(xs: Vector[Double]): Double = {
    xs.reduce(_ + _) / xs.size
  }                                               //> mean: (xs: Vector[Double])Double
}