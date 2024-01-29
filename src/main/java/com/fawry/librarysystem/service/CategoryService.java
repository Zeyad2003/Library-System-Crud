package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    void deleteCategory(String name);

    Category findCategoryById(Long id);

    List<Category> findAllCategories();

    Category findCategoryByName(String name);

    List<Book> findCategoryBooksById(Long id);

}
