# Library-System-Crud
Library System with Spring Boot and Spring Data JPA

## Requirements
- CRUD application of library system
[] Book controller finished
[x] 1. full working APIs to add, update, delete, find by id, search 
[] 2. including a unit testing for repo and service layers
[x] 3. Database ERD using https://mermaid.live/
[x] 4. Dockerfile
[] 5. Readme.md file that contains some information about the project and embed the ERD in it
[x] 6. push to GitHub

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
        Long category_id FK
    }
```
