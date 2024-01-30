package com.fawry.librarysystem.mapper.book;

import com.fawry.librarysystem.model.dto.book.BookDTO;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "authors", expression = "java(mapAuthorNames(book))")
    BookDTO toDTO(Book book);

    List<BookDTO> toDTO(List<Book> books);

    @Mapping(target = "deleted", ignore = true)
    Book toEntity(BookDTO bookDTO);

    List<Book> toEntity(List<BookDTO> bookDTOs);

    default List<String> mapAuthorNames(Book book) {
        return book.getAuthors().stream().map(Author::getName).collect(Collectors.toList());
    }
}