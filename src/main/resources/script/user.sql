CREATE TABLE `user`
(
    `id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `name`   varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
    `age`    tinyint(4) DEFAULT NULL,
    `gender` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--- master
INSERT INTO `user` (`id`, `name`, `age`, `gender`) VALUES (1, 'Hanmeimei', 19, 0);

--- slave
INSERT INTO `user` (`id`, `name`, `age`, `gender`) VALUES (1, 'LiLei', 18, 1);
