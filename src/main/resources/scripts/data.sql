SET FOREIGN_KEY_CHECKS = 0;
truncate table book;
truncate table user;
truncate table authors;
truncate table book_formats;
truncate table book_bookshelves;
truncate table book_languages;
truncate table book_subjects;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO book(id, title) VALUES
(200, "Aina goes to school");

INSERT INTO user(id, password, username) VALUES
(201, "password", "username");

INSERT INTO authors(id, birth_year, death_year, name, book_id) VALUES
(202, "1200", "1900", "Willams shakespare", 200);

