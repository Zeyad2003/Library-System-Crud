package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.service.AuthorService;
import com.fawry.librarysystem.model.resoponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorServiceImpl;

    @PostMapping
    public ResponseEntity<CustomResponse> addAuthor(@RequestBody AuthorDTO author) {
        authorServiceImpl.addAuthor(author);

        return CustomResponse.response("Author added successfully", author);
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorServiceImpl.findAllAuthors();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateAuthorById(@PathVariable Long id, @RequestBody AuthorDTO author) {
        author.setId(id);
        authorServiceImpl.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully", author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteAuthorById(@PathVariable Long id) {
        authorServiceImpl.deleteAuthor(id);

        return CustomResponse.response("Author Deleted successfully", id);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorServiceImpl.findAuthorById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getAuthorBooksById(@PathVariable Long id) {
        return authorServiceImpl.findAuthorsByBookId(id);
    }
}
