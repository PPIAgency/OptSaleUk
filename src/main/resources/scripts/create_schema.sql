# Script for creation tables of db_example

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





