package nl.confighurator.backend.expense_tracker.application.dto

import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class ExpenseDto(
    @NotNull val id: Long?,
    @NotNull val userId: Long,
    @NotNull val item: String,
    @NotNull val category: ExpenseCategory,
    @NotNull val price: Double,
    val createdAt: LocalDateTime?

){

}