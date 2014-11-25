package schaum.discretemath.counting

object BinomialTheorem extends App {
    
    // recursive
    // See p. 90 Schaum Discrete Mathematics
    def binomialCoeficients(n: Int, r: Int): Double = {
        def inner(n: Int, r: Int, n_acc: Int, r_acc: Int): Double = {
	        if (r >= 1) {
	            val new_n_acc = n_acc * n
	            val new_r_acc = r_acc * r
	            inner(n-1, r-1, new_n_acc, new_r_acc)
	        }
	        
	        else {
	            n_acc.toDouble / r_acc.toDouble
	        }
        }
        inner(n, r, 1, 1)
    } // end binomialCoeficients
    
    /********** inits ****************/
    
    val bn_10_7 = binomialCoeficients(10, 7)
    println("------> bn_10_7: " + bn_10_7)
    
    val bn_10_3 = binomialCoeficients(10, 3)
    println("------> bn_10_3: " + bn_10_3)
    
    val bn_12_8 = binomialCoeficients(12, 8)
    println("------> bn_12_8: " + bn_12_8)
    
    val bn_12_4 = binomialCoeficients(12, 4)
    println("------> bn_12_4: " + bn_12_4)
    
    val bn_13_8 = binomialCoeficients(13, 8)
    println("------> bn_13_8: " + bn_13_8)
    
    val bn_13_5 = binomialCoeficients(13, 5)
    println("------> bn_13_5: " + bn_13_5)
    
    val bn_6_3 = binomialCoeficients(6, 3)
    println("------> bn_6_3: " + bn_6_3)
    
    val bn_52_3 = binomialCoeficients(52, 3)
    println("------> bn_52_3: " + bn_52_3)
    
    val bn_4_3 = binomialCoeficients(4, 3)
    println("------> bn_4_3: " + bn_4_3)
}