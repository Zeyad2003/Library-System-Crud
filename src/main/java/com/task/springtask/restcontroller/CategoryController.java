package com.task.springtask.restcontroller;

import com.task.springtask.entity.Category;
import com.task.springtask.responses.CustomResponse;
import com.task.springtask.service.AuthorService;
import com.task.springtask.service.BookService;
import com.task.springtask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CustomResponse> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);

        return CustomResponse.response("Category added successfully");
    }

    @PutMapping("/categories/id/{id}")
    public ResponseEntity<CustomResponse> updateCategoryById(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully");
    }

    @PutMapping("/categories/name/{name}")
    public ResponseEntity<CustomResponse> updateCategoryByName(@PathVariable String name, @RequestBody Category category) {
        Category updatedCategory = categoryService.findCategoryByName(name);
        category.setId(updatedCategory.getId());

        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully");
    }

    @DeleteMapping("/categories/id/{id}")
    public ResponseEntity<CustomResponse> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return CustomResponse.response("Category Deleted successfully");
    }

    @DeleteMapping("/categories/name/{name}")
    public ResponseEntity<CustomResponse> deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteCategory(name);

        return CustomResponse.response("Category Deleted successfully");
    }

    @GetMapping("/categories/id/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/categories/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }
}
