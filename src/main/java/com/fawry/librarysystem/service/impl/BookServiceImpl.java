package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.repository.BookRepo;
import com.fawry.librarysystem.service.BookService;
import com.fawry.librarysystem.util.Utility;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final EntityManager entityManager;

    public void addBook(BookDTO book) {
        Book savedBook = bookMapper.toEntity(book);
        savedBook.setDeleted(Boolean.FALSE);
        bookRepo.save(savedBook);
        book.setId(savedBook.getId());
    }

    public void deleteBook(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        bookRepo.delete(bookRepo.findById(id).get());
    }

    public void restoreBook(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        Book book = bookRepo.findById(id).get();
        book.setDeleted(Boolean.FALSE);
        bookRepo.save(book);
    }

    public BookDTO findBookById(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        Book book = bookRepo.findById(id).get();

        return bookMapper.toDTO(book);
    }

    public List<BookDTO> findAllBooks(Boolean deleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("bookDeletedFilter");
        filter.setParameter("deleted", deleted);
        List<Book> books = bookRepo.findAll();
        session.disableFilter("bookDeletedFilter");
        return bookMapper.toDTO(books);
    }

    public List<AuthorDTO> findBookAuthorsById(Long id) {
        return authorMapper.toDTO(bookRepo.findBookAuthorsById(id));
    }
}
