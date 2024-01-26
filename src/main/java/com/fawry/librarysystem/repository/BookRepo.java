package com.fawry.librarysystem.repository;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByName(String name);

    void deleteByName(String name);

    default List<Author> findBookAuthorsById(Long id) {
        Optional<Book> bookOptional = findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get().getAuthors();
        } else {
            return new ArrayList<>();
        }
    }
}