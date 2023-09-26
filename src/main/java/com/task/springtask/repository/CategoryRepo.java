package com.task.springtask.repository;

import com.task.springtask.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);

    void deleteByName(String name);
}
