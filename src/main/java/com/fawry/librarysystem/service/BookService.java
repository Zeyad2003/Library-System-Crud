package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
<<<<<<< HEAD

import java.util.List;

public interface BookService {
    void addBook(Book book);
=======
import com.fawry.librarysystem.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
>>>>>>> master

    void updateBook(Book book);

<<<<<<< HEAD
    void deleteBook(Long id);

    void deleteBook(String name);
=======
    public void addBook(Book book) {
        bookRepository.save(book);
    }
>>>>>>> master

    Book findBookById(Long id);

    List<Book> findAllBooks();

    Book findBookByName(String name);

    List<Author> findBookAuthorsById(Long id);

}
