# Library-System-Crud
Library System with Spring Boot and Spring Data JPA

## Requirements
- CRUD application of Library System

1. full working APIs to add, update, delete, find by id, search - including a unit testing for repo and service layers
2. Database ERD using https://mermaid.live/ (check ER in sample diagrams)
3. Dockerfile
4. Readme.md file that contains some information about the project and embed the ERD in it
5. push to GitHub

## ERD Code
```mermaid
erDiagram
    CATEGORY ||--|{ BOOK : ""
    BOOK_AUTHOR }|--|| AUTHOR: ""
    BOOK_AUTHOR }|--|| BOOK: ""
    

    BOOK {
        Long id PK
        string name
        BigDecimal price
    }

    AUTHOR {
        Long id PK
        string name
        string email
    }

    BOOK_AUTHOR {
        Long book_id PK
        Long author_id PK
    }

    CATEGORY {
        Long id PK
        string name
        string description
    }
```

## DataBase Diagram
![Library-System](https://github.com/Zeyad2003/Library-System-Crud/assets/87117386/927e2035-0771-41f3-98d4-84249d816d54)
