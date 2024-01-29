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
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByName(String name);

    void deleteByName(String name);

    @Query("SELECT a.books FROM Author a WHERE a.id = ?1")
    List<Book> findBooksByAuthorId(Long id);
}