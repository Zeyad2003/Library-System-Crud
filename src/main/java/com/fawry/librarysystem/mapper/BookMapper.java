<<<<<<< HEAD
package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.BookAuthorsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorsDetails", expression = "java(mapAuthorsData(book))")
    BookDTO toDTO(Book book);

    List<BookDTO> toDTO(List<Book> books);

    @Mapping(target = "authors", ignore = true)
    Book toEntity(BookDTO bookDTO);

    List<Book> toEntity(List<BookDTO> bookDTOs);

    default List<BookAuthorsDTO> mapAuthorsData(Book book) {
        return book.getAuthors().stream().map(author -> BookAuthorsDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .build()).collect(Collectors.toList());
=======
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
>>>>>>> master
    }
}
