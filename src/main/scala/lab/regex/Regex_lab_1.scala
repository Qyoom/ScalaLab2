package lab.regex

object Regex_lab_1 extends App {
    
	val projectIdRegEx = new scala.util.matching.Regex(
	        """/(projects)/([0-9]*)/""", "projectsLiteral", "projectId"
        )
	
	def getProjectId(text: String): Option[String] = {
	    for (m <- projectIdRegEx findFirstMatchIn text) yield m group "projectId"
	}
	
	val result2 = getProjectId("/projects/11/languages/1/contents") match {
	    case Some(projectId) => projectId
	    case None => "No projectId found..."
	}
	
	println("projectId: " + result2)
	
	
}