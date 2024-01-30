package com.fawry.librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id=?")
@FilterDef(name = "authorDeletedFilter", parameters = @ParamDef(name = "deleted", type = Boolean.class))
@Filter(name = "authorDeletedFilter", condition = "deleted = :deleted")
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private Boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonManagedReference
    private List<Book> books;
}
