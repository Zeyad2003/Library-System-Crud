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
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "category_name")
    private Category category;
}
