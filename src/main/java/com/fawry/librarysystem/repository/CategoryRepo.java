package com.fawry.librarysystem.repository;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);

    void deleteByName(String name);

    @Query("SELECT c.books FROM Category c WHERE c.id = ?1")
    List<Book> findCategoryBooksById(Long id);
}
