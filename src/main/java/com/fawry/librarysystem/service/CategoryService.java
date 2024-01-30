package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    Category findCategoryById(Long id);

    List<Category> findAllCategories();

    List<Book> findCategoryBooksById(Long id);

}