package nl.confighurator.backend.expense_tracker.application.dto

import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory
import org.jetbrains.annotations.NotNull

data class ExpenseDto(
    @NotNull val item: String,
    @NotNull val category: ExpenseCategory,
    @NotNull val price: Double

){

}