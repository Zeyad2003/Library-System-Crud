package com.fawry.librarysystem.mapper.author;

import com.fawry.librarysystem.model.dto.author.AddAuthorDTO;
import com.fawry.librarysystem.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddAuthorMapper {

    AddAuthorDTO toDTO(Author author);

    List<AddAuthorDTO> toDTO(List<Author> authors);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AddAuthorDTO authorDTO);

    List<Author> toEntity(List<AddAuthorDTO> authorDTOs);

}