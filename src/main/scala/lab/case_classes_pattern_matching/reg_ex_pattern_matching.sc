package lab.case_classes_pattern_matching

object reg_ex_pattern_matching {
  
  // Regular Expressions with only one groups
	val Yes = "(y|Y)es".r                     //> Yes  : scala.util.matching.Regex = (y|Y)es
	Yes.pattern.matcher("yes").matches        //> res0: Boolean = true
	// Yes.unapplySeq("yes") will // result: Option[List[String]] = Some(List(y))
	
	def catchYes(s:String) = s match {
    case Yes(x) => s
    case _ => None
	}                                         //> catchYes: (s: String)java.io.Serializable

	catchYes("yes")                           //> res1: java.io.Serializable = yes
	catchYes("Yes")                           //> res2: java.io.Serializable = Yes
	
	// Regular Expressions with multiple groups
	val YesMultiGroup = "(y|Y)(es)".r         //> YesMultiGroup  : scala.util.matching.Regex = (y|Y)(es)

	// Checking regex works
	Yes.pattern.matcher("yes").matches        //> res3: Boolean = true
	//Yes.unapplySeq("yes") will result: Option[List[String]] = Some(List(y, es))
	
	def catchYesMultiGroup(s:String) = s match {
    // As regex has two groups we should have enough parameter to extract
    case Yes(x,y) => s
    case _ => None
	}                                         //> catchYesMultiGroup: (s: String)java.io.Serializable
	
	catchYesMultiGroup("yes")                 //> res4: java.io.Serializable = None
	catchYesMultiGroup("Yes")                 //> res5: java.io.Serializable = None
}