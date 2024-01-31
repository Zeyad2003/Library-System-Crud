package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.mapper.CategoryMapper;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import com.fawry.librarysystem.repository.CategoryRepo;
import com.fawry.librarysystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;
    private final BookMapper bookMapper;

    public void addCategory(CategoryDTO category) {
        categoryRepo.save(categoryMapper.toEntity(category));
    }

    public void updateCategory(CategoryDTO category) {
        categoryRepo.save(categoryMapper.toEntity(category));
    }

    public CategoryDTO findCategoryById(Long id) {
        return categoryMapper.toDTO(categoryRepo.findById(id).orElse(null));
    }

    public CategoryDTO findCategoryByName(String name) {
        return categoryMapper.toDTO(categoryRepo.findByName(name));
    }

    public List<CategoryDTO> findAllCategories() {
        return categoryMapper.toDTO(categoryRepo.findAll());
    }

    public List<BookDTO> findCategoryBooksById(Long id) {
        return bookMapper.toDTO(categoryRepo.findCategoryBooksById(id));
    }
}
