package lab.typestudy2

// // https://www.sumologic.com/2012/09/23/scala-at-sumo-type-classes-with-a-machine-learning-example/
object TypeClass_lab_2 {

	// Option 1: require the caller to convert their data to Array[Double] before calling our code
	class LinearClassifier1(weights: Array[Double]) {
 
	  def classify(x: Array[Double]): Boolean = {
	    innerProduct(x, weights) > 0
	  }
	 
	  def innerProduct(x: Array[Double], y: Array[Double]): Double = {
	    (0 until x.size).map{i => x(i) * y(i)}.sum
	  }
	} // End LinearClassifier1
	
	// Option 2: add a parameter T => Array[Double]
	// that allows us to compute a feature vector from an instance of T
	class LinearClassifier2[T](features: T => Array[Double],
                             weights: Array[Double]) {
	  def classify(x: T): Boolean = {
	    innerProduct(features(x), weights) > 0
	  }
	  
		def innerProduct(x: Array[Double], y: Array[Double]): Double = {
	    (0 until x.size).map{i => x(i) * y(i)}.sum
	  }
	}
	
	// Option 3: define a FeatureVector trait with a method features: Array[Double],
	// adding the type bound T <: FeatureVector
	trait FeatureVector1 {
	  def features: Array[Double]
	}
	 
	class LinearClassifier3[T <: FeatureVector1](weights: Array[Double]) {
	  def classify(x: T): Boolean = {
	    innerProduct(x.features, weights) > 0
	  }
	  def innerProduct(x: Array[Double], y: Array[Double]): Double = {
	    (0 until x.size).map{i => x(i) * y(i)}.sum
	  }
	} // End LinearClassifier3
	
	//====================================================================//
	
	// This is the BEST. The test code that follows uses this
	// Option 4: define a type FeatureVector[T] and use the context bound T : FeatureVector
	trait FeatureVector2[T] {
	  def features(x: T): Array[Double]
	}
	
	class LinearClassifier4[T : FeatureVector2](weights: Array[Double]) {
	  val featureMapping = implicitly[FeatureVector2[T]]
	 
	  def classify(x: T): Boolean = {
	    innerProduct(featureMapping.features(x), weights) > 0
	  }
	  def innerProduct(x: Array[Double], y: Array[Double]): Double = {
	    (0 until x.size).map{i => x(i) * y(i)}.sum
	  }
	} // End LinearClassifier4
	
	// https://gist.github.com/davidandrzej/ec7a9d47939da2414b79
	// This implicit supplies a means to
  // compute feature vectors from Strings
  implicit object StringFeatures extends FeatureVector2[String] {
    def features(x: String): Array[Double] = {
      // Just count the occurrences of a, b, and c
      val result = Array.ofDim[Double](3)
      result(0) = x.filter{_ equals 'a'}.size.toDouble
      result(1) = x.filter{_ equals 'b'}.size.toDouble
      result(2) = x.filter{_ equals 'c'}.size.toDouble
      result
    }
  }
 
  // Build a very simple classifier
  val testWeights = Array[Double](-1.0, 0.0, 1.0) //> testWeights  : Array[Double] = Array(-1.0, 0.0, 1.0)
 
  //
  // Classify some Strings
  //
  val stringClassifier = new LinearClassifier4[String](testWeights)
                                                  //> stringClassifier  : lab.typestudy2.TypeClass_lab_2.LinearClassifier4[String
                                                  //| ] = lab.typestudy2.TypeClass_lab_2$LinearClassifier4@4d09341
 
  // negative-weight 'a', should be classified as false
  val ex1 = "aaa"                                 //> ex1  : String = aaa
  val predict1 = stringClassifier.classify(ex1)   //> predict1  : Boolean = false
  println("%s is classified as %b".format(ex1, predict1))
                                                  //> aaa is classified as false
 
  // positive-weight 'c' and zero-weight 'b' (classify as true)
  val ex2 = "bbbcc"                               //> ex2  : String = bbbcc
  val predict2 = stringClassifier.classify(ex2)   //> predict2  : Boolean = true
  println("%s is classified as %b".format(ex2, predict2))
                                                  //> bbbcc is classified as true
	val ex3 = "cbbbbbbbbac"                   //> ex3  : String = cbbbbbbbbac
	val predict3 = stringClassifier.classify(ex3)
                                                  //> predict3  : Boolean = true
	println("%s is classified as %b".format(ex3, predict3))
                                                  //> cbbbbbbbbac is classified as true
}
/*




*/