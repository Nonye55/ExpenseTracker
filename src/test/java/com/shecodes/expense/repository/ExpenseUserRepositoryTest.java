package com.shecodes.expense.repository;

import com.shecodes.expense.model.ExpenseUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts={"classpath:db\\insert-user.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

class ExpenseUserRepositoryTest {
   Logger log = Logger.getLogger(getClass().getName());

        @Autowired
        UserRepository userRepository;
        ExpenseUser usertest;


            @BeforeEach
    void setUp() {
                usertest = userRepository.findById((long)3).orElse(null);
                assertThat(usertest).isNotNull();
                log.info("usertest data retrived from database -->" + usertest);

            }

    @AfterEach
    void tearDown() {
    }


    @Test
    void createUserObjectAndSaveToDatabaseTest() {

        // create a new category object
        ExpenseUser expenseUser = new ExpenseUser();
        expenseUser.setId((long) 4);
        expenseUser.setName("prince");
        expenseUser.setEmail("prince@gmail.com");

        log.info("Created user object  -->" + expenseUser);
        assertThat(expenseUser.getId()).isNotNull();

        // save to database
        expenseUser = userRepository.save(expenseUser);
        log.info("After saving pet object -->" + expenseUser);
        assertThat(expenseUser.getId()).isNotNull();
    }

    @Test
    void retriveUserObjectAndFromDatabaseTest() {

        // find all category object
        List<ExpenseUser> allExpenseUser = userRepository.findAll();
        assertThat(allExpenseUser.size()).isEqualTo(3);
        log.info("All user object are retireved from database  -->" + allExpenseUser);
    }


    @Test
    void updateUserObjectTest(){

        // create a new category object
        ExpenseUser expenseUser = new ExpenseUser();
        expenseUser.setId((long)1);
        expenseUser.setName("Patrick ogu");
        expenseUser.setEmail("patrick@gmail.com");

        log.info("Updated category object  -->" + expenseUser);
        assertThat(expenseUser.getId()).isNotNull();

        // save to database
        expenseUser = userRepository.save(expenseUser);
        log.info("After saving pet object -->" + expenseUser);
        assertThat(expenseUser.getId()).isNotNull();
    }

    @Test

    void deleteUserObjectFromDatabaseTest() {

        // delet a category object

        ExpenseUser expenseUser = new ExpenseUser();
        ExpenseUser deleteExpenseUser = userRepository.findById((long) 3).orElse(null);
        assertThat(deleteExpenseUser).isNotNull();

        log.info("user object is deleted  -->" + expenseUser);
    }

    }

