package com.fawry.librarysystem.service;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;

import java.util.List;

public interface AuthorService {

    void addAuthor(AuthorDTO author);

    void deleteAuthor(Long id);

    void restoreAuthor(Long id);

    AuthorDTO findAuthorById(Long id);

    AuthorDTO findAuthorByName(String name);

    List<AuthorDTO> findAllAuthors(Boolean deleted);

    List<BookDTO> findAuthorBooksById(Long id);

    void associateBookWithAuthor(Long authorId, Long bookId);

}