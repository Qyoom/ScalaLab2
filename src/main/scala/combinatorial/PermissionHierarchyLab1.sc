package combinatorial
 
object PermissionHierarchyLab1 {

  /********** MODEL ***************/
  
  	object Role extends Enumeration {
	  	type Role = Value
    	val NON, VIEW, EDIT, ORG_ADMIN, Q_ADMIN = Value
  	}
  
  	case class UserPermission(
		endpoint: Option[String],
		projectId: Option[Int],
		role: Role.Value
  )
  
  /******** INSTANCES ************/
  
  val p1 = UserPermission(Some("path.one"), Some(10), Role.VIEW)
                                                  //> p1  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| Some(path.one),Some(10),VIEW)
  
  val p2 = UserPermission(Some("path.one"), Some(10), Role.EDIT)
                                                  //> p2  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| Some(path.one),Some(10),EDIT)
  
  val p3 = UserPermission(None, Some(10), Role.EDIT)
                                                  //> p3  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| None,Some(10),EDIT)
  val p4 = UserPermission(Some("path.one"), None, Role.EDIT)
                                                  //> p4  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| Some(path.one),None,EDIT)
  val p5 = UserPermission(None, None, Role.EDIT)  //> p5  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| None,None,EDIT)
  val p6 = UserPermission(None, Some(10), Role.VIEW)
                                                  //> p6  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPermission(
                                                  //| None,Some(10),VIEW)

  /******** CONDITIONAL LOGIC **************************************/
  
  /* TODO: What about filtering?
   * projectIds are guaranteed to match required pId or be None.
   * endpoints are guaranteed to match required endpoint or be None.
   */
  
  val candidate1 = p1                             //> candidate1  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPer
                                                  //| mission(Some(path.one),Some(10),VIEW)
  val candidate2 = p3                             //> candidate2  : combinatorial.PermissionHierarchyLab1.UserPermission = UserPe
                                                  //| rmission(None,Some(10),EDIT)
  //............. Easy defaults positions .............//
  
  if (candidate1.role == Role.Q_ADMIN) println("Easy default - candidate1 wins with Q_ADMIN!")
  else if (candidate1.role == Role.ORG_ADMIN) println("Easy default - candidate1 wins with ORG_ADMIN!")
  
  //............. Lab 1, role first ...................//
  
 	if (candidate1.role > candidate2.role) {
 		/* It would apear that candidate1 wins, but not necessarily!
 		 * Depends on specificity! If candidate2 has projectId, then
 		 * candidate1 must also have projectId or else candidate2 wins!
 		 * After working with this lab a while, It's begining to make intuitive sense to me
 		 * that it would be more efficient (and logical) to start with testing existence of
 		 * projectId because specificity is very powerful, and no matter what the role, a
 		 * UserPermission with a projectId will take precedence over a UserPermission without one,
 		 * no matter its role.
 		 */
		candidate2.projectId match {
	  		case Some(candidate2_pId) => {
	  			candidate1.projectId match {
			  		case Some(pId) => {
			  			// The contest needs to continue
			  		}
			  		case None => {
			  			/* candidate2 wins here because no matter what role candidate2 has her
			  			 * permission is more specific per projectId and therefore takes precedence.
			  			 */
			  			 println("Lab 1 - candidate2 wins because of projectId specificity")
			  		}
  				} // end candidate1.projectId match
	  		} // end case Some(pId) for candidate2.projectId match
	  		case None => {
	  			//
	  		} // end case None for candidate2.projectId match
	  } // end candidate2.projectId match
 	} // end if (candidate1.role > candidate2.role)
 	else {
 		//
 	} // end else for if (candidate1.role > candidate2.role)
 	
 	//............. Lab 2, projectId first  ..................//
 	
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
  									// TODO: ROLE COMPARISON !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  								} // end Some(cand2_endpoint)
  								case None => {
  									// candidate1 wins because of endpoint specificity
  									println("Lab 2 - candidate1 wins because of endpoint specificity")
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
									println("Lab 2 - candidate2 wins because of endpoint specificity.")
								} // end case Some(cand2_endpoint)
								case None => {
									// But neither have endpoints at this point, the compare roles to decide.
									if (candidate1.role > candidate2.role) {
										println("Lab 2 - candidate1 wins because of more restrictive role.")
									} // end if (candidate1.role > candidate2.role)
									else {
										println("Lab 2 - candidate2 wins because of more restrictive (or equal) role.")
									} // end else for if (candidate1.role > candidate2.role)
								} // end case None for candidate2.endpoint match
  							} // end candidate2.endpoint match
  						} // end case None for candidate1.endpoint match
  					} // end candidate1.endpoint match
  				} // end case Some(cand2_pId)
  				case None => {
  					// candidate1 wins because of projectId specificity
  					println("Lab 2 - candidate1 wins because of projectId specificity")
  				} // end case None for candidate2.projectId match
  			} // end candidate2.projectId match
  		} // end case Some(cand1_pId)
  		case None => { // candidate1.projectId match
  			// If candidate2 has a projectId candidate2 wins.
  			candidate2.projectId match {
  				case Some(cand2_pId) => {
  					println("Lab 2 - candidate2 wins because of projectId specificity.")
  				} // end case Some(cand2_pId)
  				case None => {
  					// Neither have projectIds, so then need to compare endpoint specificity
  					candidate1.endpoint match {
  						case Some(cand1_endpoint) => { //
  						
  							candidate2.endpoint match {
  								case Some(cand2_endpoint) => {
  									// Still a match, so now the final comparison of roles...
  									// TODO: ROLE COMPARISON !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  								} // end Some(cand2_endpoint)
  								case None => {
  									// candidate1 wins because of endpoint specificity
  									println("Lab 2 - candidate1 wins because of endpoint specificity")
  								} // end case None for candidate2.endpoint match
  							} // end candidate2.endpoint match
  							
  						} // end case Some(cand1_endpoint)
  						
  						case None => {} //
  						
  					} // end candidate1.endpoint match
  				} // end case None for candidate2.projectId match
  			} // end candidate2.projectId match
  			// But if candidate2 doesn't have a projectId, the contest continues.
  		} // end None for candidate1.projectId match
  } // end candidate1.projectId match             //> Lab 2 - candidate1 wins because of endpoint specificity
  
  //............. Lab 3, endpoint first ..................//
  
  candidate1.endpoint match {
  		case Some(endpoint) => {
  			//
  		}
  		case None => {
  			//
  		}
  }
  
    
}