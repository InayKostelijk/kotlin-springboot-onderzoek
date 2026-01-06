package nl.confighurator.backend.expense_tracker.presentation.exception

import org.springframework.http.HttpStatus

data class CustomResponse(
    val status: HttpStatus,
    val message: String?,
    val errors: Map<String, String>? = null
)
