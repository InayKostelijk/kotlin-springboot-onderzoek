package nl.confighurator.backend

import jakarta.annotation.PostConstruct
import nl.confighurator.backend.expense_tracker.data.ExpenseSystemRepository
import nl.confighurator.backend.expense_tracker.domain.ExpenseSystem
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
//https://www.baeldung.com/running-setup-logic-on-startup-in-spring
@Component
class ExpenseSystemInitializer(
    private val expenseSystemRepository: ExpenseSystemRepository
) {

    @PostConstruct
    fun init() {
        if (!expenseSystemRepository.existsById("ExpenseSystem")) {
            expenseSystemRepository.save(ExpenseSystem())
            println("ExpenseSystem singleton created")
        }
    }
}

