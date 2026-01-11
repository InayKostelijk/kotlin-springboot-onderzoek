package nl.confighurator.backend.expense_tracker.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory
import nl.confighurator.backend.user.domain.User

@Entity
class ExpenseSystem {

    @Id
     val  id: String = "ExpenseSystem"

    @OneToMany(targetEntity = Expense::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "expense_system_id")
    val expenseList: MutableList<Expense>  = mutableListOf()


    @OneToMany(targetEntity = User::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "expense_system_id")
    val userList: MutableList<User>  = mutableListOf()



    fun createExpense(expense: Expense): Expense {
        expenseList.add(expense)
        return expense
    }
}