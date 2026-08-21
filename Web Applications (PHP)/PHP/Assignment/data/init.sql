DROP DATABASE shop;
CREATE DATABASE shop;
use shop;
CREATE TABLE users (
    id INT(5) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(15) NOT NULL,
    lastname VARCHAR(15) NOT NULL,
    email VARCHAR(30) NOT NULL,
    age INT(3),
    location VARCHAR(50),
    username VARCHAR(15),
    password VARCHAR(20),
    date TIMESTAMP
);
CREATE TABLE products (
    id INT(5) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    euro VARCHAR(15) NOT NULL,
    date TIMESTAMP
);
INSERT INTO products (name, euro)
VALUES
    ('White', '1'),
    ('Black', '1'),
    ('Blue', '1.5'),
    ('Green', '1.5'),
    ('Orange', '1.4'),
    ('Yellow', '1.6'),
    ('Purple', '1.3'),
    ('Brown', '1.2'),
    ('Grey', '1.6'),
    ('Red', '1.4'),
    ('Olive', '1.3'),
    ('Maroon', '1.9'),
    ('Violet', '1.6'),
    ('Charcoal', '1.6'),
    ('Magenta', '1.4'),
    ('Bronze', '1.7'),
    ('Cream', '1.3'),
    ('Tan', '1.4'),
    ('Teal', '1.6'),
    ('Mustard', '1.4'),
    ('Nevy blue', '1.7'),
    ('Coral', '1.3'),
    ('Burgundy', '1.2'),
    ('Levender', '1.5'),
    ('Peach', '1.6'),
    ('Mauve', '1.4'),
    ('Rust', '1.3'),
    ('Gold', '1.9'),
    ('Pink', '1.6'),
    ('Silver', '1.3');