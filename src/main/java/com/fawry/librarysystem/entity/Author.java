package com.fawry.librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Book> books;
}
