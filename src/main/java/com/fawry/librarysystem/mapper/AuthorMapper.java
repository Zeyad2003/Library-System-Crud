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

    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    void updateAuthorFromDTO(AuthorDTO authorDTO, @MappingTarget Author author);
}
