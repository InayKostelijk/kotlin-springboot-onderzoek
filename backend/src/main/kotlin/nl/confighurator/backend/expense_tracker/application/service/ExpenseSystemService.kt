package nl.confighurator.backend.expense_tracker.application.service

import nl.confighurator.backend.expense_tracker.data.ExpenseRepository
import nl.confighurator.backend.expense_tracker.data.ExpenseSystemRepository
import nl.confighurator.backend.expense_tracker.domain.Expense
import nl.confighurator.backend.expense_tracker.domain.ExpenseSystem
import org.apache.coyote.BadRequestException
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

class ExpenseSystemService() {
    fun createExpense(expense: Expense, expenseRepository: ExpenseRepository, expenseSystemRepository: ExpenseSystemRepository): Expense {
        val expenseSystem = expenseSystemRepository.findById(expense.id!!).orElseThrow(ResponseStatusException("de id mist"))

    }

}