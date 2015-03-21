package misc
 
object val_lab {
	// val (Q1, Q2) = (1, 2) // Error
	val Q = (1, 2)                            //> Q  : (Int, Int) = (1,2)
	Q._1                                      //> res0: Int = 1
	Q._2                                      //> res1: Int = 2
}