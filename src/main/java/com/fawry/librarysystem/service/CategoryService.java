package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
<<<<<<< HEAD

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void updateCategory(Category category);
=======
import com.fawry.librarysystem.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
>>>>>>> master

    void deleteCategory(Long id);

    void deleteCategory(String name);

    Category findCategoryById(Long id);

    List<Category> findAllCategories();

    Category findCategoryByName(String name);

    List<Book> findCategoryBooksById(Long id);

}
