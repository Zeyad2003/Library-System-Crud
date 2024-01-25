package com.task.springtask.resource;

import com.task.springtask.entity.Author;
import com.task.springtask.model.CustomResponse;
import com.task.springtask.service.AuthorService;
import com.task.springtask.service.BookService;
import com.task.springtask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public AuthorController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CustomResponse> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);

        return CustomResponse.response("Author added successfully");
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateAuthorById(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully");
    }

    @PutMapping("/{name}")
    public ResponseEntity<CustomResponse> updateAuthorByName(@PathVariable String name, @RequestBody Author author) {
        Author updatedAuthor = authorService.findAuthorByName(name);
        author.setId(updatedAuthor.getId());

        authorService.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);

        return CustomResponse.response("Author Deleted successfully");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<CustomResponse> deleteAuthorByName(@PathVariable String name) {
        authorService.deleteAuthor(name);

        return CustomResponse.response("Author Deleted successfully");
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authorService.findAuthorByName(name);
    }

}
