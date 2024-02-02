package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.exception.IdNotFoundException;
import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.repository.AuthorRepo;
import com.fawry.librarysystem.repository.BookRepo;
import com.fawry.librarysystem.service.AuthorService;
import com.fawry.librarysystem.util.Utility;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.hibernate.Filter;
import org.hibernate.Session;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final EntityManager entityManager;

    public void addAuthor(AuthorDTO author) {
        Author savedAuthor = authorMapper.toEntity(author);
        savedAuthor.setDeleted(Boolean.FALSE);
        authorRepo.save(savedAuthor);
        author.setId(savedAuthor.getId());
    }

    public void deleteAuthor(Long id) {
        Utility.checkIfIdExists(authorRepo, id);
        authorRepo.delete(authorRepo.findById(id).get());
    }

    public void restoreAuthor(Long id) {
        Utility.checkIfIdExists(authorRepo, id);
        Author author = authorRepo.findById(id).get();
        author.setDeleted(Boolean.FALSE);
        authorRepo.save(author);
    }

    public AuthorDTO findAuthorById(Long id) {
        Utility.checkIfIdExists(authorRepo, id);
        Author author = authorRepo.findById(id).get();
        if(author.getDeleted())
            throw new IdNotFoundException("Author is deleted, try restoring it first.");

        return authorMapper.toDTO(author);
    }

    public AuthorDTO findAuthorByName(String name) {
        return authorMapper.toDTO(authorRepo.findByName(name));
    }

    public List<AuthorDTO> findAllAuthors(Boolean deleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("authorDeletedFilter");
        filter.setParameter("deleted", deleted);
        List<Author> authors = authorRepo.findAll();
        session.disableFilter("authorDeletedFilter");
        return authorMapper.toDTO(authors);
    }

    public List<BookDTO> findAuthorBooksById(Long id) {
        return bookMapper.toDTO(authorRepo.findAuthorBooksById(id));
    }

    public void associateBookWithAuthor(Long authorId, Long bookId) {
        Utility.checkIfIdExists(authorRepo, authorId);
        Utility.checkIfIdExists(bookRepo, bookId);
        Author author = authorRepo.findById(authorId).get();
        Book book = bookRepo.findById(bookId).get();
        author.getBooks().add(book);
        book.getAuthors().add(author);
        authorRepo.save(author);
        bookRepo.save(book);
    }
}
