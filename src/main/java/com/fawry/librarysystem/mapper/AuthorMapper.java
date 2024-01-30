package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    List<AuthorDTO> toDTO(List<Author> authors);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    List<Author> toEntity(List<AuthorDTO> authorDTOs);

}