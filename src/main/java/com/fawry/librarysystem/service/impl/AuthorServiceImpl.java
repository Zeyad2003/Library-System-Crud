package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
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

    public void addAuthor(AuthorDTO author) {
        Author savedAuthor = authorMapper.toEntity(author);
        savedAuthor.setDeleted(Boolean.FALSE);
        authorRepo.save(savedAuthor);
        author.setId(savedAuthor.getId());
    }

    public void deleteAuthor(Long id) {
        Optional<Author> author = authorRepo.findById(id);
        authorRepo.delete(author.orElseThrow(() -> new RuntimeException("Author not found")));
    }

    public AuthorDTO findAuthorById(Long id) {
        Author author = authorRepo.findById(id).get();

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
