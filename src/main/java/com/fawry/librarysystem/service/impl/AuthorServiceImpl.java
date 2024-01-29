package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.repository.AuthorRepo;
import com.fawry.librarysystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;

    public void addAuthor(AuthorDTO author) {
        if (authorRepo.findById(author.getId()).isPresent())
            throw new RuntimeException("Author already exists");

        authorRepo.save(authorMapper.toEntity(author));
    }

    public void updateAuthor(AuthorDTO author) {
        authorRepo.save(authorMapper.toEntity(author));
    }

    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

    public Author findAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public List<AuthorDTO> findAllAuthors() {
        return authorMapper.toDTO(authorRepo.findAll());
    }

    public List<Book> findAuthorsByBookId(Long id) {
        return authorRepo.findBooksByAuthorId(id);
    }
}
