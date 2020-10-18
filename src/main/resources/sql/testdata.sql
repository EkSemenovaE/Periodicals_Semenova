SET SCHEMA 'periodicals';

INSERT INTO periodicals.users (first_name, last_name, email, phone)
VALUES ('Ekaterina', 'Semenova', 'test1@gmail.com', '89999999999'),
       ('user1', 'user1', 'user1@gmail.com', '55555555555'),
       ('user2', 'user2', 'user2@gmail.com', '55555555555'),
       ('user3', 'user3', 'user3@gmail.com', '55555555555'),
       ('user4', 'user4', 'user4@gmail.com', '55555555555'),
       ('user5', 'user5', 'user5@gmail.com', '55555555555');

INSERT INTO periodicals.periodicals (user_id, title, body, category, created_date)
VALUES (1, 'periodical1', 'periodical1', 'business', current_timestamp),
       (2, 'periodical2', 'periodical2', 'business', current_timestamp),
       (3, 'periodical3', 'periodical3', 'life', current_timestamp);
