package com.fawry.librarysystem.controller;

import com.fawry.librarysystem.model.dto.AuthorDTO;
import com.fawry.librarysystem.model.dto.BookDTO;
import com.fawry.librarysystem.service.AuthorService;
import com.fawry.librarysystem.model.response.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
@Tag(name = "Author", description = "The Author End-Points")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    @Operation(summary = "Retrieve all authors", description = "Get a list of all authors.")
    public List<AuthorDTO> getAllAuthors() {
        return authorService.findAllAuthors(Boolean.FALSE);
    }

    @PostMapping
    @Operation(summary = "Create a new author", description = "Add a new author to the system.")
    public ResponseEntity<CustomResponse> addAuthor(@Valid @RequestBody AuthorDTO author) {
        authorService.addAuthor(author);
        return CustomResponse.response("Author added successfully", HttpStatus.OK.value(), author);
    }

    @GetMapping("/deleted")
    @Operation(summary = "Get a list of all deleted authors", description = "Showing the deleted authors to make it easier to restore them.")
    public List<AuthorDTO> getAllDeletedAuthors() {
        return authorService.findAllAuthors(Boolean.TRUE);
    }

    @PutMapping("/{id}/restore")
    @Operation(summary = "Restore a deleted author", description = "Restore a previously deleted author by their ID.")
    public ResponseEntity<CustomResponse> restoreAuthorById(@PathVariable Long id) {
        authorService.restoreAuthor(id);
        return CustomResponse.response("Author restored successfully", HttpStatus.OK.value(), null);
    }

    @GetMapping("/{id}/books")
    @Operation(summary = "Get books by author ID", description = "Retrieve all books associated with a specific author by their ID.")
    public List<BookDTO> getAuthorBooksById(@PathVariable Long id) {
        return authorService.findAuthorBooksById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get author by ID", description = "Retrieve an author by their ID.")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping(params = "name")
    @Operation(summary = "Get author by name", description = "Retrieve an author by their name by using ?name={name}.")
    public AuthorDTO getAuthorByName(@RequestParam String name) {
        return authorService.findAuthorByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update author by ID", description = "Update the information of an author by their ID.")
    public ResponseEntity<CustomResponse> updateAuthorById(@PathVariable Long id, @Valid @RequestBody AuthorDTO author) {
        author.setId(id);
        authorService.addAuthor(author);
        return CustomResponse.response("Author Updated successfully", HttpStatus.OK.value(), author);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete author by ID", description = "Apply Soft-Delete, and mark the author as deleted to avoid fetching it in future requests.")
    public ResponseEntity<CustomResponse> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return CustomResponse.response("Author Deleted successfully", HttpStatus.OK.value(), null);
    }

    @PostMapping("/{authorId}/book/{bookId}")
    @Operation(summary = "Associate a book with an author", description = "Associate a book with an author by their respective IDs.")
    public ResponseEntity<CustomResponse> addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.associateBookWithAuthor(authorId, bookId);
        return CustomResponse.response("Book added to author successfully", HttpStatus.OK.value(), null);
    }
}