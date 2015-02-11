package combinatorial

object PermissionHierarchyLab3 extends App {
     
    /********** MODEL *************************************************/
  
  	object Role extends Enumeration {
	  	type Role = Value
		val NON, VIEW, EDIT, ORG_ADMIN, Q_ADMIN = Value
  	}
  
  	case class UserPermission(
		endpoint: Option[String],
		projectId: Option[Int],
		role: Role.Value
	)
	
	/******** INSTANCES ************************************************/
  
	val p1 = UserPermission(Some("path.one"), None, Role.VIEW)
	val p2 = UserPermission(None, Some(10), Role.VIEW)
	val p3 = UserPermission(None, Some(10), Role.EDIT)
	val p4 = UserPermission(Some("path.one"), None, Role.EDIT)
	val p5 = UserPermission(None, None, Role.EDIT)
	val p6 = UserPermission(None, Some(10), Role.EDIT)
	val p7 = UserPermission(Some("path.one"), None, Role.EDIT)
	val p8 = UserPermission(Some("path.one"), None, Role.VIEW)

	  /******** CONDITIONAL LOGIC **************************************/
  
	/* TODO: What about filtering?
	 * projectIds are guaranteed to match required pId or be None.
	 * endpoints are guaranteed to match required endpoint or be None.
	 */
  
	val candidate1 = p8
	val candidate2 = p7

	//............. Easy defaults positions .............//
  
	if (candidate1.role == Role.Q_ADMIN) println("Easy default - candidate1 wins with Q_ADMIN!")
	else if (candidate1.role == Role.ORG_ADMIN) println("Easy default - candidate1 wins with ORG_ADMIN!")

	//...... Checks proceed by projectId first, followed by endpoint, then role ....//
	
	candidate1.projectId match {
  		case Some(cand1_pId) => {
  			candidate2.projectId match {
  				case Some(cand2_pId) => {
  					// Now need to check specificity of endpoint
  					candidate1.endpoint match {
  						case Some(cand1_endpoint) => {
  							candidate2.endpoint match {
  								case Some(cand2_endpoint) => {
  									// Still a match, so now the final comparison of roles...
  									if (candidate1.role > candidate2.role) {
										println("Outcome: candidate1 wins because of more restrictive role.")
									} // end if (candidate1.role > candidate2.role)
									else {
										println("Outcome: candidate2 wins because of more restrictive (or equal) role.")
									} // end else for if (candidate1.role > candidate2.role)
  								} // end Some(cand2_endpoint)
  								case None => {
  									// candidate1 wins because of endpoint specificity
  									println("Outcome: candidate1 wins because of endpoint specificity")
  								} // end case None for candidate2.endpoint match
  							} // end candidate2.endpoint match
  						} // end case Some(cand1_endpoint)
  						case None => {
  							/* At this point both candidate1 and candidate2 have projectIds.
  							 * candidate1 has no endpoint. So if candidate2 does, then candidate2 wins
  							 * because of endpoint specificity. So need to check for candidate2.endpoint
  							 */
  							candidate2.endpoint match {
								case Some(cand2_endpoint) => {
									println("Outcome: candidate2 wins because of endpoint specificity.")
								} // end case Some(cand2_endpoint)
								case None => {
									// But neither have endpoints at this point, the compare roles to decide.
									if (candidate1.role > candidate2.role) {
										println("Outcome: candidate1 wins because of more restrictive role.")
									} // end if (candidate1.role > candidate2.role)
									else {
										println("Outcome: candidate2 wins because of more restrictive (or equal) role.")
									} // end else for if (candidate1.role > candidate2.role)
								} // end case None for candidate2.endpoint match
  							} // end candidate2.endpoint match
  						} // end case None for candidate1.endpoint match
  					} // end candidate1.endpoint match
  				} // end case Some(cand2_pId)
  				case None => {
  					// candidate1 wins because of projectId specificity
  					println("Outcome: candidate1 wins because of projectId specificity")
  				} // end case None for candidate2.projectId match
  			} // end candidate2.projectId match
  		} // end case Some(cand1_pId)
  		case None => { // candidate1.projectId match
  			// If candidate2 has a projectId candidate2 wins.
  			candidate2.projectId match {
  				case Some(cand2_pId) => {
  					println("Outcome: candidate2 wins because of projectId specificity.")
  				} // end case Some(cand2_pId)
  				case None => {
  					// Neither have projectIds, so then need to compare endpoint specificity
  					candidate1.endpoint match {
  						case Some(cand1_endpoint) => {
  							candidate2.endpoint match {
  								case Some(cand2_endpoint) => {
  									// Still a match, so now the final comparison of roles...
  								    if (candidate1.role > candidate2.role) {
										println("Outcome: candidate1 wins because of more restrictive role.")
									} // end if (candidate1.role > candidate2.role)
									else {
										println("Outcome: candidate2 wins because of more restrictive (or equal) role.")
									} // end else for if (candidate1.role > candidate2.role)
  								} // end Some(cand2_endpoint)
  								case None => {
  									// candidate1 wins because of endpoint specificity
  									println("Outcome: candidate1 wins because of endpoint specificity.")
  								} // end case None for candidate2.endpoint match
  							} // end candidate2.endpoint match
  						} // end case Some(cand1_endpoint)
  						case None => { // If candidate2 has endpoint it wins, else just compare roles.
  						    candidate2.endpoint match {
  						        case Some(cand2_endpoint) => {
  						            println("Outcome: candidate2 wins because of endpoint specificity.")
  						        } // end case Some(cand2_endpoint)
  						        case None => {
  						            // No projectIds nor endpoints at this point, so just compare roles.
  						            if (candidate1.role > candidate2.role) {
										println("Outcome: candidate1 wins because of more restrictive role.")
									} // end if (candidate1.role > candidate2.role)
									else {
										println("Outcome: candidate2 wins because of more restrictive (or equal) role.")
									} // end else for if (candidate1.role > candidate2.role)
  						        } // end case None for candidate2.endpoint match
  						    } // end candidate2.endpoint match
  						} // end case None for candidate1.endpoint match
  					} // end candidate1.endpoint match
  				} // end case None for candidate2.projectId match
  			} // end candidate2.projectId match
  		} // end None for candidate1.projectId match
	} // end candidate1.projectId match             	

} // end PermissionHierarchyLab3








