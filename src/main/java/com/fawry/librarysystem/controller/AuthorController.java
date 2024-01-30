package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.service.AuthorService;
import com.fawry.librarysystem.model.response.CustomResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.findAllAuthors(Boolean.FALSE);
    }

    @GetMapping("/deleted")
    public List<AuthorDTO> getAllDeletedAuthors() {
        return authorService.findAllAuthors(Boolean.TRUE);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> addAuthor(@Valid @RequestBody AuthorDTO author) {
        authorService.addAuthor(author);

        return CustomResponse.response("Author added successfully", author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateAuthorById(@PathVariable Long id, @Valid @RequestBody AuthorDTO author) {
        author.setId(id);
        authorService.updateAuthor(author);

        return CustomResponse.response("Author Updated successfully", author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);

        return CustomResponse.response("Author Deleted successfully", null);
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping("/{id}/books")
    public List<BookDTO> getAuthorBooksById(@PathVariable Long id) {
        return authorService.findAuthorsByBookId(id);
    }
}
