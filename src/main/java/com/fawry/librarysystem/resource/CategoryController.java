package com.fawry.librarysystem.resource;

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

        return CustomResponse.response("Category added successfully");
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<CustomResponse> updateCategoryById(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully");
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<CustomResponse> updateCategoryByName(@PathVariable String name, @RequestBody Category category) {
        Category updatedCategory = categoryService.findCategoryByName(name);
        category.setId(updatedCategory.getId());

        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<CustomResponse> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return CustomResponse.response("Category Deleted successfully");
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<CustomResponse> deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteCategory(name);

        return CustomResponse.response("Category Deleted successfully");
    }

    @GetMapping("/id/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }

    @GetMapping("/{id}/books")
    public List<Book> getCategoryBooksById(@PathVariable Long id) {
        return categoryService.findCategoryBooksById(id);
    }
}
