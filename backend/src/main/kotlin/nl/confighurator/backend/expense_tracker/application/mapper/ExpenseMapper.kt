package nl.confighurator.backend.expense_tracker.application.mapper

import nl.confighurator.backend.expense_tracker.application.dto.ExpenseDto
import nl.confighurator.backend.expense_tracker.domain.Expense
import org.springframework.stereotype.Component


object ExpenseMapper {
    fun toExpenseDto(expense: Expense): ExpenseDto {
        return ExpenseDto(
            expense.id,
            expense.user.id,
            expense.item,
            expense.category,
            expense.price,
            expense.createdAt
        )
    }
}