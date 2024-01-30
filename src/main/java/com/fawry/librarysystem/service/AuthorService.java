package com.fawry.librarysystem.service;

import com.fawry.librarysystem.model.dto.author.AddAuthorDTO;
import com.fawry.librarysystem.model.dto.author.AuthorDTO;
import com.fawry.librarysystem.model.dto.book.BookDTO;

import java.util.List;

public interface AuthorService {

    void addAuthor(AddAuthorDTO author);

    void updateAuthor(AuthorDTO author);

    void deleteAuthor(Long id);

    AuthorDTO findAuthorById(Long id);

    List<AuthorDTO> findAllAuthors(Boolean isDeleted);

    List<BookDTO> findAuthorsByBookId(Long id);
}