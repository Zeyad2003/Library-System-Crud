package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import com.fawry.librarysystem.service.CategoryService;
import com.fawry.librarysystem.model.response.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Tag(name = "Category", description = "The Category End-Points")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Retrieve all categories", description = "Get a list of all categories.")
    public List<CategoryDTO> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping
    @Operation(summary = "Create a new category", description = "Add a new category to the system.")
    public ResponseEntity<CustomResponse> addCategory(@RequestBody CategoryDTO category) {
        categoryService.addCategory(category);
        return CustomResponse.response("Category added successfully", HttpStatus.OK.value(), category);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID", description = "Retrieve a category by their ID.")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping(params = "name")
    @Operation(summary = "Get category by name", description = "Retrieve a category by their name.")
    public CategoryDTO getCategoryByName(@RequestParam String name) {
        return categoryService.findCategoryByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update category by ID", description = "Update the information of a category by their ID.")
    public ResponseEntity<CustomResponse> updateCategoryById(@PathVariable Long id, @RequestBody CategoryDTO category) {
        category.setId(id);
        categoryService.updateCategory(category);
        return CustomResponse.response("Category Updated successfully", HttpStatus.OK.value(), category);
    }

    @GetMapping("/{id}/books")
    @Operation(summary = "Get books by category ID", description = "Retrieve all books associated with a specific category by their ID.")
    public List<BookDTO> getCategoryBooksById(@PathVariable Long id) {
        return categoryService.findCategoryBooksById(id);
    }
}