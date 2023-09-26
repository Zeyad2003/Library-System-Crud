package com.task.springtask.repository;

import com.task.springtask.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByName(String name);

    void deleteByName(String name);
}