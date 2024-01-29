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

    @Mapping(target = "booksNames", expression = "java(mapBookNames(author))")
    AuthorDTO toDTO(Author author);

    List<AuthorDTO> toDTO(List<Author> authors);

    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    List<Author> toEntity(List<AuthorDTO> authorDTOs);

    default List<String> mapBookNames(Author author) {
        return author.getBooks().stream().map(Book::getName).collect(Collectors.toList());
    }

}