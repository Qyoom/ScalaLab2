package misc

object ListLab1 {
	val theta = List(List(1.0), List(2.0))    //> theta  : List[List[Double]] = List(List(1.0), List(2.0))
	
	theta(0)(0)                               //> res0: Double = 1.0
	theta(1)(0)                               //> res1: Double = 2.0
	
	val l1 = List(1,2,3,4)                    //> l1  : List[Int] = List(1, 2, 3, 4)
	l1.+:(5)                                  //> res2: List[Int] = List(5, 1, 2, 3, 4)
	5 :: l1                                   //> res3: List[Int] = List(5, 1, 2, 3, 4)
	l1.:::(List(5))                           //> res4: List[Int] = List(5, 1, 2, 3, 4)
	l1.++(List(5))                            //> res5: List[Int] = List(1, 2, 3, 4, 5)
	l1 ++ List(5)                             //> res6: List[Int] = List(1, 2, 3, 4, 5)
	l1.reverse                                //> res7: List[Int] = List(4, 3, 2, 1)
	
	val l2 = List(1.0)                        //> l2  : List[Double] = List(1.0)
	l2(0)                                     //> res8: Double = 1.0
	
}