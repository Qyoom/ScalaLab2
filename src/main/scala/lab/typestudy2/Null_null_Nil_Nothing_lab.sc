package lab.typestudy2

object Null_null_Nil_Nothing_lab {
	if(true) 1 else false                     //> res0: AnyVal = 1
	if(true) 1 else "false"                   //> res1: Any = 1
	if(true) 1 else null                      //> res2: Any = 1
	if(true) 1 else ()                        //> res3: AnyVal = 1
	if(true) 1 else Nil                       //> res4: Any = 1
	
	val a = Nil                               //> a  : scala.collection.immutable.Nil.type = List()
	val b = null                              //> b  : Null = null
	val c = ()                                //> c  : Unit = ()
}