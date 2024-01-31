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
VALUES (100, 1, 'lost', false),
       (29.99, 2, 'Book Two', false),
       (19.99, 3, 'Book Three', false),
       (39.99, 4, 'Book Four', false),
       (49.99, 5, 'Book Five', true);

-- Inserting random data into 'book_author' table
INSERT INTO book_author (author_id, book_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 3);
