package lab.option

object Option_lab_2 {
	// I'm not able to get this to work
	// Trying to pass null or none to function with typed parameter
  type T = Any
  val needsOptionParam: (Option[T], Int) => String = {
  		case (Some(t), i) => s"Got $t and $i"
  		case (None, i) => s"Got None and $i"
  }                                               //> needsOptionParam  : (Option[lab.option.Option_lab_2.T], Int) => String = <fu
                                                  //| nction2>
  
  needsOptionParam(Option(6), 15)                 //> res0: String = Got 6 and 15
  needsOptionParam(None, 14)                      //> res1: String = Got None and 14
  
  def translateToOption[T](func: T => Option[T]) {
  }                                               //> translateToOption: [T](func: T => Option[T])Unit
  
  val tryThis = (x:T, i:Int) => {
  		needsOptionParam(Option(x), i)
  	}                                         //> tryThis  : (lab.option.Option_lab_2.T, Int) => String = <function2>
  	
  tryThis(6, 5)                                   //> res2: String = Got 6 and 5
  tryThis(None, 7)                                //> res3: String = Got None and 7
  tryThis(null, 8)                                //> res4: String = Got None and 8
}