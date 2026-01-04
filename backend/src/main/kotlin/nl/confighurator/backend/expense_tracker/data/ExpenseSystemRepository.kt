package nl.confighurator.backend.expense_tracker.data

import nl.confighurator.backend.expense_tracker.domain.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseSystemRepository : JpaRepository<Expense, Long> {
}