 use food_shop_v2;

insert into food(name,image,food_type_id,price)
values
('Cam sành','https://thucphamnhanh.com/wp-content/uploads/2020/03/cam-sanh-300x218.jpg',3,28000),
('Ức gà phi lê-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/uc-ga-phi-le-loai-1kg-2-300x218.jpg',2,88000),
('Cánh gà-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/canh-ga-cp-loai-5kg-1-300x218.jpg',2,81500),
('Dừa nạo-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/10/dua-nao-loai-1kg-gia-tot-300x218.jpg',1,70000),
('Nấm đông cô tươi-gói 200g','https://thucphamnhanh.com/wp-content/uploads/2020/03/nam-dong-co-tuoi-goi-200g-chat-luong-300x218.jpg',1,32500),
('Xà lách-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/xa-lach-tim-loai-1kg-gia-tot-2-300x218.jpg',1,39000),
('Chuối già hương-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/chuoi-gia-huong-tuoi-300x218.jpg',3,17000),
('Khoai môn cao-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/khoai-mon-cao-loai-1kg-chat-luong-300x218.jpg',1,52000),
('Cà chua-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/ca-chua-loai-1kg-2-300x218.jpg',1,28000),
('Bắp cải trắng-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/bap-cai-trang-loai-1kg-chat-luong-300x218.jpg',1,24000),
('Thịt heo xay-khay 300g','https://thucphamnhanh.com/wp-content/uploads/2021/01/thit-heo-xay-cp-khay-300g-2-300x218.jpg',2,34000),
('Xương cổ heo-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2021/01/xuong-co-heo-cp-loai-1kg-300x218.jpg',2,59500),
('Thịt bắp giò trước-khay 300g','https://thucphamnhanh.com/wp-content/uploads/2021/01/thit-bap-gio-truoc-cp-khay-300g-300x218.jpg',2,123000),
('Chân giò heo-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/12/chan-gio-heo-300x218.jpg.webp',2,84000),
('Thịt dăm heo-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2021/01/thit-dam-heo-cp-khay-300g-1-1-300x218.jpg',2,114000),
('Đùi gà tỏi-loại 5kg','https://thucphamnhanh.com/wp-content/uploads/2020/03/dui-ga-toi-cp-loai-5kg-3-300x218.jpg',2,532000),
('Lưỡi vịt rút xương-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/09/luoi-vit-rut-xuong-loai-1kg-1-300x218.jpg',2,226000),
('Đùi gà góc tư-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/09/dui-ga-goc-tu-loai-1kg-2-300x218.jpg',2,65500),
('Vá bò ngon-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/11/va-bo-ngon-loai-1kg-300x218.jpg',2,241000),
('Xương ống bò-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/10/xuong-ong-bo-viet-loai-1kg-300x218.jpg',2,46000),
('Nạm bò ngon-loại 1kg','https://thucphamnhanh.com/wp-content/uploads/2020/10/nam-bo-ngon-it-mo-loai-1kg-10-300x218.jpg',2,176000),
('Trứng gà-khay 10 trứng','https://thucphamnhanh.com/wp-content/uploads/2020/03/trung-ga-cp-loai-3-khay-10-trung-an-toan-300x218.jpg',4,36000);


INSERT INTO `food_shop_v3`.`cart` (`id`, `food_id`, `quantity`, `is_delete`) VALUES (1,1,1,0),(2,2,1,0),(3,3,1,0);
INSERT INTO `food_shop_v3`.`food_type` (`name`) VALUES ('Rau củ'),('Thịt'),('hoa quả'),('Khác');

insert into user (username, password) values ('admin', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('scorhard1', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('aswanbourne2', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('gchristiensen3', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('sstillert4', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('dbuckell5', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('misherwood6', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('cdockray7', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('kdiscombe8', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('rminshull9', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('ssleemana', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('gpayneb', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('akleinermanc', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('rjosephyd', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('hgiddene', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('adelucef', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('bgendrickeg', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('adutsonh', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('bkeplingi', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('cpordallj', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('mlarrosak', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('pgainfortl', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('aspourem', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('smulqueenn', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('mrichemonto', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('jcritchleyp', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('agamellq', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('aregardsoer', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('smapess', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('pcregint', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('nbalazinu', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');
insert into user (username, password) values ('user', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC');

INSERT INTO user_role (username, role_id) VALUES ('admin', '1');
INSERT INTO user_role (username, role_id) VALUES ('admin', '2');
INSERT INTO user_role (username, role_id) VALUES ('scorhard1', '2');
INSERT INTO user_role (username, role_id) VALUES ('aswanbourne2', '2');
INSERT INTO user_role (username, role_id) VALUES ('gchristiensen3', '2');
INSERT INTO user_role (username, role_id) VALUES ('sstillert4', '2');
INSERT INTO user_role (username, role_id) VALUES ('dbuckell5', '2');
INSERT INTO user_role (username, role_id) VALUES ('misherwood6', '2');
INSERT INTO user_role (username, role_id) VALUES ('cdockray7', '2');
INSERT INTO user_role (username, role_id) VALUES ('kdiscombe8', '2');
INSERT INTO user_role (username, role_id) VALUES ('rminshull9', '2');
INSERT INTO user_role (username, role_id) VALUES ('ssleemana', '2');
INSERT INTO user_role (username, role_id) VALUES ('gpayneb', '2');
INSERT INTO user_role (username, role_id) VALUES ('akleinermanc', '2');
INSERT INTO user_role (username, role_id) VALUES ('rjosephyd', '2');
INSERT INTO user_role (username, role_id) VALUES ('hgiddene', '2');
INSERT INTO user_role (username, role_id) VALUES ('adelucef', '2');
INSERT INTO user_role (username, role_id) VALUES ('bgendrickeg', '2');
INSERT INTO user_role (username, role_id) VALUES ('adutsonh', '2');
INSERT INTO user_role (username, role_id) VALUES ('bkeplingi', '2');
INSERT INTO user_role (username, role_id) VALUES ('cpordallj', '2');
INSERT INTO user_role (username, role_id) VALUES ('mlarrosak', '2');
INSERT INTO user_role (username, role_id) VALUES ('pgainfortl', '2');
INSERT INTO user_role (username, role_id) VALUES ('aspourem', '2');
INSERT INTO user_role (username, role_id) VALUES ('smulqueenn', '2');
INSERT INTO user_role (username, role_id) VALUES ('mrichemonto', '2');
INSERT INTO user_role (username, role_id) VALUES ('jcritchleyp', '2');
INSERT INTO user_role (username, role_id) VALUES ('agamellq', '2');
INSERT INTO user_role (username, role_id) VALUES ('aregardsoer', '2');
INSERT INTO user_role (username, role_id) VALUES ('smapess', '2');
INSERT INTO user_role (username, role_id) VALUES ('pcregint', '2');
INSERT INTO user_role (username, role_id) VALUES ('nbalazinu', '2');
INSERT INTO user_role (username, role_id) VALUES ('user', '2');


insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Rick Cundey', '1978-09-08', 1, '857907338', 'rcundey0@nps.gov', '726 Warrior Trail', '0907197155', 'scorhard1');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Frederica Dearell', '1977-05-04', 0, '663330737', 'fdearell1@google.co.uk', '79 Montana Plaza', '0905050824', 'aswanbourne2');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Rudolf Keppin', '1988-08-30', 0, '279117906', 'rkeppin2@utexas.edu', '192 Armistice Park', '0902940778', 'gchristiensen3');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Benny Ruckledge', '1992-10-01', 0, '228098302', 'bruckledge3@etsy.com', '8 Iowa Avenue', '0905165607', 'sstillert4');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Sarita Duny', '1987-10-29', 2, '484624230', 'sduny4@1688.com', '2894 Northwestern Crossing', '0908365075', 'dbuckell5');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Marianna Sone', '1990-07-10', 1, '161763394', 'msone5@biglobe.ne.jp', '873 Crescent Oaks Pass', '0903038539', 'misherwood6');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Esme Ibbeson', '1989-11-08', 1, '808953747', 'eibbeson6@redcross.org', '085 Bayside Hill', '0902317239', 'cdockray7');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Dido Josse', '1998-12-13', 0, '825243902', 'djosse7@theatlantic.com', '1 Waubesa Park', '0900620649', 'kdiscombe8');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Gabbie Thieme', '1976-12-23', 0, '899804822', 'gthieme8@dyndns.org', '56 Kenwood Place', '0909192760', 'rminshull9');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Gino Blackly', '1985-07-23', 2, '859211696', 'gblackly9@wp.com', '417 Montana Parkway', '0907276488', 'ssleemana');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Orelia Gladwell', '1996-09-11', 2, '648777793', 'ogladwella@geocities.jp', '33 Derek Street', '0904817241', 'gpayneb');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Gaven Fedorchenko', '1997-02-11', 1, '148548115', 'gfedorchenkob@imdb.com', '6 Bonner Drive', '0906417151', 'akleinermanc');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Kathryn Smickle', '1980-09-15', 0, '477951010', 'ksmicklec@facebook.com', '5836 Burrows Junction', '0909772029', 'rjosephyd');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Livia Bathow', '1985-06-17', 1, '393549066', 'lbathowd@gizmodo.com', '279 Paget Place', '0903072587', 'hgiddene');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Agretha Havard', '1998-07-10', 0, '121463039', 'ahavarde@sciencedaily.com', '01 Graceland Way', '0905130351', 'adelucef');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Hadley Chaloner', '1978-05-20', 0, '624427229', 'hchalonerf@example.com', '358 Almo Circle', '0909652565', 'bgendrickeg');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Janey Geffinger', '1984-08-31', 2, '367859879', 'jgeffingerg@telegraph.co.uk', '17 Nancy Plaza', '0904591554', 'adutsonh');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Reamonn Neave', '1989-01-03', 2, '909288393', 'rneaveh@seesaa.net', '756 Everett Street', '0907775254', 'bkeplingi');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Camella Slimm', '2004-11-27', 2, '005579067', 'cslimmi@bbc.co.uk', '0156 Spohn Lane', '0908211341', 'cpordallj');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Annalise Rosenberg', '1986-08-02', 0, '543321780', 'arosenbergj@npr.org', '5 Mendota Point', '0903376516', 'mlarrosak');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Lynde Eeles', '1989-03-27', 2, '109579476', 'leelesk@bigcartel.com', '84 Ruskin Park', '0905059153', 'pgainfortl');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Clary Asbery', '1991-10-21', 2, '719846876', 'casberyl@t.co', '6 East Circle', '0908819235', 'aspourem');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Cleopatra Aitkenhead', '1994-12-16', 0, '900011548', 'caitkenheadm@tuttocitta.it', '280 Swallow Point', '0907334087', 'smulqueenn');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Kordula Primrose', '1983-05-22', 0, '013500052', 'kprimrosen@tripod.com', '30977 Hayes Avenue', '0900450830', 'mrichemonto');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Nestor Kropach', '2003-11-21', 0, '440834617', 'nkropacho@i2i.jp', '55 John Wall Parkway', '0900668603', 'jcritchleyp');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Mikaela Tooker', '1978-10-21', 0, '502650979', 'mtookerp@geocities.jp', '20 Pierstorff Alley', '0900131568', 'agamellq');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Koren Bilbey', '2001-02-27', 2, '301826217', 'kbilbeyq@dropbox.com', '66 Brentwood Lane', '0902674693', 'aregardsoer');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Pierre Rickertsen', '1984-08-11', 2, '617129916', 'prickertsenr@gmpg.org', '721 Fisk Street', '0907013703', 'smapess');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Davina Devon', '2001-08-03', 2, '907114100', 'ddevons@dion.ne.jp', '732 Westerfield Road', '0901912048', 'pcregint');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Harris Magee', '1987-10-28', 0, '415646043', 'hmageet@tmall.com', '14 Dovetail Plaza', '0909684402', 'nbalazinu');
insert into customer (name, day_of_birth, gender, id_card, email, address, phone_number, username) values ('Phuc', '1987-10-28', 0, '415646043', 'hmageet@tmall.com', '14 Dovetail Plaza', '0909684402', 'user');


INSERT INTO `food_shop_v3`.`order_detail` (date_payment,`quantity`, `id_customer`, `id_food`) VALUES (now(),1,31,23);
INSERT INTO `food_shop_v3`.`order_detail` (date_payment,`quantity`, `id_customer`, `id_food`) VALUES (now(),1,31,24);
INSERT INTO `food_shop_v3`.`order_detail` (date_payment,`quantity`, `id_customer`, `id_food`) VALUES (now(),2,31,25);


select (order_detail.quantity * food.price) as sumPerOne, food.name, food.id, food.image, food.price, order_detail.quantity
from food join
order_detail on food.id = order_detail.id_food
join 
customer on customer.id= order_detail.id_customer
where
username = 'admin' and order_detail.is_delete = 0;

select sum(food.price * order_detail.quantity) as totalBill 
            from order_detail 
            join customer on order_detail.id_customer = customer.id 
            join food on food.id = order_detail.id_food 
		where username = 'admin' and order_detail.is_delete = 0 and is_pay = 0;