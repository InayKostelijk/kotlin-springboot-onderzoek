package nl.confighurator.backend.expense_tracker.application.service

import jakarta.transaction.Transactional
import nl.confighurator.backend.expense_tracker.application.dto.ExpenseDto
import nl.confighurator.backend.expense_tracker.data.ExpenseSystemRepository
import nl.confighurator.backend.expense_tracker.domain.Expense
import nl.confighurator.backend.expense_tracker.presentation.exception.ResourceNotFoundException
import nl.confighurator.backend.user.application.UserService
import nl.confighurator.backend.user.application.dto.UserDto
import nl.confighurator.backend.user.data.UserRepository
import org.springframework.stereotype.Service

@Service
@Transactional
class ExpenseSystemService(private val expenseSystemRepository: ExpenseSystemRepository,
    private val userRepository: UserRepository) {

    fun createExpense(expenseDto: ExpenseDto): Boolean {
        val expenseSystem = expenseSystemRepository.findById("ExpenseSystem").orElse(null)
        if (expenseSystem == null) {
            return false
        }
        val user = userRepository.findById(expenseDto.userId).orElse(null)
        if(user == null) {
            throw ResourceNotFoundException("User not found")
        }
        val expense = Expense(expenseDto.item, expenseDto.category, expenseDto.price,user)
        expenseSystem.createExpense(expense)

        return true

    }

}