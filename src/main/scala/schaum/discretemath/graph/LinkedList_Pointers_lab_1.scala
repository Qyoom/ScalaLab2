package schaum.discretemath.graph

object LinkedList_Pointers_lab_1 {
  
	// Exercise: Implement linked list mechanism for customers
	// Data index starts at 1 instead of 0, hense the -1 for indexing.

	class Customer(val name: String, salesperson: Int, next: Int) {
		def list: List[Customer] = {
			if(next-1 <= 0) this :: Nil
	    		else this :: customers(next-1).list
	  	}
		def salesRep: SalesPerson = salespeople(salesperson-1)
	}
	object Customer {
		def apply(name: String, salesperson: Int, next: Int) = new Customer(name, salesperson, next)
	}
	
	class SalesPerson(val name: String, custPtr: Int) {
		def customers = {
			LinkedList_Pointers_lab_1.customers(custPtr-1).list
		}
	}
	object SalesPerson {
		def apply(name: String, headPtr: Int) = new SalesPerson(name, headPtr)
	}
	
	// ------------------------ //
	
	val salespeople = List(
		SalesPerson("Jones", 4),
		SalesPerson("Ray", 2),
		SalesPerson("Smith", 1)
	)
	
	val customers = List(
		Customer("Adams", 3, 5),
		Customer("Brown", 2, 3),
		Customer("Clark", 2, 7),
		Customer("Drew", 1, 6),
		Customer("Evans", 3, 8),
		Customer("Farmer", 1, 0),
		Customer("Geller", 2, 9),
		Customer("Hill", 3, 0),
		Customer("Infeld", 2, 0)
	)
}
/*




*/