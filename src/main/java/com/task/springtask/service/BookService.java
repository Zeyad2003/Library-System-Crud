package com.task.springtask.service;

import com.task.springtask.entity.Book;
import com.task.springtask.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepository;

    @Autowired
    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

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

}
