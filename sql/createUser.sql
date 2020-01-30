show databases;
use stevendb;

drop table  if exists fuser;

CREATE TABLE `fuser`
(
    `userId`       int(11) NOT NULL auto_increment ,
    `uName`       varchar(30) CHARACTER SET utf8 DEFAULT NULL unique ,
    `uPwd` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
    `statue`       varchar(3) CHARACTER SET utf8  DEFAULT NULL,
    PRIMARY KEY (`userId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into fuser(uName, uPwd, statue) values ('Alice','Alice123','C');
insert into fuser(uName, uPwd, statue) values ('Clise','Clise123','M');

commit;





