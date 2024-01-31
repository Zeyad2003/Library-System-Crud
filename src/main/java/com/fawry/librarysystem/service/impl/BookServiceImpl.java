package com.fawry.librarysystem.service.impl;

import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import com.fawry.librarysystem.mapper.AuthorMapper;
import com.fawry.librarysystem.mapper.BookMapper;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.dto.CategoryDTO;
import com.fawry.librarysystem.repository.BookRepo;
import com.fawry.librarysystem.repository.CategoryRepo;
import com.fawry.librarysystem.service.BookService;
import com.fawry.librarysystem.service.CategoryService;
import com.fawry.librarysystem.util.Utility;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final EntityManager entityManager;
    private final CategoryRepo categoryRepo;
    private final CategoryService categoryService;

    public void addBook(BookDTO book) {
        Book savedBook = bookMapper.toEntity(book);
        savedBook.setDeleted(Boolean.FALSE);
        bookRepo.save(savedBook);
        Category category = categoryRepo.findByName(book.getCategory());

        associateBookWithCategory(savedBook.getId(), category.getId());

        book.setId(savedBook.getId());
    }

    public void updateBook(Long id, BookDTO book) {
        Utility.checkIfIdExists(bookRepo, id);
        Book savedBook = bookRepo.findById(id).get();
        savedBook.setName(book.getName());
        savedBook.setPrice(book.getPrice());

        updateCategoryHandler(savedBook, book);

        bookRepo.save(savedBook);
    }

    public void deleteBook(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        bookRepo.delete(bookRepo.findById(id).get());
    }

    public void restoreBook(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        Book book = bookRepo.findById(id).get();
        book.setDeleted(Boolean.FALSE);
        bookRepo.save(book);
    }

    public BookDTO findBookById(Long id) {
        Utility.checkIfIdExists(bookRepo, id);
        Book book = bookRepo.findById(id).get();

        return bookMapper.toDTO(book);
    }

    public BookDTO findBookByName(String name) {
        return bookMapper.toDTO(bookRepo.findByName(name));
    }

    public List<BookDTO> findAllBooks(Boolean deleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("bookDeletedFilter");
        filter.setParameter("deleted", deleted);
        List<Book> books = bookRepo.findAll();
        session.disableFilter("bookDeletedFilter");
        return bookMapper.toDTO(books);
    }

    public List<AuthorDTO> findBookAuthorsById(Long id) {
        return authorMapper.toDTO(bookRepo.findBookAuthorsById(id));
    }

    public void associateBookWithCategory(Long bookId, Long categoryId) {
        Utility.checkIfIdExists(bookRepo, bookId);
        Utility.checkIfIdExists(categoryRepo, categoryId);
        Book book = bookRepo.findById(bookId).get();
        Category category = categoryRepo.findById(categoryId).get();
        book.setCategory(category);
        category.getBooks().add(book);
        bookRepo.save(book);
        categoryRepo.save(category);
    }

    public void dissociateBookWithCategory(Long bookId, Long categoryId) {
        Utility.checkIfIdExists(bookRepo, bookId);
        Utility.checkIfIdExists(categoryRepo, categoryId);
        Book book = bookRepo.findById(bookId).get();
        Category category = categoryRepo.findById(categoryId).get();
        if (book.getCategory() != null && book.getCategory().equals(category)) {
            book.setCategory(null);
            category.getBooks().remove(book);
            bookRepo.save(book);
            categoryRepo.save(category);
        }
    }

    private void updateCategoryHandler(Book savedBook, BookDTO book) {
        if (!book.getCategory().equals(savedBook.getName())) {
            dissociateBookWithCategory(savedBook.getId(), savedBook.getCategory().getId());
            if (categoryRepo.findByName(book.getCategory()) == null) {
                categoryService.addCategory(
                        CategoryDTO.builder()
                                .name(book.getCategory())
                                .description("No Description Yet!!")
                                .build()
                );
            }
            Category category = categoryRepo.findByName(book.getCategory());
            associateBookWithCategory(savedBook.getId(), category.getId());
        }
    }
}
