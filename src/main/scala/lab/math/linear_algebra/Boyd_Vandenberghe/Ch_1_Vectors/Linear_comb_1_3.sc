package lab.math.linear_algebra.Boyd_Vandenberghe.Ch_1_Vectors

import breeze.linalg._
import lab.math.vectorspace.EuclideanLabBreeze2._
import scala.math._

object Linear_comb_1_3 {

  // Best solution (function) at the bottom...

  // Unit combination ///////////////////////

  val b = DenseVector(-1d, 3, 5) // scalars       //> b  : breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  
  val unit = DenseMatrix.eye[Double](b.length)    //> unit  : breeze.linalg.DenseMatrix[Double] = 1.0  0.0  0.0  
                                                  //| 0.0  1.0  0.0  
                                                  //| 0.0  0.0  1.0  
  
  
  val lincomb = for{
    i <- 0 until b.length
  } yield {
    unit(::,i) :* b(i) // unit col vec * scalar   //> Dec 27, 2016 3:35:33 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader7328700856081318870netlib-native_system-osx-x86_64.jnilib
                                                  //| lincomb  : scala.collection.immutable.IndexedSeq[breeze.linalg.DenseVector[D
                                                  //| ouble]] = Vector(DenseVector(-1.0, -0.0, -0.0), DenseVector(0.0, 3.0, 0.0), 
                                                  //| DenseVector(0.0, 0.0, 5.0))
  }
  
  for(v <- lincomb) println(v)                    //> DenseVector(-1.0, -0.0, -0.0)
                                                  //| DenseVector(0.0, 3.0, 0.0)
                                                  //| DenseVector(0.0, 0.0, 5.0)
  
  lincomb.foldRight(DenseVector.zeros[Double](b.length))((a,b) => a :+ b) // summation
                                                  //> res0: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  // Look how much simpler this is. Good for comparison.
  // HOLD ON! You don't know that this is universal or how it works!
  unit * b                                        //> res1: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  unit.t * b                                      //> res2: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  
  // Another version. This appears to be the most accurate and idiomatic to Breeze.
  
  val prod1 = unit(::,*) :* b                     //> prod1  : breeze.linalg.DenseMatrix[Double] = -1.0  -0.0  -0.0  
                                                  //| 0.0   3.0   0.0   
                                                  //| 0.0   0.0   5.0   
  
  sum(prod1(*,::)) // col vector result           //> res3: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
    
  // Sum of vectors (via identity combination) ///////////
  
  val vecs1 = DenseMatrix((1,2,3), (4,5,6)).mapValues(_.toDouble)
                                                  //> vecs1  : breeze.linalg.DenseMatrix[Double] = 1.0  2.0  3.0  
                                                  //| 4.0  5.0  6.0  
  vecs1.cols                                      //> res4: Int = 3
  
  val b2 = DenseVector.ones[Int](vecs1.cols).mapValues(_.toDouble)
                                                  //> b2  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 1.0, 1.0)
  
  val lincomb2 = for{
    i <- 0 until vecs1.cols
  } yield {
    vecs1(::,i) :* b2(i) // unit col vec * scalar //> lincomb2  : scala.collection.immutable.IndexedSeq[breeze.linalg.DenseVector
                                                  //| [Double]] = Vector(DenseVector(1.0, 4.0), DenseVector(2.0, 5.0), DenseVecto
                                                  //| r(3.0, 6.0))
  }
  
  lincomb2.reduceRight(_+_)                       //> res5: breeze.linalg.DenseVector[Double] = DenseVector(6.0, 15.0)

  // Another attempt. Again, this seems to be the most accurate and ideomatic to Breeze so far...
  
  val prod2 = vecs1(::,*) :* b2 // This is correct. It's goofy because it causes no change.
                                                  //> prod2  : breeze.linalg.DenseMatrix[Double] = 1.0  2.0  3.0  
                                                  //| 4.0  5.0  6.0  
  sum(prod2(*,::))                                //> res6: breeze.linalg.DenseVector[Double] = DenseVector(6.0, 15.0)
  
  // Average of the vectors /////////////////////
  
  // Using vecs1 for example
  val b3 = DenseVector.ones[Double](vecs1.cols) :* (1d / vecs1.cols)
                                                  //> b3  : breeze.linalg.DenseVector[Double] = DenseVector(0.3333333333333333, 0
                                                  //| .3333333333333333, 0.3333333333333333)
  
  
  // Affine combination ////////////////////////
  
  // Generate random distribution with all positive values.
  def genRandomDist(n: Int): DenseVector[Double] = {
    val raw = for(r <- 0 until n) yield random
    val rawVec = DenseVector(raw.toArray)
    val sumRaw = sum(rawVec)
    val dist = rawVec :* (1/sumRaw)
    dist
  }                                               //> genRandomDist: (n: Int)breeze.linalg.DenseVector[Double]
  
  val b4 = genRandomDist(vecs1.cols)              //> b4  : breeze.linalg.DenseVector[Double] = DenseVector(0.5126496190129325, 0
                                                  //| .34531431353386743, 0.14203606745320013)
  sum(b4)                                         //> res7: Double = 1.0
  
  val randGen = new scala.util.Random             //> randGen  : scala.util.Random = scala.util.Random@4d5dd716
  // Generates vector of random pos or neg ones (1 or -1).
  def randPosNeg(n: Int): DenseVector[Double] = {
    val seq = for(i <- 0 until n) yield {
      if(randGen.nextBoolean) 1d else -1d
    }
    DenseVector(seq.toArray)
  }                                               //> randPosNeg: (n: Int)breeze.linalg.DenseVector[Double]
  
  // Generate random distribution with both positive and negative values
  def genRandomDistAlt(n: Int): DenseVector[Double] = {
    val raw = for(r <- 0 until n) yield random
    val randNeg = randPosNeg(n) // vector of random pos or neg ones (1 or -1)
    val rawVec = DenseVector(raw.toArray) :* randNeg
    val sumRaw = sum(rawVec)
    val dist = rawVec :* (1/sumRaw)
    dist
  }                                               //> genRandomDistAlt: (n: Int)breeze.linalg.DenseVector[Double]
  
  val b5 = genRandomDistAlt(vecs1.cols)           //> b5  : breeze.linalg.DenseVector[Double] = DenseVector(0.5694413054978842, 0
                                                  //| .5019539692382256, -0.07139527473610974)
  sum(b5)                                         //> res8: Double = 1.0
  
  // Here's the function with the concise soulution /////////////////
  
  def linearComb(mat: DenseMatrix[Double], vec: DenseVector[Double]): DenseVector[Double] = {
    val prod = mat(::,*) :* vec
    sum(prod(*,::))
  }                                               //> linearComb: (mat: breeze.linalg.DenseMatrix[Double], vec: breeze.linalg.Den
                                                  //| seVector[Double])breeze.linalg.DenseVector[Double]
  
  // Different sum syntax
  def linearCombAlt(mat: DenseMatrix[Double], vec: DenseVector[Double]): DenseVector[Double] = {
    val prod = mat(::,*) :* vec
    sum(prod, Axis._1)
  }                                               //> linearCombAlt: (mat: breeze.linalg.DenseMatrix[Double], vec: breeze.linalg.
                                                  //| DenseVector[Double])breeze.linalg.DenseVector[Double]
  
  // Test examples ////////////////////////////
  linearComb(unit, b) // Unit identity vectors    //> res9: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  linearCombAlt(unit, b) // alternative internal syntax
                                                  //> res10: breeze.linalg.DenseVector[Double] = DenseVector(-1.0, 3.0, 5.0)
  linearComb(vecs1, b2) // Sum vectors            //> res11: breeze.linalg.DenseVector[Double] = DenseVector(6.0, 15.0)
  linearComb(vecs1, b3) // Avgerage of vectors    //> res12: breeze.linalg.DenseVector[Double] = DenseVector(2.0, 5.0)
  linearComb(vecs1, b4) // Affine combination all positive coeficients
                                                  //> res13: breeze.linalg.DenseVector[Double] = DenseVector(3.0758977140775947, 
                                                  //| 5.1797147030080115)
  linearComb(vecs1, b5) // Affine with possible negative coeficients
                                                  //> res14: breeze.linalg.DenseVector[Double] = DenseVector(3.416647832987305, 7
                                                  //| .529309538573384)
  
  '''                                             //> res15: Char('\'') = '
}
/*




*/