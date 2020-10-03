package com.shecodes.expense.repository;

import com.shecodes.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);



}
