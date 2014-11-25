package lab.controlstrucs

object RecurseMap_lab2 {
  
  val row2 = List(10,20,30,40)                    //> row2  : List[Int] = List(10, 20, 30, 40)
  val row3 = List(5,6,7,8)                        //> row3  : List[Int] = List(5, 6, 7, 8)
  val row4 = List(1,2,3,4)                        //> row4  : List[Int] = List(1, 2, 3, 4)
  
  val matrix1 = List(row2, row3, row4)            //> matrix1  : List[List[Int]] = List(List(10, 20, 30, 40), List(5, 6, 7, 8), Li
                                                  //| st(1, 2, 3, 4))
  
  val thetaVect = List(20,30,40,50)               //> thetaVect  : List[Int] = List(20, 30, 40, 50)
  val theta = thetaVect.map(d => List(d))         //> theta  : List[List[Int]] = List(List(20), List(30), List(40), List(50))
  
  def iter(m: List[List[Int]], theta: List[List[Int]]) {
  	println("iter TOP")
  	if(!m.isEmpty) {
  		val x = m.head
  		val t = theta.flatten
  		x zip t
  		for ((x, t) <- (x zip t)) yield println("x:" + x + " theta:" + t)
  		iter(m.tail, theta)
  	}
  }                                               //> iter: (m: List[List[Int]], theta: List[List[Int]])Unit
  
  iter(matrix1, theta)                            //> iter TOP
                                                  //| x:10 theta:20
                                                  //| x:20 theta:30
                                                  //| x:30 theta:40
                                                  //| x:40 theta:50
                                                  //| iter TOP
                                                  //| x:5 theta:20
                                                  //| x:6 theta:30
                                                  //| x:7 theta:40
                                                  //| x:8 theta:50
                                                  //| iter TOP
                                                  //| x:1 theta:20
                                                  //| x:2 theta:30
                                                  //| x:3 theta:40
                                                  //| x:4 theta:50
                                                  //| iter TOP
  
  //----------------------------------------//
  
  val betaVect = List(65,75,85,95)                //> betaVect  : List[Int] = List(65, 75, 85, 95)
  val beta = betaVect.map(d => List(d))           //> beta  : List[List[Int]] = List(List(65), List(75), List(85), List(95))
  
  def iter2(m: List[List[Int]], theta: List[List[Int]], beta: List[List[Int]]) {
  	println("iter2 TOP")
  	if(!m.isEmpty) {
  		val x = m.head
  		val t = theta.flatten
  		val b = beta.flatten
  		val agg = List(x,t,b).transpose
  		println("agg: " + agg(0))
  		iter2(m.tail, theta, beta)
  	}
  }                                               //> iter2: (m: List[List[Int]], theta: List[List[Int]], beta: List[List[Int]])Un
                                                  //| it
  
  iter2(matrix1, theta, beta)                     //> iter2 TOP
                                                  //| agg: List(10, 20, 65)
                                                  //| iter2 TOP
                                                  //| agg: List(5, 20, 65)
                                                  //| iter2 TOP
                                                  //| agg: List(1, 20, 65)
                                                  //| iter2 TOP
  
  
}