package com.task.springtask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.task.springtask.entity.Author;
import com.task.springtask.entity.Book;
import com.task.springtask.repository.AuthorRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthorService.class})
@ExtendWith(SpringExtension.class)
class AuthorServiceTest {
    @MockBean
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorService authorService;

    /**
     * Method under test: {@link AuthorService#addAuthor(Author)}
     */
    @Test
    void testAddAuthor() {
        Author author = new Author();
        ArrayList<Book> books = new ArrayList<>();
        author.setBooks(books);
        author.setEmail("jane.doe@example.org");
        author.setId(1L);
        author.setName("Name");
        when(authorRepo.save(Mockito.<Author>any())).thenReturn(author);

        Author author2 = new Author();
        author2.setBooks(new ArrayList<>());
        author2.setEmail("jane.doe@example.org");
        author2.setId(1L);
        author2.setName("Name");
        authorService.addAuthor(author2);
        verify(authorRepo).save(Mockito.<Author>any());
        assertEquals(books, author2.getBooks());
        assertEquals("Name", author2.getName());
        assertEquals(1L, author2.getId().longValue());
        assertEquals("jane.doe@example.org", author2.getEmail());
        assertTrue(authorService.findAllAuthors().isEmpty());
    }

    /**
     * Method under test: {@link AuthorService#updateAuthor(Author)}
     */
    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setBooks(new ArrayList<>());
        author.setEmail("jane.doe@example.org");
        author.setId(1L);
        author.setName("Name");
        when(authorRepo.save(Mockito.<Author>any())).thenReturn(author);

        Author author2 = new Author();
        author2.setBooks(new ArrayList<>());
        author2.setEmail("jane.doe@example.org");
        author2.setId(1L);
        author2.setName("Name");
        assertSame(author, authorService.updateAuthor(author2));
        verify(authorRepo).save(Mockito.<Author>any());
    }

    /**
     * Method under test: {@link AuthorService#deleteAuthor(Long)}
     */
    @Test
    void testDeleteAuthor() {
        doNothing().when(authorRepo).deleteById(Mockito.<Long>any());
        authorService.deleteAuthor(1L);
        verify(authorRepo).deleteById(Mockito.<Long>any());
        assertTrue(authorService.findAllAuthors().isEmpty());
    }

    /**
     * Method under test: {@link AuthorService#deleteAuthor(String)}
     */
    @Test
    void testDeleteAuthor2() {
        doNothing().when(authorRepo).deleteByName(Mockito.<String>any());
        authorService.deleteAuthor("Name");
        verify(authorRepo).deleteByName(Mockito.<String>any());
        assertTrue(authorService.findAllAuthors().isEmpty());
    }

    /**
     * Method under test: {@link AuthorService#findAuthorById(Long)}
     */
    @Test
    void testFindAuthorById() {
        Author author = new Author();
        author.setBooks(new ArrayList<>());
        author.setEmail("jane.doe@example.org");
        author.setId(1L);
        author.setName("Name");
        Optional<Author> ofResult = Optional.of(author);
        when(authorRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(author, authorService.findAuthorById(1L));
        verify(authorRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AuthorService#findAllAuthors()}
     */
    @Test
    void testFindAllAuthors() {
        ArrayList<Author> authorList = new ArrayList<>();
        when(authorRepo.findAll()).thenReturn(authorList);
        List<Author> actualFindAllAuthorsResult = authorService.findAllAuthors();
        assertSame(authorList, actualFindAllAuthorsResult);
        assertTrue(actualFindAllAuthorsResult.isEmpty());
        verify(authorRepo).findAll();
    }

    /**
     * Method under test: {@link AuthorService#findAuthorByName(String)}
     */
    @Test
    void testFindAuthorByName() {
        Author author = new Author();
        author.setBooks(new ArrayList<>());
        author.setEmail("jane.doe@example.org");
        author.setId(1L);
        author.setName("Name");
        when(authorRepo.findByName(Mockito.<String>any())).thenReturn(author);
        assertSame(author, authorService.findAuthorByName("Name"));
        verify(authorRepo).findByName(Mockito.<String>any());
    }
}

