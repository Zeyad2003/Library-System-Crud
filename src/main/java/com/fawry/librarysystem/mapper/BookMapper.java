package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);

    List<BookDTO> toDTO(List<Book> books);

    @Mapping(target = "deleted", ignore = true)
    Book toEntity(BookDTO bookDTO);

    List<Book> toEntity(List<BookDTO> bookDTOs);
}