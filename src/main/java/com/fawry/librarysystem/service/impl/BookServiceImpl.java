package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.repository.BookRepo;
import com.fawry.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteBook(String name) {
        bookRepository.deleteByName(name);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Author> findBookAuthorsById(Long id) {
        return bookRepository.findBookAuthorsById(id);
    }
}
