
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(64) NOT NULL DEFAULT '',
  `age` int(11) NOT NULL,
  `birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test1', 'test@test.com', '1', '2017-04-04 02:54:18');
INSERT INTO `user` VALUES ('2', 'test1', 'test@test.com', '1', '2017-04-04 02:56:19');
INSERT INTO `user` VALUES ('3', 'test1', 'test@test.com', '1', '2017-04-04 03:59:13');


create table employee(
id int not null primary key,
name varchar(100),
sharding_id int not null
);

insert into employee(id,name,sharding_id) values(1, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(2, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(3, 'I am db3',10010);
insert into employee(id,name,sharding_id) values(4, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(5, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(6, 'I am db3',10010);
insert into employee(id,name,sharding_id) values(7, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(8, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(9, 'I am db3',10010);
insert into employee(id,name,sharding_id) values(10, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(11, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(12, 'I am db3',10010);
insert into employee(id,name,sharding_id) values(13, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(14, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(15, 'I am db3',10010);
insert into employee(id,name,sharding_id) values(16, 'I am db1',10000);
insert into employee(id,name,sharding_id) values(17, 'I am db2',10010);
insert into employee(id,name,sharding_id) values(18, 'I am db3',10010);