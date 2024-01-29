package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.service.CategoryService;
import com.fawry.librarysystem.model.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CustomResponse> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);

        return CustomResponse.response("Category added successfully", category);
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateCategoryById(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully", category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return CustomResponse.response("Category Deleted successfully", id);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getCategoryBooksById(@PathVariable Long id) {
        return categoryService.findCategoryBooksById(id);
    }
}
