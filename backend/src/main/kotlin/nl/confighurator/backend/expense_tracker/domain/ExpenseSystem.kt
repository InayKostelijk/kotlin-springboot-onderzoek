package nl.confighurator.backend.expense_tracker.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
class ExpenseSystem {

    @Id
     val  id: String = "ExpenseSystem"

    @OneToMany(targetEntity = Expense::class, cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "expense_system_id")
    var expenseList: MutableList<Expense>  = mutableListOf()
        protected set
}