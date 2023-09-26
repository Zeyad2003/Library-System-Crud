package com.task.springtask.service;

import com.task.springtask.entity.Category;
import com.task.springtask.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
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

}
