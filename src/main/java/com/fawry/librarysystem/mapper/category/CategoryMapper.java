package com.fawry.librarysystem.mapper.category;

import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.category.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTO(List<Category> categories);

    @Mapping(target = "books", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);

    List<Category> toEntity(List<CategoryDTO> categoryDTOs);
}