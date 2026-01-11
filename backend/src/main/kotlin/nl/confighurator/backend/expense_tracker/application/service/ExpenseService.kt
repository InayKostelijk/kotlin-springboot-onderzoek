package nl.confighurator.backend.expense_tracker.application.service

import jakarta.transaction.Transactional
import nl.confighurator.backend.expense_tracker.application.dto.ExpenseDto
import nl.confighurator.backend.expense_tracker.application.mapper.ExpenseMapper
import nl.confighurator.backend.expense_tracker.data.ExpenseRepository
import nl.confighurator.backend.expense_tracker.presentation.exception.BadRequestException
import nl.confighurator.backend.expense_tracker.presentation.exception.ResourceNotFoundException
import nl.confighurator.backend.user.data.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
@Transactional
class ExpenseService(
    private val expenseRepository: ExpenseRepository,
    private val userRepository: UserRepository,
) {

    //https://kotlinlang.org/docs/collection-transformations.html#map
//https://medium.com/%40guruprasadhegde4/kotlin-lambda-expressions-bb9d4e15b6fc
    fun getAllExpenses(): List<ExpenseDto> {
        return expenseRepository.findAll().map{ExpenseMapper.toExpenseDto(it)}
    }

    fun getExpenseById(expenseId: Long): ExpenseDto {
        val expense = expenseRepository.findById(expenseId).orElse(null)
        if(expense == null){
            throw ResourceNotFoundException("Expense not found")
        }
        return ExpenseMapper.toExpenseDto(expense)
    }

    fun editExpenseById(expenseId: Long, expenseDto: ExpenseDto): Boolean {
        val expense = expenseRepository.findById(expenseId).orElse(null)
        val user = userRepository.findById(expenseDto.userId).orElse(null)
        if(user == null) {
            throw ResourceNotFoundException("User not found")
        }
        if (expense == null) {
            throw BadRequestException("Expense not found")
        }
        expense.update(
            expenseDto.item,
            expenseDto.category,
            expenseDto.price,
        )
        return true
    }
    fun deleteExpense(expenseId: Long) {
        val expense = expenseRepository.findByIdOrNull(expenseId)?: throw BadRequestException("Expense not found")
        expenseRepository.delete(expense)
    }
}