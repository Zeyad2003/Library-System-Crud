package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO category);

    void updateCategory(CategoryDTO category);

    CategoryDTO findCategoryById(Long id);

    List<CategoryDTO> findAllCategories();

    List<BookDTO> findCategoryBooksById(Long id);

}