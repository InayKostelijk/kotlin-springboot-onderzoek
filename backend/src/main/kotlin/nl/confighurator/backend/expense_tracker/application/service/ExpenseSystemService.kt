package nl.confighurator.backend.expense_tracker.application.service

import jakarta.transaction.Transactional
import nl.confighurator.backend.expense_tracker.application.dto.ExpenseDto
import nl.confighurator.backend.expense_tracker.data.ExpenseSystemRepository
import nl.confighurator.backend.expense_tracker.domain.Expense
import org.springframework.stereotype.Service

@Service
@Transactional
class ExpenseSystemService(private val expenseSystemRepository: ExpenseSystemRepository) {

    fun createExpense(expenseDto: ExpenseDto): Boolean {
        val expenseSystem = expenseSystemRepository.findById("ExpenseSystem").orElse(null)

        if (expenseSystem == null) {
            return false
        }
        val expense = Expense(expenseDto.item, expenseDto.category, expenseDto.price)
        expenseSystem.createExpense(expense)

        return true

    }

}