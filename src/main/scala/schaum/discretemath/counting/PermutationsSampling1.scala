package schaum.discretemath.counting

object PermutationsSampling1 extends App {

    // Only difference is decrement of setSize
    
    def withoutReplacement(setSize: Int, sampleSize: Int): Int = {
        // recursion
        def inner(setSize: Int, sampleSize: Int, permAcc: Int): Int = {
	        if (sampleSize >= 1) {
	            inner(setSize - 1, sampleSize - 1, setSize * permAcc)
	        }
	        else permAcc
        }
        inner(setSize, sampleSize, 1)
    }
    
    def withReplacement(setSize: Int, sampleSize: Int): Int = {
        // recursion
        def inner(setSize: Int, sampleSize: Int, permAcc: Int): Int = {
	        if (sampleSize >= 1) {
	            inner(setSize, sampleSize - 1, setSize * permAcc)
	        }
	        else permAcc
        }
        inner(setSize, sampleSize, 1)
    }
    
    println(withoutReplacement(52, 3)) // should be 132600
    println(withReplacement(52, 3)) // should be 140608
    println(withoutReplacement(4, 3)) // 24 = 4 * 3 * 2
    println(withReplacement(4, 3)) // 64 = 4 * 4 * 4
}