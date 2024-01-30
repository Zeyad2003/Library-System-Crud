package com.fawry.librarysystem.service;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;

import java.util.List;

public interface AuthorService {

    void addAuthor(AuthorDTO author);

    void deleteAuthor(Long id);

    AuthorDTO findAuthorById(Long id);

    List<AuthorDTO> findAllAuthors(Boolean isDeleted);

    List<BookDTO> findAuthorsByBookId(Long id);
}