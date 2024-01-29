package com.fawry.librarysystem.service;

import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    public void addAuthor(AuthorDTO author) {
        if(author.getId() != null && authorRepo.findById(author.getId()).isPresent()) {
            throw new RuntimeException("Author ID must be null");
        }

        authorRepo.save(authorMapper.toEntity(author));
    }

    public void updateAuthor(AuthorDTO author) {
        if(author.getId() == null || !authorRepo.findById(author.getId()).isPresent()) {
            throw new RuntimeException("Can't find the author");
        }

        authorMapper.toDto(authorRepo.save(authorMapper.toEntity(author)));
    }

    public void deleteAuthor(Long id) {
        if(!authorRepo.findById(id).isPresent()) {
            throw new RuntimeException("Can't find the author");
        }

        authorRepo.deleteById(id);
    }

    public AuthorDTO findAuthorById(Long id) {
        if(!authorRepo.findById(id).isPresent()) {
            throw new RuntimeException("Can't find the author");
        }

        return authorMapper.toDto(authorRepo.findById(id).get());
    }

    public List<AuthorDTO> findAllAuthors() {
        return authorMapper.toDto(authorRepo.findAll());
    }

    public List<BookDTO> findBooksByAuthorId(Long id) {
        if(!authorRepo.findById(id).isPresent()) {
            throw new RuntimeException("Can't find the author");
        }

        return bookMapper.toDto(authorRepo.findBooksByAuthorId(id));
    }
}
