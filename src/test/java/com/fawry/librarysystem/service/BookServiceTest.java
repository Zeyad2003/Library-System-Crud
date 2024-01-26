//package com.fawry.librarysystem.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.fawry.librarysystem.entity.Book;
//import com.fawry.librarysystem.entity.Category;
//import com.fawry.librarysystem.repository.BookRepo;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {BookService.class})
//@ExtendWith(SpringExtension.class)
//class BookServiceTest {
//    @MockBean
//    private BookRepo bookRepo;
//
//    @Autowired
//    private BookService bookService;
//
//    /**
//     * Method under test: {@link BookService#addBook(Book)}
//     */
//    @Test
//    void testAddBook() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//
//        Book book = new Book();
//        book.setAuthors(new ArrayList<>());
//        book.setCategory(category);
//        book.setId(1L);
//        book.setName("Name");
//        book.setPrice(BigDecimal.valueOf(10.0));
//        when(bookRepo.save(Mockito.any())).thenReturn(book);
//
//        Category category2 = new Category();
//        ArrayList<Book> books = new ArrayList<>();
//        category2.setBooks(books);
//        category2.setDescription("The characteristics of someone or something");
//        category2.setId(1L);
//        category2.setName("Name");
//
//        Book book2 = new Book();
//        book2.setAuthors(new ArrayList<>());
//        book2.setCategory(category2);
//        book2.setId(1L);
//        book2.setName("Name");
//        book2.setPrice(BigDecimal.valueOf(10.0d));
//        bookService.addBook(book2);
//        verify(bookRepo).save(Mockito.any());
//        assertEquals(books, book2.getAuthors());
//        assertEquals(10.0d, book2.getPrice());
//        assertEquals("Name", book2.getName());
//        assertEquals(1L, book2.getId().longValue());
//        assertEquals(category, book2.getCategory());
//    }
//
//    /**
//     * Method under test: {@link BookService#updateBook(Book)}
//     */
//    @Test
//    void testUpdateBook() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//
//        Book book = new Book();
//        book.setAuthors(new ArrayList<>());
//        book.setCategory(category);
//        book.setId(1L);
//        book.setName("Name");
//        book.setPrice(BigDecimal.valueOf(10.0d));
//        when(bookRepo.save(Mockito.any())).thenReturn(book);
//
//        Category category2 = new Category();
//        ArrayList<Book> books = new ArrayList<>();
//        category2.setBooks(books);
//        category2.setDescription("The characteristics of someone or something");
//        category2.setId(1L);
//        category2.setName("Name");
//
//        Book book2 = new Book();
//        book2.setAuthors(new ArrayList<>());
//        book2.setCategory(category2);
//        book2.setId(1L);
//        book2.setName("Name");
//        book2.setPrice(BigDecimal.valueOf(10.0d));
//        bookService.updateBook(book2);
//        verify(bookRepo).save(Mockito.any());
//        assertEquals(books, book2.getAuthors());
//        assertEquals(10.0d, book2.getPrice());
//        assertEquals("Name", book2.getName());
//        assertEquals(1L, book2.getId().longValue());
//        assertEquals(category, book2.getCategory());
//    }
//
//    /**
//     * Method under test: {@link BookService#deleteBook(Long)}
//     */
//    @Test
//    void testDeleteBook() {
//        doNothing().when(bookRepo).deleteById(Mockito.any());
//        bookService.deleteBook(1L);
//        verify(bookRepo).deleteById(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link BookService#deleteBook(String)}
//     */
//    @Test
//    void testDeleteBook2() {
//        doNothing().when(bookRepo).deleteByName(Mockito.any());
//        bookService.deleteBook("Name");
//        verify(bookRepo).deleteByName(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link BookService#findBookById(Long)}
//     */
//    @Test
//    void testFindBookById() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//
//        Book book = new Book();
//        book.setAuthors(new ArrayList<>());
//        book.setCategory(category);
//        book.setId(1L);
//        book.setName("Name");
//        book.setPrice(BigDecimal.valueOf(10.0d));
//        Optional<Book> ofResult = Optional.of(book);
//        when(bookRepo.findById(Mockito.any())).thenReturn(ofResult);
//        assertSame(book, bookService.findBookById(1L));
//        verify(bookRepo).findById(Mockito.any());
//    }
//
//    /**
//     * Method under test: {@link BookService#findAllBooks()}
//     */
//    @Test
//    void testFindAllBooks() {
//        ArrayList<Book> bookList = new ArrayList<>();
//        when(bookRepo.findAll()).thenReturn(bookList);
//        List<Book> actualFindAllBooksResult = bookService.findAllBooks();
//        assertSame(bookList, actualFindAllBooksResult);
//        assertTrue(actualFindAllBooksResult.isEmpty());
//        verify(bookRepo).findAll();
//    }
//
//    /**
//     * Method under test: {@link BookService#findBookByName(String)}
//     */
//    @Test
//    void testFindBookName() {
//        Category category = new Category();
//        category.setBooks(new ArrayList<>());
//        category.setDescription("The characteristics of someone or something");
//        category.setId(1L);
//        category.setName("Name");
//
//        Book book = new Book();
//        book.setAuthors(new ArrayList<>());
//        book.setCategory(category);
//        book.setId(1L);
//        book.setName("Name");
//        book.setPrice(BigDecimal.valueOf(10.0d));
//        when(bookRepo.findByName(Mockito.any())).thenReturn(book);
//        assertSame(book, bookService.findBookByName("Name"));
//        verify(bookRepo).findByName(Mockito.any());
//    }
//}
//
