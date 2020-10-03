package com.shecodes.expense.repository;

import com.shecodes.expense.model.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ExpenseUser,Long> {
	ExpenseUser findByUsername(String username);

}
