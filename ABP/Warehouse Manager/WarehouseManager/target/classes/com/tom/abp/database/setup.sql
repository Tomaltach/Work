CREATE DATABASE warehouse_stock;

CREATE TABLE users (id int PRIMARY KEY AUTO_INCREMENT, name varchar(25) NOT NULL, password varchar(25) NOT NULL);

CREATE TABLE stock (id int PRIMARY KEY AUTO_INCREMENT, box_number varchar(25) NOT NULL UNIQUE, name varchar(25) NOT NULL, description varchar(255), tag varchar(255), date_added date NOT NULL, date_removed date NOT NULL);

CREATE TABLE authority (username varchar(25) NOT NULL, authority varchar(25) NOT NULL);