# Library-System-Crud

A Spring-Boot RESTful API for managing books, authors, and categories in a library system with full CRUD functionalities.

**You can check the Postman requests' collection here:**

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/29664655-3c9d7b36-1419-4146-861f-32c8a74d11b5?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D29664655-3c9d7b36-1419-4146-861f-32c8a74d11b5%26entityType%3Dcollection%26workspaceId%3D5c59c674-7712-4a15-b429-da6b703c2752)
> If you couldn't find the collection for any reason, you can import this **[File](./src/main/resources/Library-System.postman_collection.json)** manually to Postman.

## Features
- Full CRUD functionalities for books, authors, and categories.

## Local Installation

> [!NOTE]
> If you want to avoid the local installation, you can follow these **[instructions](gitpod.md)** to run the application on GitPod (Cloud based IDE)

First, make sure you install the following:
- Java 17
- Maven
- MySQL

Once you have the required tools installed, follow these steps to install the Bank Management System:

1. Clone this repository:
    ```shell
       git clone https://github.com/Zeyad2003/Library-System-Crud.git
    ```

2. Navigate to the project directory:
    ```shell
    cd Library-System-Crud
    ```

3. Prepare the database with random sample data:

   ```shell
   mysql -u root < ./src/main/resources/db/prepare.sql
   ```

4. Build and run the application using Maven
    ```shell
    mvn spring-boot:run
    ```
   
5. Access the application endpoints via: `http://localhost:8080/`

6. You can explore the API documentation at: `http://localhost:8080/swagger-ui.html`. This provides detailed insights into the available API endpoints and functionalities.
> If you just want to see the API documentation without running the application you can check this **[File](./src/main/resources/End-Points-Docs.md)**

## Database Schema
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

## Technologies Used
- Java 17
- Spring Boot
- Maven
- MySQL
- Spring Data JPA
- Lombok
- MapStruct
- Swagger
- Docker

> [!NOTE]
> The unit tests aren't complete yet, I'm going to complete them soon.
