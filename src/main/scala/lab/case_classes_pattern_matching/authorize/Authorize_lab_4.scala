package lab.case_classes_pattern_matching.authorize

object Authorize_lab_4 extends App {
    
    val requestedModule = "project/update"
    val requestedProjectId = 13
    
	val rp1 = RequiredPermission(1L, Some(11L), "project/delete", "ORG_ADMIN", None)
	val rp2 = RequiredPermission(2L, None, "project/update", "ORG_ADMIN", None)
	val rp3 = RequiredPermission(3L, Some(13L), "project/show", "VIEW", Some("lang=AR"))
	val rp4 = RequiredPermission(4L, Some(13L), "project/update", "ORG_ADMIN", Some("lang=EN"))
	
	val requiredPerms = List(rp1, rp2, rp3, rp4)
	
	// Case class constructor pattern matching ---> Nice!
	val relevantReqPerms = requiredPerms.collect { rp => rp match {
	    case RequiredPermission(id, Some(`requestedProjectId`), `requestedModule`, role, rule) 
	        if (rp.projectId.get == requestedProjectId) => rp
	}}
	relevantReqPerms.foreach(println)
}