package lab.case_classes_pattern_matching.authorize

// LAB

case class RequiredPermission(
    id: Long, // Auto-increment
    projectId: Option[Long], // Optional. If not set, then permission is determined at the client level and role must be ADMIN.
    controllerMethod: String, // Optional
    required_role: String, // Required. Multiple required_role records evaluated by OR logic. (ex: Q_ADMIN, ORG_ADMIN, EDIT, VIEW)
    required_rule: Option[String] // Optional. Not allowed if no controller or method set. Multiple required_rule records evaluated by AND logic.
)
