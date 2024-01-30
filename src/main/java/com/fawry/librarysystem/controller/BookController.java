package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.response.CustomResponse;
import com.fawry.librarysystem.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<CustomResponse> addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);

        return CustomResponse.response("Book added successfully", HttpStatus.OK.value(), book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully", HttpStatus.OK.value(), book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully", HttpStatus.OK.value(), id);
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
