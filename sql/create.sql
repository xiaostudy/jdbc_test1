
DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(20) NOT NULL DEFAULT "",
password VARCHAR(20) NOT NULL DEFAULT ""
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户表';