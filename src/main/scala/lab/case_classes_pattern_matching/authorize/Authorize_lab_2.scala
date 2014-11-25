package lab.case_classes_pattern_matching.authorize

object Authorize_lab_2 extends App {
    
	val rp1 = RequiredPermission(1L, Some(11L), "project/update", "ORG_ADMIN", None)
	val rp2 = RequiredPermission(2L, None, "project/delete", "ORG_ADMIN", None)
	val rp3 = RequiredPermission(3L, Some(12L), "project/delete", "VIEW", Some("lang=AR"))
	val rp4 = RequiredPermission(4L, Some(13L), "project/update", "ORG_ADMIN", Some("lang=EN"))
	
	val perms = List(rp1, rp2, rp3, rp4)
		
	def authorize (rp: RequiredPermission): Option[RequiredPermission] = rp match {
	    case RequiredPermission(id, Some(projectId), "project/update", "ORG_ADMIN", rule) => {
            if (projectId == 13) {
                println("Got id: " + id)
                Some(rp)
            }
            None
	    }
	    case _ => {
	        println("Not what I'm looking for")
	        None
	    }
	}
	
	for (p <- perms) authorize(p)
}