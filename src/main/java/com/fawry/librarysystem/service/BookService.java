package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    void deleteBook(String name);

    Book findBookById(Long id);

    List<Book> findAllBooks();

    Book findBookByName(String name);

    List<Author> findBookAuthorsById(Long id);

}