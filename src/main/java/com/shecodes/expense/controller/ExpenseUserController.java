package com.shecodes.expense.controller;


import com.shecodes.expense.model.ExpenseUser;
import com.shecodes.expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class ExpenseUserController {
	@Autowired
	private UserRepository userRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public ExpenseUserController(BCryptPasswordEncoder bCryptPasswordEncoder){
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody ExpenseUser expenseUser){
		expenseUser.setPassword(bCryptPasswordEncoder.encode(expenseUser.getPassword()));
		userRepository.save(expenseUser);
	}


}

