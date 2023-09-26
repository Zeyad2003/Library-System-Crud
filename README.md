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
    BOOK }|..|{ AUTHOR : HAS
    CATEGORY ||--|{ BOOK : "BELONGS TO"

    BOOK {
        int id PK
        string name
        double price
        string BOOK_CATEGORY FK
    }

    AUTHOR {
        int id PK
        string name
        string email
    }

    CATEGORY {
        int id PK
        string name
        string description
    }

    %% BOOK_AUTHOR {
    %%     int author_id PK
    %%     int book_id PK
    %% }
```

## DataBase Diagram
![Spring-Task Diagram](https://github.com/Zeyad2003/Library-System-Crud/assets/87117386/a10a91c3-aa97-47b6-9d38-bbf70e040d0f)
