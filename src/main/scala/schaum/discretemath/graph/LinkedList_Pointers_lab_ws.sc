package schaum.discretemath.graph

import schaum.discretemath.graph.LinkedList_Pointers_lab_1._

object LinkedList_Pointers_lab_ws {
		
	salespeople.foreach(s => {
		println("\n" + s.name + " customers:")
		s.customers.foreach(c => println(c.name))
	})                                        //> 
                                                  //| Jones customers:
                                                  //| Drew
                                                  //| Farmer
                                                  //| 
                                                  //| Ray customers:
                                                  //| Brown
                                                  //| Clark
                                                  //| Geller
                                                  //| Infeld
                                                  //| 
                                                  //| Smith customers:
                                                  //| Adams
                                                  //| Evans
                                                  //| Hill
  
  println("Customer's reps:")                     //> Customer's reps:
  customers.foreach(c => println(c.name + ": " + c.salesRep.name))
                                                  //> Adams: Smith
                                                  //| Brown: Ray
                                                  //| Clark: Ray
                                                  //| Drew: Jones
                                                  //| Evans: Smith
                                                  //| Farmer: Jones
                                                  //| Geller: Ray
                                                  //| Hill: Smith
                                                  //| Infeld: Ray
		
		

}
/*


 
*/