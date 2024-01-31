package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;

import java.util.List;

public interface BookService {
    void addBook(BookDTO book);

    void updateBook(Long id, BookDTO book);

    void deleteBook(Long id);

    void restoreBook(Long id);

    BookDTO findBookById(Long id);

    BookDTO findBookByName(String name);

    List<BookDTO> findAllBooks(Boolean deleted);

    List<AuthorDTO> findBookAuthorsById(Long id);

    void associateBookWithCategory(Book book, Category category);

    void dissociateBookWithCategory(Book book, Category category);

}