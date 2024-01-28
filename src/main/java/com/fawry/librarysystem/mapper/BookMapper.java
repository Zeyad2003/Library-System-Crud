package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.BookDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {
    BookDTO toDto(Book book);

    List<BookDTO> toDto(List<Book> books);

    Book toEntity(BookDTO bookDto);

    List<Book> toEntity(List<BookDTO> bookDto);
}