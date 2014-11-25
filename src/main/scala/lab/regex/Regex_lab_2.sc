package lab.regex

object Regex_lab_2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	val projectIdRegEx = new scala.util.matching.Regex(
		"""/(projects)/([0-9]*)/""", "projectsLiteral", "projectId")
                                                  //> projectIdRegEx  : scala.util.matching.Regex = /(projects)/([0-9]*)/
		
	val userRequestPath = "/projects/11/languages/1/contents"
                                                  //> userRequestPath  : String = /projects/11/languages/1/contents
        
	val projectId = for (
		projectId <- projectIdRegEx findFirstMatchIn userRequestPath
	) yield projectId group "projectId"       //> projectId  : Option[String] = Some(11)
	
}