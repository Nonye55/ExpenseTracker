package com.shecodes.expense.repository;

import com.shecodes.expense.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts={"classpath:db\\insert-category.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

class CategoryRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    CategoryRepository categoryRepository;
    Category categorytest;

    @BeforeEach
    void setUp() {
        categorytest = categoryRepository.findById((long) 3).orElse(null);
        assertThat(categorytest).isNotNull();
        log.info("test data retrived from database -->" +categorytest);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCategoryObjectandSaveToDatabaseTest(){

        // create a new category object
        Category category = new Category();
        category.setId((long) 5);
        category.setName("building");

        log.info("Created category object  -->" + category);
        assertThat(category.getId()).isNotNull();

        // save to database
        category = categoryRepository.save(category);
        log.info("After saving pet object -->" + category);
        assertThat(category.getId()).isNotNull();

    }


    @Test
    void retriveCategoryObjectandFromDatabaseTest(){

        // find all category object
        List<Category> allCategory = categoryRepository.findAll();
        assertThat(allCategory.size()).isEqualTo(3);
        log.info("All category object are retieved from database  -->" + allCategory);

    }

    @Test
    void updateCategoryObjectandSaveToDatabaseTest(){

        // create a new category object
        Category category = new Category();
        category.setId((long)1);
        category.setName("education");

        log.info("Updated category object  -->" + category);
        assertThat(category.getId()).isNotNull();

        // save to database
        category = categoryRepository.save(category);
        log.info("After saving pet object -->" + category);
        assertThat(category.getId()).isNotNull();

    }

    @Test
    void deleteCategoryObjectFromDatabaseTest(){

        // delet a category object

        Category category = new Category();
        Category deleteCategory = categoryRepository.findById((long)3).orElse(null);
        assertThat(deleteCategory).isNotNull();
////        categoryRepository.deleteById((long)3);
//        categoryRepository.deleteById((long)3);


        log.info("category object is deleted  -->" + category);



//        assertThat(category.getId()).isNotNull();
//
//        List<Pet> allPets = petRepository.findAll();
//        assertThat(allPets).isNotNull();
//        assertThat(allPets.size()).isEqualTo(5);
//
//        Pet savedPet = petRepository.findById(202).orElse(null);
//        assertThat(savedPet).isNotNull();
//        petRepository.deleteById(202);
//
//        Pet deletedPet = petRepository.findById(202).orElse(null);
//        assertThat(deletedPet).isNull();
//
//        allPets=petRepository.findAll();
//        assertThat(allPets).isNotNull();
//        assertThat(allPets.size()).isEqualTo(4);

    }
}