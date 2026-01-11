package nl.confighurator.backend.expense_tracker.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory
import nl.confighurator.backend.user.domain.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
class Expense(
    item: String,
    category: ExpenseCategory,
    price: Double,
    user: User,
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

    @ManyToOne(targetEntity = User::class)
    var user: User = user
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



