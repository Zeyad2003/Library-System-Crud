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
    }
}
