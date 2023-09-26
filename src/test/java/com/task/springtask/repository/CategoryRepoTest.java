package com.task.springtask.repository;

import com.task.springtask.entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepoTest {

    private final CategoryRepo categoryRepo;

    private final TestEntityManager testEntityManager;

    @Autowired
    public CategoryRepoTest(CategoryRepo categoryRepo, TestEntityManager testEntityManager) {
        this.categoryRepo = categoryRepo;
        this.testEntityManager = testEntityManager;
    }

    @AfterEach
    void tearDown() {
        categoryRepo.deleteAll();
    }

    @Test
    void testSaveCategory() {
        // given
        Category category = new Category();
        category.setName("Fantasy");
        category.setDescription("A genre of fiction that features magical and supernatural elements");

        // when
        Category savedCategory = categoryRepo.save(category);

        // then
        assertThat(savedCategory.getId()).isNotNull();
        assertThat(savedCategory.getName()).isEqualTo("Fantasy");
        assertThat(savedCategory.getDescription()).isEqualTo("A genre of fiction that features magical and supernatural elements");
    }

    @Test
    void testFindCategoryByName() {
        // given
        Category category = new Category();
        category.setName("Fantasy");
        category.setDescription("A genre of fiction that features magical and supernatural elements");
        category = testEntityManager.persistAndFlush(category);

        // when
        Category foundCategory = categoryRepo.findByName("Fantasy");

        // then
        assertThat(foundCategory).isNotNull();
        assertThat(foundCategory.getId()).isEqualTo(category.getId());
        assertThat(foundCategory.getName()).isEqualTo("Fantasy");
        assertThat(foundCategory.getDescription()).isEqualTo("A genre of fiction that features magical and supernatural elements");
    }

    @Test
    void testDeleteCategoryByName() {
        // given
        Category category = new Category();
        category.setName("Fantasy");
        category.setDescription("A genre of fiction that features magical and supernatural elements");
        testEntityManager.persistAndFlush(category);

        // when
        categoryRepo.deleteByName("Fantasy");

        // then
        assertThat(categoryRepo.findByName("Fantasy")).isNull();
    }

}
