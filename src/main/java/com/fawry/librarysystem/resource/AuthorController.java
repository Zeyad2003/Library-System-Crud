package com.fawry.librarysystem.resource;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.service.AuthorService;
import com.fawry.librarysystem.model.response.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<CustomResponse> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);

        return CustomResponse.response("Author added successfully");
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<CustomResponse> updateAuthorById(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully");
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<CustomResponse> updateAuthorByName(@PathVariable String name, @RequestBody Author author) {
        Author updatedAuthor = authorService.findAuthorByName(name);
        author.setId(updatedAuthor.getId());

        authorService.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<CustomResponse> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);

        return CustomResponse.response("Author Deleted successfully");
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<CustomResponse> deleteAuthorByName(@PathVariable String name) {
        authorService.deleteAuthor(name);

        return CustomResponse.response("Author Deleted successfully");
    }

    @GetMapping("/id/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping("/name/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authorService.findAuthorByName(name);
    }

    @GetMapping("/{id}/books")
    public List<Book> getAuthorBooksById(@PathVariable Long id) {
        return authorService.findAuthorsByBookId(id);
    }
}
