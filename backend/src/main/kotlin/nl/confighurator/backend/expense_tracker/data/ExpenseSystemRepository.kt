package nl.confighurator.backend.expense_tracker.data

import nl.confighurator.backend.expense_tracker.domain.ExpenseSystem
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseSystemRepository : JpaRepository<ExpenseSystem, String> {
}