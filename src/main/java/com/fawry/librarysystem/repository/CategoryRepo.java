package com.fawry.librarysystem.repository;

import com.fawry.librarysystem.entity.Author;
import com.fawry.librarysystem.entity.Book;
import com.fawry.librarysystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);

    void deleteByName(String name);

    default List<Book> findCategoryBooksById(Long id) {
        Optional<Category> categoryOptional = findById(id);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get().getBooks();
        } else {
            return new ArrayList<>();
        }
    }
}
