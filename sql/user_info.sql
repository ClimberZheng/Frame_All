show databases;
use stevendb;

drop table if exists fuser;

CREATE TABLE `user_info`
(
    `userInfoId` int(11) NOT NULL auto_increment,
    `userId`     int(11) NOT NULL,
    `realName`   varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `sex`        varchar(5) CHARACTER SET utf8 check (sex = '男' or sex = '女'),
    `age`        varchar(3) CHARACTER SET utf8,
    `address`    varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `telNo`      varchar(20) CHARACTER SET utf8 DEFAULT NULL,
    `idCardNo`   varchar(20) CHARACTER SET utf8 DEFAULT NULL,
    PRIMARY KEY (`userInfoId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO stevendb.user_info (userInfoId, userId, realName, sex, age, address, telNo, idCardNo)
VALUES (1, 1, '张孝哲', '男', '23', '湖北黄冈', '13555626369', '421123199312122213');
INSERT INTO stevendb.user_info (userInfoId, userId, realName, sex, age, address, telNo, idCardNo)
VALUES (2, 2, '陈筱', '女', '24', '浙江杭州', '16365733327', '421123199312081513');