package com.fawry.librarysystem.service;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO category);

    void updateCategory(CategoryDTO category);

    CategoryDTO findCategoryById(Long id);

    CategoryDTO findCategoryByName(String name);

    List<CategoryDTO> findAllCategories();

    List<BookDTO> findCategoryBooksById(Long id);

}