package lab.typestudy2

// https://www.sumologic.com/2012/09/23/scala-at-sumo-type-classes-with-a-machine-learning-example/
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
	
	// This is the BEST. The test code that follows uses this version.
	// Option 4: define a type FeatureVector[T] and use the context bound T : FeatureVector
	trait FeatureVector2[T] {
	  def features(x: T): Array[Double]
	}
	
	class LinearClassifier4[T : FeatureVector2](weights: Array[Double]) {
	  val featureMapping = implicitly[FeatureVector2[T]]
	 	// featureMapping implicitly extends FeatureVector2 and provides the features function.
	  def classify(x: T): Boolean = {
	    innerProduct(featureMapping.features(x), weights) > 0
	  }
	  def innerProduct(x: Array[Double], y: Array[Double]): Double = {
	    (0 until x.size).map(i => {x(i) * y(i)}).sum
	  }
	} // End LinearClassifier4
	
	// https://gist.github.com/davidandrzej/ec7a9d47939da2414b79
	// This implicit supplies a means to compute feature vectors from Strings
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
  
  // RW: My experiment with provide another implicit type extension for Boolean
  implicit object BooleanFeatures extends FeatureVector2[List[Boolean]] {
  		def features(x: List[Boolean]): Array[Double] = {
  			// Just count the occurrences of true and false
  			val result = Array.ofDim[Double](2)
  			result(0) = x.filter{_ equals false}.size.toDouble
  			result(1) = x.filter{_ equals true}.size.toDouble
  			result
  		}
  }
  
  // ------ String classifier tests --------- //
 
  // Build a very simple classifier for StringFeatures
  val testWeights1 = Array[Double](-1.0, 0.0, 1.0)//> testWeights1  : Array[Double] = Array(-1.0, 0.0, 1.0)
 
  // Classify some Strings
  val stringClassifier = new LinearClassifier4[String](testWeights1)
                                                  //> stringClassifier  : lab.typestudy2.TypeClass_lab_2.LinearClassifier4[String
                                                  //| ] = lab.typestudy2.TypeClass_lab_2$LinearClassifier4@44ce3dad
 
  // negative-weight 'a', should be classified as false
  val exStr1 = "aaa"                              //> exStr1  : String = aaa
  val predictStr1 = stringClassifier.classify(exStr1)
                                                  //> predictStr1  : Boolean = false
  println("%s is classified as %b".format(exStr1, predictStr1))
                                                  //> aaa is classified as false
 
  // positive-weight 'c' and zero-weight 'b' (classify as true)
  val exStr2 = "bbbcc"                            //> exStr2  : String = bbbcc
  val predictStr2 = stringClassifier.classify(exStr2)
                                                  //> predictStr2  : Boolean = true
  println("%s is classified as %b".format(exStr2, predictStr2))
                                                  //> bbbcc is classified as true
  // Other experiments with String type class
	val exStr3 = "cbbbbbbbbac"                //> exStr3  : String = cbbbbbbbbac
	val predictStr3 = stringClassifier.classify(exStr3)
                                                  //> predictStr3  : Boolean = true
	println("%s is classified as %b".format(exStr3, predictStr3))
                                                  //> cbbbbbbbbac is classified as true
  //------ Boolean classifier tests ----------//
  
  // Build a very simple classifier for BooleanFeatures. False is -1.0, True is 1.0
  val testWeights2 = Array[Double](-1.0, 1.0)     //> testWeights2  : Array[Double] = Array(-1.0, 1.0)
  
  // Classify some Strings
  val booleanClassifier = new LinearClassifier4[List[Boolean]](testWeights2)
                                                  //> booleanClassifier  : lab.typestudy2.TypeClass_lab_2.LinearClassifier4[List[
                                                  //| Boolean]] = lab.typestudy2.TypeClass_lab_2$LinearClassifier4@50f8963c
  // negative-weight 'false', should be classified as false
  val exBool1 = List(false, false, false, false)  //> exBool1  : List[Boolean] = List(false, false, false, false)
  val predictBool1 = booleanClassifier.classify(exBool1)
                                                  //> predictBool1  : Boolean = false
  println("%s is classified as %b".format(exBool1, predictBool1))
                                                  //> List(false, false, false, false) is classified as false
  val exBool2 = List(false, true, false, true)    //> exBool2  : List[Boolean] = List(false, true, false, true)
  val predictBool2 = booleanClassifier.classify(exBool2)
                                                  //> predictBool2  : Boolean = false
  println("%s is classified as %b".format(exBool2, predictBool2))
                                                  //> List(false, true, false, true) is classified as false
  
  val exBool3 = List(false, true, true)           //> exBool3  : List[Boolean] = List(false, true, true)
  val predictBool3 = booleanClassifier.classify(exBool3)
                                                  //> predictBool3  : Boolean = true
  println("%s is classified as %b".format(exBool3, predictBool3))
                                                  //> List(false, true, true) is classified as true
}
/*




*/