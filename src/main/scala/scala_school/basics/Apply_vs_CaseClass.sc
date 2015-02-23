package scala_school.basics

object Apply_vs_CaseClass {

	// Construction using apply in companion object
	class Customer_type_1(name: String, salesman: Int, next: Int)
	object Customer_type_1{
		def apply(name: String, salesman: Int, next: Int)
			= new Customer_type_1(name, salesman, next)
	}
	
	Customer_type_1("Bob", 1, -1)             //> res0: scala_school.basics.Apply_vs_CaseClass.Customer_type_1 = scala_school.
                                                  //| basics.Apply_vs_CaseClass$Customer_type_1@769165fa
 	// Construction using implicit apply in case class
 	
 	case class Customer_type_2(name: String, salesman: Int, next: Int)
 	
 	Customer_type_2("Bill", 1, -1)            //> res1: scala_school.basics.Apply_vs_CaseClass.Customer_type_2 = Customer_type
                                                  //| _2(Bill,1,-1)
}
/*



*/