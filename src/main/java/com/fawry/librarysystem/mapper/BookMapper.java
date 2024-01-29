package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorsNames", expression = "java(mapAuthorNames(book))")
    BookDTO toDTO(Book book);

    @Mapping(target = "authors", ignore = true)
    Book toEntity(BookDTO bookDTO);

    default List<String> mapAuthorNames(Book book) {
        return book.getAuthors().stream().map(Author::getName).collect(Collectors.toList());
    }
}
