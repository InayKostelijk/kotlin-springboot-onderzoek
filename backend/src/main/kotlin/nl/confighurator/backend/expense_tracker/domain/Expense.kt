package nl.confighurator.backend.expense_tracker.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
class Expense(
    item: String,
    category: ExpenseCategory,
    price: Double
) {
    @Id
    @GeneratedValue
    val id: Long? = null

     var item: String = item
        protected set

    @Enumerated(EnumType.STRING)
     var category: ExpenseCategory = category
        protected set

     var price: Double = price
        protected set

    @CreationTimestamp
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
     var updatedAt: LocalDateTime? = null
        protected set

    fun update(item: String, category: ExpenseCategory, price: Double) {
        this.item = item
        this.category = category
        this.price = price
    }
}



