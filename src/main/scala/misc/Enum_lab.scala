package misc

object Role extends Enumeration {
    type Role = Value
    val NON, VIEW, EDIT, ORG_ADMIN, Q_ADMIN = Value
    
    val roleMap = Map[String, Role.Value] (
    		"NON" -> Role.NON,
    		"VIEW" -> Role.VIEW,
    		"EDIT" -> Role.EDIT,
    		"ORG_ADMIN" -> Role.ORG_ADMIN,
    		"Q_ADMIN" -> Role.Q_ADMIN
    )
    
    def apply(role: String) = {
        roleMap(role)
    }
}

object Enum_lab extends App{
    println(Role.EDIT < Role.Q_ADMIN)
    println(Role.ORG_ADMIN > Role.VIEW)
    println(Role.EDIT > Role.Q_ADMIN)
    println(Role.ORG_ADMIN < Role.VIEW)
    println(Role.Q_ADMIN > Role.ORG_ADMIN)
    Role.Q_ADMIN.toString()
    
    println(Role.roleMap("NON"))
    println(Role.roleMap("NON")).toString
    
    println(Role("EDIT"))
}


