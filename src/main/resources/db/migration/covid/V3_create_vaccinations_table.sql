CREATE TABLE `vaccinations` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
  `citizen_id` BIGINT (20) NOT NULL,
  `vaccinations_ts` TIMESTAMP NOT NULL,
  `vaccinations_status` TINYINT (1) DEFAULT NULL,
  `vaccinations_note` VARCHAR (200) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `vaccine_type` VARCHAR (20) COLLATE utf8_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_vaccinations_citizen` (`citizen_id`),
  KEY `FK_vaccinations_vaccine` (`vaccine_type`),
  CONSTRAINT `FK_vaccinations_citizen` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 13 DEFAULT CHARSET = utf8 COLLATE = utf8_hungarian_ci;