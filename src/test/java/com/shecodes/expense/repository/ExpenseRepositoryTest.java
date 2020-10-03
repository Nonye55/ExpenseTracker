package com.shecodes.expense.repository;

import com.shecodes.expense.model.Category;
import com.shecodes.expense.model.Expense;
import com.shecodes.expense.model.ExpenseUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts={"classpath:db\\insert-expense.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

class ExpenseRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    ExpenseRepository expenseRepository;
    Expense expensetest;

    @BeforeEach
    void setUp() {
        expensetest = expenseRepository.findById((long)3).orElse(null);
        assertThat(expensetest).isNotNull();
        log.info("test data retrived from database -->" + expensetest);

        }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createExpenseObjectAndSaveToDatabaseTest() {

        Expense expense = new Expense();
        ExpenseUser expenseUser = new ExpenseUser();
        Category category = new Category();

        category.setId((long)1);
        expenseUser.setId((long)2);

        expense.setId((long) 4);
        expense.setCategory(category);
        expense.setExpenseUser(expenseUser);
        expense.setDescipt("building");
        expense.setExpensedate(Instant.now());


        log.info("Created category object  -->" + expense);
        assertThat(expense.getId()).isNotNull();

        // save to database
        expense = expenseRepository.save(expense);
        log.info("After saving pet object -->" + expense);
        assertThat(expense.getId()).isNotNull();
    }

        @Test
        void retriveExpenseObjectandFromDatabaseTest(){

            // find all category object
            List<Expense> allExpense = expenseRepository.findAll();
            assertThat(allExpense.size()).isEqualTo(3);
            log.info("All expense object are retieved from database  -->" + allExpense);


    }

    @Test

    void updateExpenseObjectandSaveToDatabaseTest() {

        // create a new category object
        Expense expense = new Expense();
        expense.setId((long) 1);
        expense.setDescipt("education");
        expense.setExpensedate(Instant.now());

        log.info("Updated category object  -->" + expense);
        assertThat(expense.getId()).isNotNull();

        // save to database
        expense = expenseRepository.save(expense);
        log.info("After saving pet object -->" + expense);
        assertThat(expense.getId()).isNotNull();
    }


    @Test
    void deleteCategoryObjectFromDatabaseTest() {

        // delet a category object

        Expense expense = new Expense();
        Expense deleteExpense = expenseRepository.findById((long)3).orElse(null);
        assertThat(deleteExpense).isNotNull();
        expenseRepository.deleteById((long)3);

        log.info("category object is deleted  -->" + expense);
    }

    }