package nl.confighurator.backend

import jakarta.annotation.PostConstruct
import nl.confighurator.backend.expense_tracker.data.ExpenseSystemRepository
import nl.confighurator.backend.expense_tracker.domain.ExpenseSystem
import nl.confighurator.backend.user.application.UserService
import nl.confighurator.backend.user.data.UserRepository
import nl.confighurator.backend.user.domain.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
//https://www.baeldung.com/running-setup-logic-on-startup-in-spring
@Component
class ExpenseSystemInitializer(
    private val expenseSystemRepository: ExpenseSystemRepository,
    private val userService: UserService,
    private val userRepository: UserRepository
) {
// Niet meest nette code, maar het werkt
    @PostConstruct
    fun init() {
        if (!expenseSystemRepository.existsById("ExpenseSystem")) {
            expenseSystemRepository.save(ExpenseSystem())
        }
        val user = User(
            null,
            "hans",
            "password",
            "hans@gmail.com"
        )
        userRepository.save(user)


    }
}

