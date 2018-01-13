# Script witch hibernate use for create and fill database

USE db_example;

CREATE TABLE IF NOT EXISTS `country` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `region` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) NOT NULL,
   `country_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `FK7vb2cqcnkr9391hfn72louxkq` (`country_id`),
   CONSTRAINT `FK7vb2cqcnkr9391hfn72louxkq` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `city` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `name` varchar(255) NOT NULL,
 `region_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `FKsi0dkm9kk6dyuedmc0j18t770` (`region_id`),
 CONSTRAINT `FKsi0dkm9kk6dyuedmc0j18t770` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `additional_info` varchar(255) DEFAULT NULL,
 `create_date` datetime NOT NULL,
 `description_of_work` varchar(255) DEFAULT NULL,
 `email` varchar(255) NOT NULL,
 `first_name` varchar(255) NOT NULL,
 `last_name` varchar(255) NOT NULL,
 `password` varchar(255) NOT NULL,
 `phone` varchar(255) NOT NULL,
 `role` varchar(255) NOT NULL,
 `status` varchar(255) NOT NULL,
 `city_id` bigint(20) DEFAULT NULL,
 `region_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
 UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`),
 KEY `FK29eqyw0gxw5r4f1ommy11nd9i` (`city_id`),
 KEY `FKt4enlxyfjstamura4y1p3wtor` (`region_id`),
 CONSTRAINT `FK29eqyw0gxw5r4f1ommy11nd9i` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
 CONSTRAINT `FKt4enlxyfjstamura4y1p3wtor` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `proposal` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `cost` bigint(20) DEFAULT NULL,
 `count` int(11) DEFAULT NULL,
 `create_date` datetime DEFAULT NULL,
 `end_date` datetime DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `product_type` varchar(255) DEFAULT NULL,
 `author_id` bigint(20) NOT NULL,
 `buyer_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `FKhftb2tvdkticqhn5jb9cnx26n` (`author_id`),
 KEY `FKq70ksvjcdp9lyd0nkoxjjx469` (`buyer_id`),
 CONSTRAINT `FKhftb2tvdkticqhn5jb9cnx26n` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
 CONSTRAINT `FKq70ksvjcdp9lyd0nkoxjjx469` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `feedback` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `create_date` datetime DEFAULT NULL,
   `message` varchar(255) DEFAULT NULL,
   `author_id` bigint(20) NOT NULL,
   `user_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `FKjps4bm4bk24bum79syxri4052` (`author_id`),
   KEY `FK7k33yw505d347mw3avr93akao` (`user_id`),
   CONSTRAINT `FK7k33yw505d347mw3avr93akao` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
   CONSTRAINT `FKjps4bm4bk24bum79syxri4052` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `create_date` datetime DEFAULT NULL,
 `text` varchar(255) DEFAULT NULL,
 `author_id` bigint(20) NOT NULL,
 `proposal_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `FKh1gtv412u19wcbx22177xbkjp` (`author_id`),
 KEY `FKgd5c792vmenisiw5os6nflkp` (`proposal_id`),
 CONSTRAINT `FKgd5c792vmenisiw5os6nflkp` FOREIGN KEY (`proposal_id`) REFERENCES `proposal` (`id`),
 CONSTRAINT `FKh1gtv412u19wcbx22177xbkjp` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `delivery` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `description` varchar(255) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `type` varchar(255) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





#INSERT COUNTRIES
INSERT INTO db_example.country VALUES(1,'Ukraine');

#INSERT REGIONS
INSERT INTO db_example.region VALUES(2, 'Odessa', 1);
INSERT INTO db_example.region VALUES(3, 'Dnipropetrovsk', 1);
INSERT INTO db_example.region VALUES(4, 'Chernihiv', 1);
INSERT INTO db_example.region VALUES(5, 'Kharkiv', 1);
INSERT INTO db_example.region VALUES(6, 'Zhytomyr', 1);
INSERT INTO db_example.region VALUES(7, 'Poltava', 1);
INSERT INTO db_example.region VALUES(8, 'Kherson', 1);
INSERT INTO db_example.region VALUES(9, 'Kiev', 1);
INSERT INTO db_example.region VALUES(10, 'Zaporizka', 1);
INSERT INTO db_example.region VALUES(11, 'Lugansk', 1);
INSERT INTO db_example.region VALUES(12, 'Donetsk', 1);
INSERT INTO db_example.region VALUES(13, 'Vinnytsya', 1);
INSERT INTO db_example.region VALUES(14, 'Kirovograd', 1);
INSERT INTO db_example.region VALUES(15, 'Mykolaiv', 1);
INSERT INTO db_example.region VALUES(16, 'Sumy', 1);
INSERT INTO db_example.region VALUES(17, 'Lviv', 1);
INSERT INTO db_example.region VALUES(18, 'Cherkasy', 1);
INSERT INTO db_example.region VALUES(19, 'Khmelnytsky', 1);
INSERT INTO db_example.region VALUES(20, 'Volinsky', 1);
INSERT INTO db_example.region VALUES(21, 'Rivne', 1);
INSERT INTO db_example.region VALUES(22, 'Ivano-Frankivsk', 1);
INSERT INTO db_example.region VALUES(23, 'Ternopil', 1);
INSERT INTO db_example.region VALUES(24, 'Chernivtsi', 1);

#INSERT CITIES
INSERT INTO db_example.city VALUES(25, 'Odessa', 2);
INSERT INTO db_example.city VALUES(26, 'Dnipropetrovsk', 3);
INSERT INTO db_example.city VALUES(27, 'Chernihiv', 4);
INSERT INTO db_example.city VALUES(28, 'Kharkiv', 5);
INSERT INTO db_example.city VALUES(29, 'Zhytomyr', 6);
INSERT INTO db_example.city VALUES(30, 'Poltava', 7);
INSERT INTO db_example.city VALUES(31, 'Kherson', 8);
INSERT INTO db_example.city VALUES(32, 'Kiev', 9);
INSERT INTO db_example.city VALUES(33, 'Zaporizka', 10);
INSERT INTO db_example.city VALUES(34, 'Lugansk', 11);
INSERT INTO db_example.city VALUES(35, 'Donetsk', 12);
INSERT INTO db_example.city VALUES(36, 'Vinnytsya', 13);
INSERT INTO db_example.city VALUES(37, 'Kirovograd', 14);
INSERT INTO db_example.city VALUES(38, 'Mykolaiv', 15);
INSERT INTO db_example.city VALUES(39, 'Sumy', 16);
INSERT INTO db_example.city VALUES(40, 'Lviv', 17);
INSERT INTO db_example.city VALUES(41, 'Cherkasy', 18);
INSERT INTO db_example.city VALUES(42, 'Khmelnytsky', 19);
INSERT INTO db_example.city VALUES(43, 'Volinsky', 20);
INSERT INTO db_example.city VALUES(44, 'Rivne', 21);
INSERT INTO db_example.city VALUES(45, 'Ivano-Frankivsk', 22);
INSERT INTO db_example.city VALUES(46, 'Ternopil', 23);
INSERT INTO db_example.city VALUES(47, 'Chernivtsi', 24);

#INSERT USERS
INSERT INTO db_example.user VALUES(48, 'I am a super admin', NOW(), 'I work as super admin and sometimes give some grants to another users', 'super@dmin', 'Super', 'Admin', '$2a$11$W3Np2CSsD2xCjU45bEqGkO3/actQvRF32nlbhxHW75I/uFEzi/yI.', '+380324234756', 'SUPER_ADMIN', 'ACTIVE', 25, 2);
INSERT INTO db_example.user VALUES(49, 'I am a admin', NOW(), 'I work as admin and sometimes give some grants to another users', '@dmin', 'Admin', 'Adminskyi', '$2a$11$OvPQevEZhJ3c3xsnAblfi.Xz9S1BMUfRsN1k6KXSiBnoB547yLinO', '+38042657654', 'ADMIN', 'ACTIVE', 26, 3);
INSERT INTO db_example.user VALUES(50, 'I am a user', NOW(), 'I work as user', 'user', 'User', 'Userovich', '$2a$11$xhmwCLKTnnESySLWw7My3e44yaD4mC7papFirtsdUa9goAgBNFxT.', '+3543687534798', 'USER', 'ACTIVE', 27, 4);
INSERT INTO db_example.user VALUES(51, 'I am a VIP-user', NOW(), 'I work as VIP USER', 'vipuser', 'User', 'Userovich', '$2a$11$ro7br2SfL26HG29h/XWzj.rU7GFxqCgU0kD3wfWDfMh7gxszTIVa6', '+3785904543', 'VIP_USER', 'ACTIVE', 28, 5);

COMMIT;

