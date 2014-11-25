package matrixlike

object SumCols_lab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val m1 = List(List(1.0,2.0,3.0), List(1.0,2.0,3.0), List(1.0,2.0,3.0), List(1.0,2.0,3.0))
                                                  //> m1  : List[List[Double]] = List(List(1.0, 2.0, 3.0), List(1.0, 2.0, 3.0), Li
                                                  //| st(1.0, 2.0, 3.0), List(1.0, 2.0, 3.0))
  
  def sumCols(m: List[List[Double]]): List[Double] = {
 	if(m.head.isEmpty) Nil
		else {
			val col = m map(_ head)
			val otherCols = m map(_ tail)
			col.reduceRight(_+_) :: sumCols(otherCols)
		}
  }                                               //> sumCols: (m: List[List[Double]])List[Double]
  
  def sumRows(m: List[List[Double]]): List[Double] = {
  	val rowSums = for{
  		i <- (0 to m.length - 1)
  		rowSum = m(i).reduceRight(_+_)
  	} yield rowSum
  	rowSums.toList
  }                                               //> sumRows: (m: List[List[Double]])List[Double]
  
  val m1T = m1.transpose                          //> m1T  : List[List[Double]] = List(List(1.0, 1.0, 1.0, 1.0), List(2.0, 2.0, 2.
                                                  //| 0, 2.0), List(3.0, 3.0, 3.0, 3.0))
  
  sumCols(m1)                                     //> res0: List[Double] = List(4.0, 8.0, 12.0)
  sumRows(m1)                                     //> res1: List[Double] = List(6.0, 6.0, 6.0, 6.0)
  sumRows(m1T)                                    //> res2: List[Double] = List(4.0, 8.0, 12.0)
}