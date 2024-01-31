package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.response.CustomResponse;
import com.fawry.librarysystem.service.BookService;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks(Boolean.FALSE);
    }

    @GetMapping("/deleted")
    public List<BookDTO> getAllDeletedBooks() {
        return bookService.findAllBooks(Boolean.TRUE);
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<CustomResponse> restoreBookById(@PathVariable Long id) {
        bookService.restoreBook(id);

        return CustomResponse.response("Book restored successfully", HttpStatus.OK.value(), null);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);

        return CustomResponse.response("Book added successfully", HttpStatus.OK.value(), book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @Valid @RequestBody BookDTO book) {
        book.setId(id);
        bookService.updateBook(id, book);

        return CustomResponse.response("Book Updated successfully", HttpStatus.OK.value(), book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully", HttpStatus.OK.value(), id);
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping(params = "name")
    public BookDTO getBookByName(@RequestParam String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/{id}/authors")
    public List<AuthorDTO> getBookAuthorsById(@PathVariable Long id) {
        return bookService.findBookAuthorsById(id);
    }

}
