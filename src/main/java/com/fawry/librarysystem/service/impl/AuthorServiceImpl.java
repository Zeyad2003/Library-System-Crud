package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.mapper.author.AuthorMapper;
import com.fawry.librarysystem.mapper.book.BookMapper;
import com.fawry.librarysystem.model.dto.author.AddAuthorDTO;
import com.fawry.librarysystem.model.dto.author.AuthorDTO;
import com.fawry.librarysystem.model.dto.book.BookDTO;
import com.fawry.librarysystem.repository.AuthorRepo;
import com.fawry.librarysystem.service.AuthorService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.hibernate.Filter;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final EntityManager entityManager;

    public void addAuthor(AddAuthorDTO author) {
        Author savedAuthor = authorMapper.toEntity(author);
        savedAuthor.setDeleted(false);
        authorRepo.save(savedAuthor);
    }

    public void updateAuthor(AuthorDTO author) {
        authorRepo.save(authorMapper.toEntity(author));
    }

    public void deleteAuthor(Long id) {
        Optional<Author> author = authorRepo.findById(id);
        authorRepo.delete(author.orElseThrow(() -> new RuntimeException("Author not found")));
    }

    public AuthorDTO findAuthorById(Long id) {
        Author author = authorRepo.findById(id).orElse(null);

        return authorMapper.toDTO(author);
    }

    public List<AuthorDTO> findAllAuthors(Boolean deleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("authorDeletedFilter");
        filter.setParameter("deleted", deleted);
        List<Author> authors = authorRepo.findAll();
        session.disableFilter("authorDeletedFilter");
        return authorMapper.toDTO(authors);
    }

    public List<BookDTO> findAuthorsByBookId(Long id) {
        return bookMapper.toDTO(authorRepo.findBooksByAuthorId(id));
    }
}
