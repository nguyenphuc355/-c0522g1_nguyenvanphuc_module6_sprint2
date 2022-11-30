create database if not exists book_library;
use book_library;

create table book(
id int primary key auto_increment,
name varchar(255),
book_code varchar(40),
author varchar(255),
translator varchar(255),
publishing_company varchar(255),
number_of_pages varchar(40),
size varchar (40),
release_date varchar(45),
content text,
is_delete bit default(0)
);

create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table  if not exists role(
	id int primary key auto_increment,
    name varchar(30),
    is_delete bit default 0
);

create table if not exists user_role(
	username varchar(50),
    role_id int,
    is_delete bit default 0,
    foreign key(username) references user(username),
    foreign key(role_id) references role(id),
    primary key(username, role_id)
);
