package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    void addAuthor(AuthorDTO author);

    void updateAuthor(AuthorDTO author);

    void deleteAuthor(Long id);

    Author findAuthorById(Long id);

    List<AuthorDTO> findAllAuthors();

    List<Book> findAuthorsByBookId(Long id);
}
