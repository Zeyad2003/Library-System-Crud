package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "books", expression = "java(mapBookNames(author))")
    AuthorDTO toDTO(Author author);

    List<AuthorDTO> toDTO(List<Author> authors);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    List<Author> toEntity(List<AuthorDTO> authorDTOs);

    default List<String> mapBookNames(Author author) {
        return author.getBooks().stream()
                .filter(book -> !book.getDeleted())
                .map(Book::getName)
                .collect(Collectors.toList());
    }
}