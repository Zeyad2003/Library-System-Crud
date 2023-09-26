package com.task.springtask.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_email")
    private String email;


    @ManyToMany
    @JoinTable(name = "author_book", joinColumns =
               @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
