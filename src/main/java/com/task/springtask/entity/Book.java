package com.task.springtask.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name", unique = true)
    private String name;

    @Column(name = "book_price")
    private double price;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "book_category", referencedColumnName = "category_name")
    private Category category;
}
