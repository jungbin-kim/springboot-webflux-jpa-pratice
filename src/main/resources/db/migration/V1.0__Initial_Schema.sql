CREATE TABLE `content` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `content_overview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content_id` INT DEFAULT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `content_overview_child` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content_overview_id` INT DEFAULT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


INSERT INTO `test-jpa-lazy`.`content` (`name`) VALUES ('Content #1');
INSERT INTO `test-jpa-lazy`.`content` (`name`) VALUES ('Content #2');
INSERT INTO `test-jpa-lazy`.`content_overview` (`content_id`, `name`) VALUES (1, 'Content #1 > Overview #1');
INSERT INTO `test-jpa-lazy`.`content_overview` (`content_id`, `name`) VALUES (1, 'Content #1 > Overview #2');
INSERT INTO `test-jpa-lazy`.`content_overview` (`content_id`, `name`) VALUES (2, 'Content #2 > Overview #1');
INSERT INTO `test-jpa-lazy`.`content_overview_child` (`content_overview_id`, `name`) VALUES (1, 'Content #1 > Overview #1 > Child #1');
INSERT INTO `test-jpa-lazy`.`content_overview_child` (`content_overview_id`, `name`) VALUES (1, 'Content #1 > Overview #1 > Child #2');
INSERT INTO `test-jpa-lazy`.`content_overview_child` (`content_overview_id`, `name`) VALUES (2, 'Content #1 > Overview #2 > Child #1');
INSERT INTO `test-jpa-lazy`.`content_overview_child` (`content_overview_id`, `name`) VALUES (3, 'Content #2 > Overview #1 > Child #1');

