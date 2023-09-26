package com.task.springtask.repository;

import com.task.springtask.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByName(String name);

    void deleteByName(String name);
}