package matrixlike

import scala.math._

object MatrixOps {
    
    // Matrix multiplication
    def matxProd(m1: List[List[Double]], m2: List[List[Double]]): List[List[Double]] = {
        //println("matxProd = m1 size: " + size(m1) + " m2 size: " + size(m2))
		for(m1row <- m1) yield
		for(m2col <- transpose(m2)) yield
		dotProd(m1row, m2col)
    }

    // http://en.wikipedia.org/wiki/Dot_product
    def dotProd(v1: List[Double], v2: List[Double]): Double = {
		require(v1.length == v2.length, "dotProduct - Lists must be of equal length. " + 
            "v1.length;" + v1.length + " v2.length:" + v2.length +
            "\nv1: " + v1 + " v2: " + v2)
        val zipped = v1 zip v2
        val dotProdRes = zipped map {tup: (Double, Double) => tup._1 * tup._2} reduceLeft(_ + _)
        dotProdRes
    }
    
    def elemWiseProd(v1: List[Double], v2: List[Double]): List[Double] = {
        require(v1.length == v2.length, "elemWiseProd - Lists must be of equal length. " + 
            "v1.length;" + v1.length + " v2.length:" + v2.length +
            "\nv1: " + v1 + " v2: " + v2)
        val zipped = v1 zip v2
        val elemWiseProdRes = zipped map {tup: (Double, Double) => tup._1 * tup._2}
        elemWiseProdRes
    }
  
    def transpose(m: List[List[Double]]): List[List[Double]] = { // Recursive
    	if(m.head.isEmpty) Nil // convergence condition
    	else {
		    val t_head: List[Double] = m.map(_ head) // forms a column made from the head of each row
		    val m_tails = m.map(_ tail) // forms a new matrix minus the former first column
		    val recurseTranspOfTails: List[List[Double]] = transpose(m_tails)
		    t_head :: recurseTranspOfTails // cons each new transposed "column" onto a new Matrix
		}
    }
    
    def diff(v1: List[Double], v2: List[Double]): List[Double] = {
	  	require(v1.length == v2.length, "diff - inputs must be of equal length.")
	  	val zipped = v1 zip v2
	  	val difRes = zipped map { tup: (Double, Double) => tup._1 - tup._2 }
	  	difRes
    }
    
    def elemWisePow(v: List[Double], exp: Double): List[Double] = {
        v map (n => pow(n, exp))
    }
    
    def sumCols(m: List[List[Double]]): List[Double] = {
		if(m.head.isEmpty) Nil
		else {
			val col = m map(_ head)
			val otherCols = m map(_ tail)
			col.reduceRight(_+_) :: sumCols(otherCols) // recursive
		}
	}
  
	def sumRows(m: List[List[Double]]): List[Double] = {
		val rowSums = for{ // iterative
	  		i <- (0 to m.length - 1)
	  		rowSum = m(i).reduceRight(_+_)
		} yield rowSum
  	
		rowSums.toList
	}
	    
    def size(m: List[List[Double]]): (Double, Double) = {
        val rowCnt = m.length
        val colCnt = m.head.length
        (rowCnt, colCnt)
    }
    
    // convenience, transform List[] to List[List[]]
	def colVectToMatrix(list: List[Double]): List[List[Double]] = {
		list.map(d => List(d))
	}
	
	def rowVectToMatrix(list: List[Double]): List[List[Double]] = {
	    List(list)
	}
}
