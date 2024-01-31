package com.fawry.librarysystem.mapper;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.repository.CategoryRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authors", expression = "java(mapAuthorsNames(book))")
    @Mapping(target = "category", expression = "java(book.getCategory().getName())")
    BookDTO toDTO(Book book);

    List<BookDTO> toDTO(List<Book> books);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "authors", ignore = true)
    Book toEntity(BookDTO bookDTO);

    List<Book> toEntity(List<BookDTO> bookDTOs);

    default List<String> mapAuthorsNames(Book book) {
        return book.getAuthors().stream().map(Author::getName).collect(Collectors.toList());
    }

}