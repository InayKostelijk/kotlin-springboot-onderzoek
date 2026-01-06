package nl.confighurator.backend.expense_tracker.presentation.exception

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException

//https://www.baeldung.com/kotlin/spring-rest-error-handling
@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<CustomResponse> {
        val errorMap: MutableMap<String, String> = HashMap()
        for (error in ex.bindingResult.fieldErrors) {
            errorMap[error.field] = error.defaultMessage ?: "Invalid value"
        }
        val error = CustomResponse(status = HttpStatus.BAD_REQUEST, message = errorMap.toString())
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleResourceBadRequestException(ex: BadRequestException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.BAD_REQUEST, ex.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.NOT_FOUND, ex.message)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolation(ex: DataIntegrityViolationException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.BAD_REQUEST, ex.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError::class)
    fun handleInternalServerError(ex: InternalServerError): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ServiceNotAvailableException::class)
    fun handleServiceNotAvailableError(ex: ServiceNotAvailableException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.SERVICE_UNAVAILABLE, ex.message)
        return ResponseEntity(error, HttpStatus.SERVICE_UNAVAILABLE)
    }

    @ExceptionHandler(InvalidEnumException::class)
    fun handleInvalidEnum(ex: InvalidEnumException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.BAD_REQUEST, ex.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<CustomResponse> {
        val error = CustomResponse(HttpStatus.NOT_FOUND, ex.message)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}