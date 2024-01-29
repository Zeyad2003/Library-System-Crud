package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.response.CustomResponse;
import com.fawry.librarysystem.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<CustomResponse> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return CustomResponse.response("Book added successfully", book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully", book);
    }

    @PutMapping("/{name}")
    public ResponseEntity<CustomResponse> updateBookByName(@PathVariable String name, @RequestBody Book book) {
        Book updatedBook = bookService.findBookByName(name);
        book.setId(updatedBook.getId());

        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully", book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully", id);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/{id}/authors")
    public List<Author> getBookAuthorsById(@PathVariable Long id) {
        return bookService.findBookAuthorsById(id);
    }
}
