package com.fawry.librarysystem.repository;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByName(String name);

    void deleteByName(String name);

    default List<Book> findAuthorsByBookId(Long id) {
        Optional<Author> authorOptional = findById(id);
        if (authorOptional.isPresent()) {
            return authorOptional.get().getBooks();
        } else {
            return new ArrayList<>();
        }
    }
}