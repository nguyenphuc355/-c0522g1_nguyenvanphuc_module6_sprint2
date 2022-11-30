create database if not exists food_shop;
use food_shop;


create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table if not exists customer(
	id int primary key auto_increment,
	name varchar(30),
	is_delete bit default 0,
	day_of_birth varchar(30),
	gender int,
	id_card varchar(12),
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	foreign key (username) references user(username)
);

create table food(
id int primary key auto_increment,
name varchar(255),
status varchar(255),
manufacturing varchar (40),
content text,
price varchar(255),
image varchar(500),
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

create table if not exists food_customer(
id_customer int,
id_food int,
is_delete bit default 0,
foreign key(id_customer) references customer(id),
foreign key(id_food) references food(id),
primary key(id_customer, id_food)
)
