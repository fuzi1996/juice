CREATE TABLE `bookEntity`
(
    `id`    varchar(50)  NOT NULL COMMENT '主键ID',
    `name`  varchar(50) NULL DEFAULT NULL COMMENT '姓名',
    `page_count`   int(11)     NULL DEFAULT NULL COMMENT '页数',
    `author_id` varchar(50) NULL DEFAULT NULL COMMENT '作者ID',
    PRIMARY KEY (`id`)
);