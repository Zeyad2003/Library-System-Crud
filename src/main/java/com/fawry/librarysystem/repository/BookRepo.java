package com.fawry.librarysystem.repository;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByName(String name);

    void deleteByName(String name);

    @Query("SELECT b.authors FROM Book b WHERE b.id = ?1")
    List<Author> findBookAuthorsById(Long id);
}