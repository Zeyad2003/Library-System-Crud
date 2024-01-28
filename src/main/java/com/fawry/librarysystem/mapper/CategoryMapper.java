package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {
    CategoryDTO toDto(Category category);

    List<CategoryDTO> toDto(List<Category> categories);

    Category toEntity(CategoryDTO categoryDto);

    List<Category> toEntity(List<CategoryDTO> categoryDto);
}