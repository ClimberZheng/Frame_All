show databases;
use stevendb;

drop table  if exists `order`;

CREATE TABLE `order`
(
    `orderId`       int(11) NOT NULL auto_increment ,
    `oNo`       varchar(30) CHARACTER SET utf8 not null unique ,
    `comId`       int(11) NOT NULL,
    `cNum` varchar(5) CHARACTER SET utf8 DEFAULT '1',
    `pay` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `userId`       int(11) NOT NULL,
    `createTime` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `reciveAdre` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `reviceName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `reciveTel` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    PRIMARY KEY (`orderId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;