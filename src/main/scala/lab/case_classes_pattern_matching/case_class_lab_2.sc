package lab.case_classes_pattern_matching

object case_class_lab_2 {
  
  abstract class Expr
  	case class Var(name: String) extends Expr
  	case class Number(num: Double) extends Expr
  	case class UnOp(operator: String, arg: Expr) extends Expr
  	case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  	
  	val x = Var("x")                          //> x  : lab.case_classes_pattern_matching.case_class_lab_2.Var = Var(x)
	val opAdd = BinOp("+", Number(1), x)      //> opAdd  : lab.case_classes_pattern_matching.case_class_lab_2.BinOp = BinOp(+,
                                                  //| Number(1.0),Var(x))
	// fields
	x.name                                    //> res0: String = x
	opAdd.left                                //> res1: lab.case_classes_pattern_matching.case_class_lab_2.Expr = Number(1.0)
	println(opAdd)                            //> BinOp(+,Number(1.0),Var(x))
	opAdd.right == Var("x")                   //> res2: Boolean = true
	opAdd.right == Var("z")                   //> res3: Boolean = false
	
	// copy function
	val opSubtract = opAdd.copy(operator = "-")
                                                  //> opSubtract  : lab.case_classes_pattern_matching.case_class_lab_2.BinOp = Bin
                                                  //| Op(-,Number(1.0),Var(x))

	// Pattern matching
	def identity(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
		case BinOp("+", e, Number(0)) => e
		case BinOp("*", e, Number(1)) => e
		case _ => expr
	}                                         //> identity: (expr: lab.case_classes_pattern_matching.case_class_lab_2.Expr)lab
                                                  //| .case_classes_pattern_matching.case_class_lab_2.Expr
	
	val var_x = UnOp("-", UnOp("-", x))       //> var_x  : lab.case_classes_pattern_matching.case_class_lab_2.UnOp = UnOp(-,Un
                                                  //| Op(-,Var(x)))
  identity(var_x) == Var("x")                     //> res4: Boolean = true
  
  def typeCheck(e: Expr) = e match {
  		case UnOp(op, _) => println("got UnOp with " + op + " operator.")
  		case BinOp(op, left, right) => println("got BinOp with " + op + " operator.")
  		case Number(num) => println("got number: " + num)
  		case _ => println("something else")
  }                                               //> typeCheck: (e: lab.case_classes_pattern_matching.case_class_lab_2.Expr)Unit
                                                  //| 
  
  typeCheck(var_x)                                //> got UnOp with - operator.
  typeCheck(Number(7))                            //> got number: 7.0
  
  // Deconstruction. You can use a pattern instead of a simple identifier.
  
  val exp = new BinOp("*", Number(5), Number(1))  //> exp  : lab.case_classes_pattern_matching.case_class_lab_2.BinOp = BinOp(*,N
                                                  //| umber(5.0),Number(1.0))
  val BinOp(op, left, right) = exp                //> op  : String = *
                                                  //| left  : lab.case_classes_pattern_matching.case_class_lab_2.Expr = Number(5.
                                                  //| 0)
                                                  //| right  : lab.case_classes_pattern_matching.case_class_lab_2.Expr = Number(1
                                                  //| .0)
  op                                              //> res5: String = *
  left                                            //> res6: lab.case_classes_pattern_matching.case_class_lab_2.Expr = Number(5.0)
                                                  //| 
  right                                           //> res7: lab.case_classes_pattern_matching.case_class_lab_2.Expr = Number(1.0)
                                                  //| 
  
  // Constants
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }                                               //> describe: (x: Any)String
  
  describe(5)                                     //> res8: String = five
  describe(true)                                  //> res9: String = truth
  describe("hello")                               //> res10: String = hi!
  describe(List())                                //> res11: String = the empty list
  describe(Var("x"))                              //> res12: String = something else
  
  // Variable pattern
  def variable(v: Any) {
  		v match {
      case 0 => println("zero")
      case somethingElse => println("not zero: "+ somethingElse)
		}
	}                                         //> variable: (v: Any)Unit
	
	variable(0)                               //> zero
	variable(Var("x"))                        //> not zero: Var(x)
	
	import math.{E, Pi}
	E match {
     case Pi => "strange math? Pi = "+ Pi
     case e => "Not Pi! I'm " + e
	}                                         //> res13: String = Not Pi! I'm 2.718281828459045
	
	val pi = math.Pi                          //> pi  : Double = 3.141592653589793
	E match {
		case pi => "Pi is: " + pi // Here, pi is a variable since it's lower case.
		case _ => "something else"
	}                                         //> res14: String = Pi is: 2.718281828459045
	
	E match {
		case `pi` => "Pi is: " + pi // back-tics make pi refer to the constant.
		case _ => "something else"
	}                                         //> res15: String = something else
	
	// Option
	
	val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "Iowa" -> "Des Moines")
                                                  //> capitals  : scala.collection.immutable.Map[String,String] = Map(France -> P
                                                  //| aris, Japan -> Tokyo, Iowa -> Des Moines)
	
	capitals get "Iowa"                       //> res16: Option[String] = Some(Des Moines)
	capitals get "Romainia"                   //> res17: Option[String] = None
	
	def show(x: Option[String]) = x match {
		case Some(s) => s
		case None => "?"
	}                                         //> show: (x: Option[String])String
	
	show(capitals get "France")               //> res18: String = Paris
	show(capitals get "Portugal")             //> res19: String = ?
	
	// Case sequences as partial functions
	/* A sequence of cases (i.e., alternatives) in curly braces can
	 * be used anywhere a function literal can be used. Essentially,
	 * a case sequence is a function literal, only more general.
	 * Instead of having a single entry point and list of parameters,
	 * a case sequence has multiple entry points, each having its own
	 * list of parameters. Each case is an entry point to the function,
	 * and the parameters are specified with the pattern. The body of
	 * each entry point is the right-hand side of the case.
	 */
	
	// Notice no match operator...
	val withDefault: Option[Int] => Int = {
	  case Some(x) => x
	  case None => 0
	}                                         //> withDefault  : Option[Int] => Int = <function1>
	
	withDefault(Some(10))                     //> res20: Int = 10
	withDefault(None)                         //> res21: Int = 0
	
	// Patterns in for expressions
	
	for ((country, city) <- capitals)
     println("The capital of "+ country +" is "+ city)
                                                  //> The capital of France is Paris
                                                  //| The capital of Japan is Tokyo
                                                  //| The capital of Iowa is Des Moines
  val results = List(Some("apple"), None, Some("orange"))
                                                  //> results  : List[Option[String]] = List(Some(apple), None, Some(orange))
  // Picking elements of a list that match a pattern
  for (Some(fruit) <- results) println(fruit)     //> apple
                                                  //| orange
}