package courses.ut.laff

import breeze.linalg._
import breeze.numerics._
import lab.math.vectorspace.EuclideanLabBreeze2._

object Week_1_1_ws {
	// val v = DenseVector()
	
	val v1 = DenseVector(1,-1,2)              //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
	val v2 = DenseVector(0,0,0)               //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
	val v3 = DenseVector(1,1,-2)              //> v3  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, -2)
	val v4 = DenseVector(0,2,-4)              //> v4  : breeze.linalg.DenseVector[Int] = DenseVector(0, 2, -4)
	
	val v5 = v1 - v2                          //> v5  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
	val v6 = v3 - v4                          //> v6  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
	v5 == v6                                  //> res0: Boolean = true
	
	val v7 = DenseVector(4,-3)                //> v7  : breeze.linalg.DenseVector[Int] = DenseVector(4, -3)
	val v8 = DenseVector(1,5)                 //> v8  : breeze.linalg.DenseVector[Int] = DenseVector(1, 5)
	v7 + v8                                   //> res1: breeze.linalg.DenseVector[Int] = DenseVector(5, 2)
	
	val v9 = DenseVector(-1,2)                //> v9  : breeze.linalg.DenseVector[Int] = DenseVector(-1, 2)
	val v10 = DenseVector(-3,-2)              //> v10  : breeze.linalg.DenseVector[Int] = DenseVector(-3, -2)
	v9 + v10                                  //> res2: breeze.linalg.DenseVector[Int] = DenseVector(-4, 0)
	
	val v11 = DenseVector[Int](0,0)           //> v11  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0)
	v11 := v10                                //> res3: breeze.linalg.DenseVector[Int] = DenseVector(-3, -2)
	v10 :*= 2                                 //> res4: breeze.linalg.DenseVector[Int] = DenseVector(-6, -4)
	v10                                       //> res5: breeze.linalg.DenseVector[Int] = DenseVector(-6, -4)
	v11                                       //> res6: breeze.linalg.DenseVector[Int] = DenseVector(-3, -2)
	
	val v12 = DenseVector(2,4,-1,0)           //> v12  : breeze.linalg.DenseVector[Int] = DenseVector(2, 4, -1, 0)
	val v13 = DenseVector(1,0,1,0)            //> v13  : breeze.linalg.DenseVector[Int] = DenseVector(1, 0, 1, 0)
	v12*3 + v13*2                             //> res7: breeze.linalg.DenseVector[Int] = DenseVector(8, 12, -1, 0)
	
	(v1 + v3) dot v4                          //> res8: Int = 0
	(v1 + v3)                                 //> res9: breeze.linalg.DenseVector[Int] = DenseVector(2, 0, 0)
	(v1 dot v4) + (v3 dot v4)                 //> res10: Int = 0
	
	(v1 + v3) dot (v1 + v3)                   //> res11: Int = 4
	(v1 dot v1) + (2*(v1 dot v3)) + (v3 dot v3)
                                                  //> res12: Int = 4
  val v14 = DenseVector(0,0,0)                    //> v14  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
  norm(v14)                                       //> res13: Double = 0.0
  val v15 = DenseVector(1d/2,1d/2,1d/2,1d/2)      //> v15  : breeze.linalg.DenseVector[Double] = DenseVector(0.5, 0.5, 0.5, 0.5)
  norm(v15)                                       //> res14: Double = 1.0
  sqrt(pow(v15, 2).sum)                           //> res15: Double = 1.0
  pow(1d/2, 2)                                    //> res16: Double = 0.25
  
  norm(DenseVector(3d,4))                         //> res17: Double = 5.0
  norm(DenseVector(0,0,0))                        //> res18: Double = 0.0
  norm(DenseVector(1d/2, 1d/2, 1d/2, 1d/2))       //> res19: Double = 1.0
  norm(DenseVector(1,-2,2))                       //> res20: Double = 3.0
  norm(DenseVector(0,0,1,0,0,0))                  //> res21: Double = 1.0
}