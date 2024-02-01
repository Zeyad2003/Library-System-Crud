package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.model.response.CustomResponse;
import com.fawry.librarysystem.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
@Tag(name = "Book", description = "The Book API")
public class BookController {
    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Retrieve all books", description = "Get a list of all books.")
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks(Boolean.FALSE);
    }

    @GetMapping("/deleted")
    @Operation(summary = "Get a list of all deleted books", description = "Showing the deleted books to make it easier to restore them.")
    public List<BookDTO> getAllDeletedBooks() {
        return bookService.findAllBooks(Boolean.TRUE);
    }

    @PutMapping("/{id}/restore")
    @Operation(summary = "Restore a deleted book", description = "Restore a previously deleted book by their ID.")
    public ResponseEntity<CustomResponse> restoreBookById(@PathVariable Long id) {
        bookService.restoreBook(id);
        return CustomResponse.response("Book restored successfully", HttpStatus.OK.value(), null);
    }

    @PostMapping
    @Operation(summary = "Create a new book", description = "Add a new book to the system.")
    public ResponseEntity<CustomResponse> addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);
        return CustomResponse.response("Book added successfully", HttpStatus.OK.value(), book);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update book by ID", description = "Update the information of a book by their ID.")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @Valid @RequestBody BookDTO book) {
        book.setId(id);
        bookService.updateBook(id, book);
        return CustomResponse.response("Book Updated successfully", HttpStatus.OK.value(), book);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by ID", description = "Apply Soft-Delete on a book by their ID.")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
        return CustomResponse.response("Book Deleted successfully", HttpStatus.OK.value(), id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieve a book by their ID.")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping(params = "name")
    @Operation(summary = "Get book by name", description = "Retrieve a book by their name using request param ?name={name}.")
    public BookDTO getBookByName(@RequestParam String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/{id}/authors")
    @Operation(summary = "Get authors by book ID", description = "Retrieve all authors associated with a specific book by their ID.")
    public List<AuthorDTO> getBookAuthorsById(@PathVariable Long id) {
        return bookService.findBookAuthorsById(id);
    }
}