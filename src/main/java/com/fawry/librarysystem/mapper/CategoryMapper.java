// CategoryMapper.java
package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
