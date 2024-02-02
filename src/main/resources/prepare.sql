-- Create the user
CREATE USER IF NOT EXISTS 'fawry-intern'@'%' IDENTIFIED BY 'fawry';

-- Grant all privileges to the user
GRANT ALL PRIVILEGES ON *.* TO 'fawry-intern'@'%' WITH GRANT OPTION;

-- Create the database
CREATE DATABASE IF NOT EXISTS `library-system`;

-- Switch to the newly created database
USE `library-system`;

-- Dropping all tables if they exist
DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS category;

-- Creating 'author' table
CREATE TABLE IF NOT EXISTS author
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    deleted BIT          NULL,
    email   VARCHAR(255) NULL,
    name    VARCHAR(255) NULL,
    CONSTRAINT UK_grm3merlhi91rac0mu26swyhf UNIQUE (email)
);

-- Creating 'category' table
CREATE TABLE IF NOT EXISTS category
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NULL,
    name        VARCHAR(255) NULL,
    CONSTRAINT UK_46ccwnsi9409t36lurvtyljak UNIQUE (name)
);

-- Creating 'book' table
CREATE TABLE IF NOT EXISTS book
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    deleted     BIT            NULL,
    price       DECIMAL(38, 2) NULL,
    category_id BIGINT         NULL,
    name        VARCHAR(255)   NULL,
    CONSTRAINT UK_wugryet8mf6oi28n00x2eoc4 UNIQUE (name),
    CONSTRAINT FKam9riv8y6rjwkua1gapdfew4j FOREIGN KEY (category_id) REFERENCES category (id)
);

-- Creating 'book_author' table
CREATE TABLE IF NOT EXISTS book_author
(
    author_id BIGINT NOT NULL,
    book_id   BIGINT NOT NULL,
    CONSTRAINT FKbjqhp85wjv8vpr0beygh6jsgo FOREIGN KEY (author_id) REFERENCES author (id),
    CONSTRAINT FKhwgu59n9o80xv75plf9ggj7xn FOREIGN KEY (book_id) REFERENCES book (id)
);

-- Inserting random data into 'author' table
INSERT INTO author (email, name, deleted)
VALUES ('author1@example.com', 'Author One', false),
       ('author2@example.com', 'Author Two', false),
       ('author3@example.com', 'Author Three', false),
       ('author4@example.com', 'Author Four', true);

-- Inserting random data into 'category' table
INSERT INTO category (description, name)
VALUES ('Explore imaginative worlds and stories', 'Fiction'),
       ('Informative and factual content', 'Non-Fiction'),
       ('Journey into the realms of future possibilities', 'Science Fiction');

-- Inserting random data into 'book' table
INSERT INTO book (price, category_id, name, deleted)
VALUES (29.99, 1, 'Book One', false),
       (19.99, 2, 'Book Two', false),
       (39.99, 3, 'Book Three', false),
       (49.99, 1, 'Book Four', true);

-- Inserting random data into 'book_author' table
INSERT INTO book_author (author_id, book_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 3);
