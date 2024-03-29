create schema `dynamic` collate utf8mb4_bin;

CREATE TABLE `dynamic`.`user`
(
    `id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `name`   varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
    `age`    tinyint(4) DEFAULT NULL,
    `gender` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--- master
INSERT INTO `dynamic`.`user` (`id`, `name`, `age`, `gender`) VALUES (1, 'Master', 19, 0);

--- slave
INSERT INTO `dynamic`.`user` (`id`, `name`, `age`, `gender`) VALUES (1, 'Slave', 18, 1);
