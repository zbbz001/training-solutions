CREATE TABLE `zip_codes` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
  `zip_code` VARCHAR (255) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `settlement` VARCHAR (255) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `settlement_part` VARCHAR (255) COLLATE utf8_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 3325 DEFAULT CHARSET = utf8 COLLATE = utf8_hungarian_ci;