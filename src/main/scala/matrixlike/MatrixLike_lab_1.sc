package matrixlike

object MatrixLike_lab_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // dotProd takes two vectors and reduces the pair products to a single sum
 	def dotProd(v1: List[Double], v2: List[Double]): Double = {
    require(v1.length == v2.length, "dotProduct - Rows must be of equal length.")
    val zipped = v1 zip v2
    //println("zipped: " + zipped)
    val dotProdRes = zipped map {
    	tup: (Double, Double) => {
    		println("dotProd " + tup._1 + " * " + tup._2 + " = " + tup._1 * tup._2)
    		tup._1 * tup._2
			}
		} reduceLeft(_ + _) // reduce is summation of 2 cols (prod) by n rows to Double
		println("dotProdRes: " + dotProdRes)
    dotProdRes
  }                                               //> dotProd: (v1: List[Double], v2: List[Double])Double
  
  def transpose(m: List[List[Double]]): List[List[Double]] = { // Recursive
    if(m.head.isEmpty) Nil // convergence condition
    else {
	    val t_head: List[Double] = m.map(_ head) // forms a column made from the head of each row
	    val m_tails = m.map(_ tail) // forms a new matrix minus the former first column
	    val recurseTranspOfTails: List[List[Double]] = transpose(m_tails)
	    t_head :: recurseTranspOfTails // concatinate each new transposed "column" into a new List/Matrix
    }
	}                                         //> transpose: (m: List[List[Double]])List[List[Double]]
	
	def mXm(m1: List[List[Double]], m2: List[List[Double]]): List[List[Double]] = {
    for(m1row <- m1) yield
    for(m2col <- transpose(m2)) yield
    dotProd(m1row, m2col)
  }                                               //> mXm: (m1: List[List[Double]], m2: List[List[Double]])List[List[Double]]
  
  /********************************************************/
  
  val m1 = List(List(2.0,2.0), List(2.0,2.0), List(2.0,2.0), List(2.0,2.0))
                                                  //> m1  : List[List[Double]] = List(List(2.0, 2.0), List(2.0, 2.0), List(2.0, 2
                                                  //| .0), List(2.0, 2.0))
  val m2 = List(List(3.0,3.0,3.0), List(3.0,3.0,3.0))
                                                  //> m2  : List[List[Double]] = List(List(3.0, 3.0, 3.0), List(3.0, 3.0, 3.0))
  mXm(m1, m2)                                     //> dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 12.0
                                                  //| res0: List[List[Double]] = List(Lis
                                                  //| Output exceeds cutoff limit.
  
  mXm(List(List()), List(List()))                 //> res1: List[List[Double]] = List(List())
  
  dotProd(List(2), List(3))                       //> dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProdRes: 6.0
                                                  //| res2: Double = 6.0
  dotProd(List(2,4), List(3,5))                   //> dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 4.0 * 5.0 = 20.0
                                                  //| dotProdRes: 26.0
                                                  //| res3: Double = 26.0
  val l1 = List(2.0,4.0)                          //> l1  : List[Double] = List(2.0, 4.0)
  val l2 = List(3.0,5.0)                          //> l2  : List[Double] = List(3.0, 5.0)
  val m3 = List(l1)                               //> m3  : List[List[Double]] = List(List(2.0, 4.0))
  val m4 = List(l2)                               //> m4  : List[List[Double]] = List(List(3.0, 5.0))
  mXm(m3, m4.transpose)                           //> dotProd 2.0 * 3.0 = 6.0
                                                  //| dotProd 4.0 * 5.0 = 20.0
                                                  //| dotProdRes: 26.0
                                                  //| res4: List[List[Double]] = List(List(26.0))
}