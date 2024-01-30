package com.fawry.librarysystem.mapper.author;

import com.fawry.librarysystem.model.dto.author.AuthorDTO;
import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    @Mapping(target = "books", expression = "java(mapBookNames(author))")
    List<AuthorDTO> toDTO(List<Author> authors);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    List<Author> toEntity(List<AuthorDTO> authorDTOs);

    default List<String> mapBookNames(Author author) {
        return author.getBooks().stream().map(Book::getName).collect(Collectors.toList());
    }
}