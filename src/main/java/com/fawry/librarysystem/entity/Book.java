package com.fawry.librarysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
}
