DROP table if exists `student`;
DROP table if exists `report_card`;
DROP table if exists `subject`;
DROP table if exists `address`;


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
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
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

  CREATE TABLE `report_card` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `student_id` bigint(20) NOT NULL,
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `FK_student_id` (`student_id`),
    CONSTRAINT `FK_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
    );

  CREATE TABLE `subject` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `marks_obtained` int NOT NULL,
    `max_marks` int NOT NULL,
    `report_card_id` bigint(20) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_address_updated_at` (`updated_at`),
    KEY `FK_report_card_id` (`report_card_id`),
  CONSTRAINT `FK_report_card_id` FOREIGN KEY (`report_card_id`) REFERENCES `report_card` (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ;

