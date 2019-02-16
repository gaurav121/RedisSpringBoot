DROP table if exists `address`;
DROP table if exists `student`;


show tables;

  CREATE TABLE `address` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `street` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `street2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `city` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `state` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `country` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `zip_code` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_address_updated_at` (`updated_at`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ;


CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `roll_no` varchar(50) NOT NULL,
  `standard` varchar(50) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_address_id` (`address_id`),
  CONSTRAINT `FK_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
  );