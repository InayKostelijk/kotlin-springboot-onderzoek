package nl.confighurator.backend.expense_tracker.presentation

import jakarta.validation.Valid
import nl.confighurator.backend.expense_tracker.application.dto.ExpenseDto
import nl.confighurator.backend.expense_tracker.application.service.ExpenseService
import nl.confighurator.backend.expense_tracker.application.service.ExpenseSystemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("expenses")
class ExpenseController(
    private val expenseSystemService: ExpenseSystemService,
    private val expenseService: ExpenseService
) {


    @GetMapping
    fun getAllExpenses(): ResponseEntity<List<ExpenseDto>>{
        val expenses: List<ExpenseDto> =  expenseService.getAllExpenses()
        if(expenses.isEmpty()){
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(expenses, HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun getExpenseById(@Valid@PathVariable id: Long): ResponseEntity<ExpenseDto>{
        val getExpense: ExpenseDto = expenseService.getExpenseById(id)
        return ResponseEntity(getExpense,HttpStatus.OK)
    }

    @PostMapping
    fun createExpense(@Valid@RequestBody expenseDto: ExpenseDto): ResponseEntity<String>{

        val created: Boolean = expenseSystemService.createExpense(expenseDto)
        if(!created){
            return ResponseEntity("Het is niet gelukt om de expense te maken",HttpStatus.BAD_REQUEST)
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Je uitgave is toegevoegd")
    }
    @PutMapping("{id}")
    fun updateExpense(@Valid @PathVariable id: Long, @RequestBody expenseDto: ExpenseDto): ResponseEntity<String>{
        val updateExpense: Boolean = expenseService.editExpenseById(id,expenseDto)
        if (!updateExpense){
            return ResponseEntity("Het is niet gelukt om de expense te updaten",HttpStatus.BAD_REQUEST)
        }
        return ResponseEntity("Het is gelukt om de expense te updaten",HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun deleteExpense(@Valid @PathVariable id: Long): ResponseEntity<String>{
        expenseService.deleteExpense(id)
        return ResponseEntity("Je uitgave is verwijderd",HttpStatus.OK)
    }






}