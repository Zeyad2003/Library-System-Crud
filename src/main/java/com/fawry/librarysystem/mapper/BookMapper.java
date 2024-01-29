// BookMapper.java
package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "category", source = "categoryDTO")
    BookDTO toDto(Book book);

    List<BookDTO> toDto(List<Book> books);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "category", source = "categoryDTO")
    Book toEntity(BookDTO bookDTO);

    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);

    // Separate method to map CategoryDTO to Category
    default Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        return categoryDTO != null ? Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .build() : null;
    }
}
