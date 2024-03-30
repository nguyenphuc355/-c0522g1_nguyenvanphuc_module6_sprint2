create database if not exists food_shop_v3;
use food_shop_v3;


create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table if not exists customer(
	id int primary key auto_increment,
	name varchar(255),
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
create table if not exists food_type(
id int primary key auto_increment,
name varchar(255),
is_delete bit default 0
);
create table food(
id int primary key auto_increment,
name varchar(255),
status varchar(255),
manufacturing varchar (40),
content text,
price int,
image varchar(500),
is_delete bit default 0,
food_type_id int,
-- cart_id int,
foreign key (food_type_id) references food_type(id)
-- foreign key (cart_id) references cart(id)
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

create table if not exists order_detail(
date_payment datetime,
quantity int,
id_customer int,
id_food int,
is_delete bit default 0,
is_pay bit default 0,
foreign key(id_customer) references customer(id),
foreign key(id_food) references food(id)
);

create table if not exists employee(
id int auto_increment primary key,
name varchar(255),
birthday varchar(45),
id_card varchar(20),
gender int,
email varchar(255),
address varchar(255),
phone_number varchar(20),
username varchar(30) unique,
foreign key (username) references user(username)
);

create table if not exists cart(
id int primary key auto_increment,
quantity int,
is_delete bit default 0,
food_id int
);






























