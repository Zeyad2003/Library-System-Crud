package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import com.fawry.librarysystem.service.CategoryService;
import com.fawry.librarysystem.model.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    final Integer OK = 200, BAD_REQUEST = 400;

    @PostMapping
    public ResponseEntity<CustomResponse> addCategory(@RequestBody CategoryDTO category) {
        categoryService.addCategory(category);

        return CustomResponse.response("Category added successfully", HttpStatus.OK.value(), category);
    }

    @GetMapping
    public List<CategoryDTO> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateCategoryById(@PathVariable Long id, @RequestBody CategoryDTO category) {
        category.setId(id);
        categoryService.updateCategory(category);

        return CustomResponse.response("Category Updated successfully", HttpStatus.OK.value(), category);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/{id}/books")
    public List<BookDTO> getCategoryBooksById(@PathVariable Long id) {
        return categoryService.findCategoryBooksById(id);
    }
}
