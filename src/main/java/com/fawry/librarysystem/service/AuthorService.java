package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

    public void deleteAuthor(String name) {
        authorRepo.deleteByName(name);
    }

    public Author findAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public Author findAuthorByName(String name) {
        return authorRepo.findByName(name);
    }

    public List<Book> findAuthorsByBookId(Long id) {
        return authorRepo.findAuthorsByBookId(id);
    }
}
