package com.task.springtask.service;

import com.task.springtask.entity.Author;
import com.task.springtask.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepo authorRepo;

    @Autowired
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

}
