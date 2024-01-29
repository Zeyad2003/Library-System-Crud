<<<<<<< HEAD
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
=======
// AuthorMapper.java
package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(target = "books", ignore = true)
    AuthorDTO toDto(Author author);

    List<AuthorDTO> toDto(List<Author> authors);
>>>>>>> master

    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

<<<<<<< HEAD
    List<Author> toEntity(List<AuthorDTO> authorDTOs);

    default List<String> mapBookNames(Author author) {
        return author.getBooks().stream().map(Book::getName).collect(Collectors.toList());
    }

=======
    void updateAuthorFromDTO(AuthorDTO authorDTO, @MappingTarget Author author);
>>>>>>> master
}
