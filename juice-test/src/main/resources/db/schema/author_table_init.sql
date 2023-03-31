CREATE TABLE `author`
(
    `id`    varchar(50)  NOT NULL COMMENT '主键ID',
    `first_name`  varchar(30) NULL DEFAULT NULL COMMENT 'firstName',
    `last_name` varchar(50) NULL DEFAULT NULL COMMENT 'lastName',
    PRIMARY KEY (`id`)
);