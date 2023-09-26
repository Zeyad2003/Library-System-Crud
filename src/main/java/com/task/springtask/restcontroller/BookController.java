package com.task.springtask.restcontroller;

import com.task.springtask.entity.Book;
import com.task.springtask.responses.CustomResponse;
import com.task.springtask.service.AuthorService;
import com.task.springtask.service.BookService;
import com.task.springtask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @PostMapping("/books")
    public ResponseEntity<CustomResponse> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return CustomResponse.response("Book added successfully");
    }

    @PutMapping("/books/id/{id}")
    public ResponseEntity<CustomResponse> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully");
    }

    @PutMapping("/books/name/{name}")
    public ResponseEntity<CustomResponse> updateBookByName(@PathVariable String name, @RequestBody Book book) {
        Book updatedBook = bookService.findBookByName(name);
        book.setId(updatedBook.getId());

        bookService.updateBook(book);

        return CustomResponse.response("Book Updated successfully");
    }

    @DeleteMapping("/books/id/{id}")
    public ResponseEntity<CustomResponse> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);

        return CustomResponse.response("Book Deleted successfully");
    }

    @DeleteMapping("/books/name/{name}")
    public ResponseEntity<CustomResponse> deleteBookByName(@PathVariable String name) {
        bookService.deleteBook(name);

        return CustomResponse.response("Book Deleted successfully");
    }

    @GetMapping("/books/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/books/name/{name}")
    public Book getBookByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

}
