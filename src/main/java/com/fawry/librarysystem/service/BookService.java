package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.book.BookDTO;

import java.util.List;

public interface BookService {
    void addBook(BookDTO book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Book findBookById(Long id);

    List<Book> findAllBooks();

    List<Author> findBookAuthorsById(Long id);

}