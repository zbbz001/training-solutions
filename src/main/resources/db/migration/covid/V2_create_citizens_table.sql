CREATE TABLE `citizens` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
  `citizen_name` VARCHAR (200) COLLATE utf8_hungarian_ci NOT NULL,
  `zip_code_id` BIGINT (20) DEFAULT NULL,
  `age` BIGINT (20) NOT NULL,
  `email` VARCHAR (200) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `ssn` VARCHAR (10) COLLATE utf8_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_citizens_zip_codes` (`zip_code_id`),
  CONSTRAINT `FK_citizens_zip_codes` FOREIGN KEY (`zip_code_id`) REFERENCES `zip_codes` (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_hungarian_ci