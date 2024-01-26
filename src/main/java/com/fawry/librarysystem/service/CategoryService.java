package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
    public void deleteCategory(String name) {
        categoryRepo.deleteByName(name);
    }

    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public Category findCategoryByName(String name) {
        return categoryRepo.findByName(name);
    }

    public List<Book> findCategoryBooksById(Long id) {
        return categoryRepo.findCategoryBooksById(id);
    }

}
