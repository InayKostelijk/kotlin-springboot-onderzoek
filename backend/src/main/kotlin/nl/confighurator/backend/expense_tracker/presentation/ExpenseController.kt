package nl.confighurator.backend.expense_tracker.presentation

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("expenses")
class ExpenseController {



    @PostMapping
    fun createExpense(): ResponseEntity<String>{


        return ResponseEntity.status(HttpStatus.CREATED).body("Je uitgave is opgeslagen")
    }
    @DeleteMapping
    fun deleteExpense(): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.OK).body("Je uitgave is verwijderd")
    }

    @GetMapping





}