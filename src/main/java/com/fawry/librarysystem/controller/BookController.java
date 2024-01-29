package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.resoponse.CustomResponse;
import com.fawry.librarysystem.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookServiceImpl;

    @PostMapping
    public ResponseEntity<CustomResponse> addBook(@RequestBody Book book) {
        bookServiceImpl.addBook(book);

        return CustomResponse.response("Book added successfully", book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookServiceImpl.findAllBooks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookServiceImpl.updateBook(book);

        return CustomResponse.response("Book Updated successfully", book);
    }

    @PutMapping("/{name}")
    public ResponseEntity<CustomResponse> updateBookByName(@PathVariable String name, @RequestBody Book book) {
        Book updatedBook = bookServiceImpl.findBookByName(name);
        book.setId(updatedBook.getId());

        bookServiceImpl.updateBook(book);

        return CustomResponse.response("Book Updated successfully", book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookServiceImpl.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully", id);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookServiceImpl.findBookById(id);
    }

    @GetMapping("/{id}/authors")
    public List<Author> getBookAuthorsById(@PathVariable Long id) {
        return bookServiceImpl.findBookAuthorsById(id);
    }
}
