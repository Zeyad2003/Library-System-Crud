package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {
    AuthorDTO toDto(Author author);

    List<AuthorDTO> toDto(List<Author> authors);

    Author toEntity(AuthorDTO authorDto);

    List<Author> toEntity(List<AuthorDTO> authorDto);
}