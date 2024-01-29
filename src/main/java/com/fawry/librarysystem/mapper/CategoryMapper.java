package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.CategoryDTO;
import com.fawry.librarysystem.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTO(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);

    List<Category> toEntity(List<CategoryDTO> categoryDTOs);
}