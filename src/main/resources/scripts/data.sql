SET FOREIGN_KEY_CHECKS = 0;
truncate table book;
truncate table user;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO book(id, title) VALUES
(200, "Aina goes to school");

INSERT INTO user(id, password, username) VALUES
(201, "password", "username");
