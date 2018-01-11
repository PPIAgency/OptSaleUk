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

