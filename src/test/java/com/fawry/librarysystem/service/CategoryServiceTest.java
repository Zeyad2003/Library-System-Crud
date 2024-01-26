//package com.fawry.librarysystem.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.fawry.librarysystem.entity.Book;
//import com.fawry.librarysystem.entity.Category;
//import com.fawry.librarysystem.repository.CategoryRepo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {CategoryService.class})
//@ExtendWith(SpringExtension.class)
//class CategoryServiceTest {
//    @MockBean
//    private CategoryRepo categoryRepo;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    /**
//     * Method under test: {@link CategoryService#addCategory(Category)}
//     */
//    @Test
//    void testAddCategory() {
//        Category category = new Category();
//        ArrayList<Book> books = new ArrayList<>();
//        category.setBooks(books);
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//        when(categoryRepo.save(Mockito.any())).thenReturn(category);
//
//        Category category2 = new Category();
//        category2.setBooks(new ArrayList<>());
//        category2.setDescription("The characteristics of someone or something");
//        category2.setId(1L);
//        category2.setName("Name");
//        categoryService.addCategory(category2);
//        verify(categoryRepo).save(Mockito.any());
//        assertEquals(books, category2.getBooks());
//        assertEquals("Name", category2.getName());
//        assertEquals(1L, category2.getId().longValue());
//        assertEquals("The characteristics of someone or something", category2.getDescription());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#addCategory(Category)}
//     */
//    @Test
//    void testAddCategory2() {
//        Category category = new Category();
//        ArrayList<Book> books = new ArrayList<>();
//        category.setBooks(books);
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//        when(categoryRepo.save(Mockito.any())).thenReturn(category);
//
//        Category category2 = new Category();
//        category2.setBooks(new ArrayList<>());
//        category2.setDescription("The characteristics of someone or something");
//        category2.setId(1L);
//        category2.setName("Name");
//        categoryService.addCategory(category2);
//        verify(categoryRepo).save(Mockito.any());
//        assertEquals(books, category2.getBooks());
//        assertEquals("Name", category2.getName());
//        assertEquals(1L, category2.getId().longValue());
//        assertEquals("The characteristics of someone or something", category2.getDescription());
//        assertTrue(categoryService.findAllCategories().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#updateCategory(Category)}
//     */
//    @Test
//    void testUpdateCategory() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//        when(categoryRepo.save(Mockito.any())).thenReturn(category);
//
//        Category category2 = new Category();
//        category2.setBooks(new ArrayList<>());
//        category2.setDescription("The characteristics of someone or something");
//        category2.setId(1L);
//        category2.setName("Name");
//        assertSame(category, categoryService.updateCategory(category2));
//        verify(categoryRepo).save(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#deleteCategory(Long)}
//     */
//    @Test
//    void testDeleteCategory() {
//        doNothing().when(categoryRepo).deleteById(Mockito.any());
//        categoryService.deleteCategory(1L);
//        verify(categoryRepo).deleteById(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#deleteCategory(Long)}
//     */
//    @Test
//    void testDeleteCategory2() {
//        doNothing().when(categoryRepo).deleteById(Mockito.any());
//        categoryService.deleteCategory(1L);
//        verify(categoryRepo).deleteById(Mockito.any());
//        assertTrue(categoryService.findAllCategories().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#deleteCategory(String)}
//     */
//    @Test
//    void testDeleteCategory3() {
//        doNothing().when(categoryRepo).deleteByName(Mockito.any());
//        categoryService.deleteCategory("Name");
//        verify(categoryRepo).deleteByName(Mockito.any());
//        assertTrue(categoryService.findAllCategories().isEmpty());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#findCategoryById(Long)}
//     */
//    @Test
//    void testFindCategoryById() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//        Optional<Category> ofResult = Optional.of(category);
//        when(categoryRepo.findById(Mockito.any())).thenReturn(ofResult);
//        assertSame(category, categoryService.findCategoryById(1L));
//        verify(categoryRepo).findById(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link CategoryService#findAllCategories()}
//     */
//    @Test
//    void testFindAllCategories() {
//        ArrayList<Category> categoryList = new ArrayList<>();
//        when(categoryRepo.findAll()).thenReturn(categoryList);
//        List<Category> actualFindAllCategoriesResult = categoryService.findAllCategories();
//        assertSame(categoryList, actualFindAllCategoriesResult);
//        assertTrue(actualFindAllCategoriesResult.isEmpty());
//        verify(categoryRepo).findAll();
//    }
//
//    /**
//     * Method under test: {@link CategoryService#findCategoryByName(String)}
//     */
//    @Test
//    void testFindCategoryByName() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//        when(categoryRepo.findByName(Mockito.any())).thenReturn(category);
//        assertSame(category, categoryService.findCategoryByName("Name"));
//        verify(categoryRepo).findByName(Mockito.any());
//    }
//}
//
