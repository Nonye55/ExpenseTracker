package com.shecodes.expense.controller;

import com.shecodes.expense.model.Expense;
import com.shecodes.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping("/expenses")
	List<Expense> getExpenses(){
		return expenseRepository.findAll();
	}

	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable Long id){
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@Validated @RequestBody Expense expense )  throws URISyntaxException{
		 Expense result = expenseRepository.save(expense);
		 return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
	}

}
