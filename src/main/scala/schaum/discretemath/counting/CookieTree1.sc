package schaum.discretemath.counting
import schaum.discretemath.counting.BinomialTheorem._

object CookieTree1 {

  // 6.2 COMBINATIONS WITH REPETITIONS
  // M = 4 kinds of cookies. Find the number of ways a person can buy r = 8 of the cookies.
  // Formula: R + M − 1
  // 8 + 4 - 1 = 11
  // M =C(11,8)=C(11,3)
  // Theorem 6.1
  // C(r + M − 1, r) = C(r + M − 1, M − 1)
  // C(8 + 4 - 1, 8) = C(8 + 4 - 1, 4 - 1)
  binomialCoeficients(11, 8)                      //> res0: Double = 165.0
  binomialCoeficients(11, 3)                      //> res1: Double = 165.0
  
  val cookies = List("a", "b", "c", "d")          //> cookies  : List[String] = List(a, b, c, d)

  
  val result1: List[(String, String, String, String, String, String, String, String)] = for{
  		_1 <- cookies
  		_2 <- cookies
  		_3 <- cookies
  		_4 <- cookies
  		_5 <- cookies
  		_6 <- cookies
  		_7 <- cookies
  		_8 <- cookies
  } yield (_1, _2, _3, _4, _5, _6, _7, _8)        //> result1  : List[(String, String, String, String, String, String, String, Str
                                                  //| ing)] = List((a,a,a,a,a,a,a,a), (a,a,a,a,a,a,a,b), (a,a,a,a,a,a,a,c), (a,a,a
                                                  //| ,a,a,a,a,d), (a,a,a,a,a,a,b,a), (a,a,a,a,a,a,b,b), (a,a,a,a,a,a,b,c), (a,a,a
                                                  //| ,a,a,a,b,d), (a,a,a,a,a,a,c,a), (a,a,a,a,a,a,c,b), (a,a,a,a,a,a,c,c), (a,a,a
                                                  //| ,a,a,a,c,d), (a,a,a,a,a,a,d,a), (a,a,a,a,a,a,d,b), (a,a,a,a,a,a,d,c), (a,a,a
                                                  //| ,a,a,a,d,d), (a,a,a,a,a,b,a,a), (a,a,a,a,a,b,a,b), (a,a,a,a,a,b,a,c), (a,a,a
                                                  //| ,a,a,b,a,d), (a,a,a,a,a,b,b,a), (a,a,a,a,a,b,b,b), (a,a,a,a,a,b,b,c), (a,a,a
                                                  //| ,a,a,b,b,d), (a,a,a,a,a,b,c,a), (a,a,a,a,a,b,c,b), (a,a,a,a,a,b,c,c), (a,a,a
                                                  //| ,a,a,b,c,d), (a,a,a,a,a,b,d,a), (a,a,a,a,a,b,d,b), (a,a,a,a,a,b,d,c), (a,a,a
                                                  //| ,a,a,b,d,d), (a,a,a,a,a,c,a,a), (a,a,a,a,a,c,a,b), (a,a,a,a,a,c,a,c), (a,a,a
                                                  //| ,a,a,c,a,d), (a,a,a,a,a,c,b,a), (a,a,a,a,a,c,b,b), (a,a,a,a,a,c,b,c), (a,a,a
                                                  //| ,a,a,c,b,d), (a,a,a,a,a,c,c,a), (a,a,a,a,a,c,c,b), (a,a,a,a,a,c,c,c), (a,a,a
                                                  //| ,a,a,c,c,d), (a,a,a,a,a,
                                                  //| Output exceeds cutoff limit.
  
  val result1Set = result1.toSet                  //> result1Set  : scala.collection.immutable.Set[(String, String, String, String
                                                  //| , String, String, String, String)] = Set((a,b,a,d,b,d,a,d), (b,c,a,d,b,c,b,b
                                                  //| ), (d,a,d,c,a,c,d,c), (b,c,a,b,b,c,d,c), (b,b,b,a,b,b,a,a), (a,c,a,b,a,d,d,b
                                                  //| ), (d,b,c,c,a,a,c,a), (c,a,b,c,d,b,a,d), (a,a,b,c,a,c,d,d), (c,c,d,b,d,c,b,d
                                                  //| ), (a,d,c,c,c,a,a,a), (a,d,b,a,c,a,c,c), (b,a,d,a,d,d,b,d), (d,a,a,d,c,d,c,a
                                                  //| ), (c,b,a,d,d,b,b,d), (c,d,a,b,a,c,b,a), (a,d,d,d,b,b,b,b), (d,a,b,c,b,d,a,d
                                                  //| ), (b,b,a,a,c,a,a,c), (c,a,b,c,a,a,b,d), (d,b,d,b,a,b,b,a), (c,b,d,b,b,a,c,b
                                                  //| ), (a,a,c,a,a,c,a,c), (b,a,b,a,c,d,b,a), (c,c,d,d,d,a,d,d), (b,a,b,b,d,a,d,a
                                                  //| ), (d,a,b,b,b,a,d,c), (c,a,d,a,d,d,a,c), (b,c,b,a,d,d,c,a), (b,c,d,a,c,d,b,b
                                                  //| ), (b,c,d,c,c,a,b,b), (d,a,a,b,d,a,a,a), (a,a,a,a,a,d,d,c), (c,d,c,d,b,b,c,a
                                                  //| ), (c,d,b,a,c,b,b,b), (c,a,c,b,d,a,d,d), (d,c,c,c,d,d,c,b), (d,c,b,c,b,b,a,d
                                                  //| ), (d,a,a,a,a,b,c,a), (b,a,a,d,c,b,d,a), (a,a,a,a,a,a,b,b), (b,a,b,a,a,c,c,d
                                                  //| ), (c,c,d,c,c,c,a,d), (c
                                                  //| Output exceeds cutoff limit.
  result1Set.size                                 //> res2: Int = 65536
  
  result1.size                                    //> res3: Int = 65536
}