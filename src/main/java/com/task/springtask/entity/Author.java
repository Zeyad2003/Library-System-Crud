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
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    @ManyToMany
    @JoinTable(name = "book", joinColumns =
               @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
