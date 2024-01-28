package com.fawry.librarysystem.resource;

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

        return CustomResponse.response("Book added successfully");
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully");
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<CustomResponse> updateBookByName(@PathVariable String name, @RequestBody Book book) {
        Book updatedBook = bookService.findBookByName(name);
        book.setId(updatedBook.getId());

        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully");
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<CustomResponse> deleteBookByName(@PathVariable String name) {
        bookService.deleteBook(name);

        return CustomResponse.response("Book Deleted successfully");
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/name/{name}")
    public Book getBookByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/{id}/authors")
    public List<Author> getBookAuthorsById(@PathVariable Long id) {
        return bookService.findBookAuthorsById(id);
    }
}
