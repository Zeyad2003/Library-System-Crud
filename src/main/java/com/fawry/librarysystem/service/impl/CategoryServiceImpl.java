package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.repository.CategoryRepo;
import com.fawry.librarysystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public List<Book> findCategoryBooksById(Long id) {
        return categoryRepo.findCategoryBooksById(id);
    }

}
