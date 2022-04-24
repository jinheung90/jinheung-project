CREATE TABLE `authorities` (
                               `authority_name` varchar(15) NOT NULL,
                               PRIMARY KEY (`authority_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `banners` (
                            `banner_id` bigint NOT NULL AUTO_INCREMENT,
                            `action_body` varchar(255) DEFAULT NULL,
                            `active` bit(1) DEFAULT NULL,
                            `created_at` datetime(6) DEFAULT NULL,
                            `image_url` varchar(255) DEFAULT NULL,
                            `link` varchar(255) DEFAULT NULL,
                            `pos` int DEFAULT NULL,
                            `subtitle` varchar(255) DEFAULT NULL,
                            `thumbnail_url` varchar(255) DEFAULT NULL,
                            `title` varchar(255) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `cancel_users` (
                            `user_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `phone` varchar(255) DEFAULT NULL,
                            `is_recovery` bit(1) DEFAULT NULL,
                            `social_id` bigint DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `user_role` int DEFAULT NULL,
                            PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `canceled_reservations` (
                            `canceled_reservation_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `mentee_id` bigint DEFAULT NULL,
                            `mentor_id` bigint DEFAULT NULL,
                            `cancel_reason` varchar(1023) DEFAULT NULL,
                            `reservation_id` bigint DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `user_role` int DEFAULT NULL,
                            PRIMARY KEY (`canceled_reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `deleted_users` (
                            `deleted_user_id` bigint NOT NULL AUTO_INCREMENT,
                            `delete_at` datetime(6) DEFAULT NULL,
                            `user_id` bigint DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `phone` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`deleted_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `email_authentication_numbers` (
                            `email_authentication_number_id` bigint NOT NULL AUTO_INCREMENT,
                            `email` varchar(255) DEFAULT NULL,
                            `expiration` datetime(6) DEFAULT NULL,
                            `number` int DEFAULT NULL,
                            PRIMARY KEY (`email_authentication_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `kakao_memeber_ids` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `member_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `large_standard_categories` (
                            `large_standard_category_id` bigint NOT NULL AUTO_INCREMENT,
                            `category_name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`large_standard_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentee_profiles` (
                            `mentee_profile_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `department` varchar(31) DEFAULT NULL,
                            `grade` int DEFAULT NULL,
                            `school_type` varchar(31) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `user_type` varchar(31) DEFAULT NULL,
                            `mentee_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentee_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentees` (
                           `mentee_id` bigint NOT NULL AUTO_INCREMENT,
                           `created_at` datetime(6) DEFAULT NULL,
                           `mentee_nickname` varchar(255) DEFAULT NULL,
                           `updated_at` datetime(6) DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`mentee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_cover_letters` (
                            `mentor_cover_letter_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `mentor_id` bigint NOT NULL,
                            `self_introduce` text,
                            `strength_introduce` text,
                            `university_email` varchar(255) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`mentor_cover_letter_id`),
                            UNIQUE KEY `UK_cx9e0p810fu28cm7o39sk67fm` (`mentor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_modified_schedules` (
                            `mentor_modified_schedule_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `modified_end_date_time` datetime(6) DEFAULT NULL,
                            `modified_start_date_time` datetime(6) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `mentor_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentor_modified_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_points` (
                            `mentor_point_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `mentor_point` varchar(2047) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `mentor_profile_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentor_point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_reservation_has_questions` (
                            `mentor_reservation_has_question_id` bigint NOT NULL AUTO_INCREMENT,
                            `question` varchar(255) DEFAULT NULL,
                            `mentor_reservation_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentor_reservation_has_question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_reservations` (
                            `mentor_reservation_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `reservation_end_time` datetime(6) DEFAULT NULL,
                            `reservation_process` varchar(255) DEFAULT NULL,
                            `reservation_start_time` datetime(6) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `mentee_id` bigint DEFAULT NULL,
                            `mentor_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentor_reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_schedule_manages` (
                            `mentor_schedule_manage_id` bigint NOT NULL AUTO_INCREMENT,
                            `active` bit(1) DEFAULT NULL,
                            `reservation_available_day_term` int DEFAULT NULL,
                            `schedule_apply_end_time` datetime(6) DEFAULT NULL,
                            `schedule_apply_start_time` datetime(6) DEFAULT NULL,
                            `mentor_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`mentor_schedule_manage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentor_tags` (
                            `mentor_tag_id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `tag` varchar(255) NOT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`mentor_tag_id`),
                            UNIQUE KEY `UK_lqiv3vnrrh3w31bfy333bx0rp` (`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentors` (
                           `mentor_id` bigint NOT NULL AUTO_INCREMENT,
                           `created_at` datetime(6) DEFAULT NULL,
                           `mentor_nickname` varchar(255) DEFAULT NULL,
                           `updated_at` datetime(6) DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentors_day_of_week_schedules` (
                                                 `mentor_date_schedule_id` bigint NOT NULL AUTO_INCREMENT,
                                                 `day_of_week` varchar(255) DEFAULT NULL,
                                                 `end_min` int DEFAULT NULL,
                                                 `mentor_id` bigint DEFAULT NULL,
                                                 `start_compare_min` int DEFAULT NULL,
                                                 `start_hour` int DEFAULT NULL,
                                                 `start_min` int DEFAULT NULL,
                                                 PRIMARY KEY (`mentor_date_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentors_has_tags` (
                                    `mentor_has_tag_id` bigint NOT NULL AUTO_INCREMENT,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    `mentor_profile_id` bigint DEFAULT NULL,
                                    `mentor_tag_id` bigint DEFAULT NULL,
                                    PRIMARY KEY (`mentor_has_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `mentors_profiles` (
                                    `mentor_profile_id` bigint NOT NULL AUTO_INCREMENT,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `grade` int DEFAULT NULL,
                                    `mentor_audit_type` varchar(255) DEFAULT NULL,
                                    `self_introduce` text,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    `mentor_id` bigint DEFAULT NULL,
                                    `university_id` bigint DEFAULT NULL,
                                    `university_department_id` bigint DEFAULT NULL,
                                    PRIMARY KEY (`mentor_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `policy_marketing` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `activated_at` datetime(6) DEFAULT NULL,
                                    `active` bit(1) NOT NULL,
                                    `body` text NOT NULL,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `deactivated_at` datetime(6) DEFAULT NULL,
                                    `effective_date` date DEFAULT NULL,
                                    `subtitle` varchar(255) NOT NULL,
                                    `title` varchar(255) NOT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `policy_over14` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `activated_at` datetime(6) DEFAULT NULL,
                                    `active` bit(1) NOT NULL,
                                    `body` text NOT NULL,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `deactivated_at` datetime(6) DEFAULT NULL,
                                    `effective_date` date DEFAULT NULL,
                                    `subtitle` varchar(255) NOT NULL,
                                    `title` varchar(255) NOT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `policy_privacy` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `activated_at` datetime(6) DEFAULT NULL,
                                    `active` bit(1) NOT NULL,
                                    `body` text NOT NULL,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `deactivated_at` datetime(6) DEFAULT NULL,
                                    `effective_date` date DEFAULT NULL,
                                    `subtitle` varchar(255) NOT NULL,
                                    `title` varchar(255) NOT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `policy_terms` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `activated_at` datetime(6) DEFAULT NULL,
                                    `active` bit(1) NOT NULL,
                                    `body` text NOT NULL,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `deactivated_at` datetime(6) DEFAULT NULL,
                                    `effective_date` date DEFAULT NULL,
                                    `subtitle` varchar(255) NOT NULL,
                                    `title` varchar(255) NOT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `regions` (
                                    `region_id` bigint NOT NULL AUTO_INCREMENT,
                                    `region_one` varchar(255) DEFAULT NULL,
                                    `region_two` varchar(255) DEFAULT NULL,
                                    PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `universities` (
                                    `university_id` bigint NOT NULL AUTO_INCREMENT,
                                    `email_domain_name` varchar(255) DEFAULT NULL,
                                    `university_name` varchar(255) DEFAULT NULL,
                                    `region_id` bigint DEFAULT NULL,
                                    PRIMARY KEY (`university_id`)


) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `university_departments` (
                                          `user_id` bigint NOT NULL AUTO_INCREMENT,
                                          `department_name` varchar(255) DEFAULT NULL,
                                          `large_standard_category_id` bigint DEFAULT NULL,
                                          PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `university_has_departments` (
                                              `university_has_department_id` bigint NOT NULL AUTO_INCREMENT,
                                              `university_id` bigint DEFAULT NULL,
                                              `university_department_id` bigint DEFAULT NULL,
                                              PRIMARY KEY (`university_has_department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `user_agrees_policies` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `created_at` datetime(6) DEFAULT NULL,
                                        `policy_marketing_id` bigint DEFAULT NULL,
                                        `policy_over14_id` bigint DEFAULT NULL,
                                        `policy_privacy_id` bigint DEFAULT NULL,
                                        `policy_terms_id` bigint DEFAULT NULL,
                                        `updated_at` datetime(6) DEFAULT NULL,
                                        `user_id` bigint NOT NULL,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `user_bank_accounts` (
                                      `user_bank_account_id` bigint NOT NULL AUTO_INCREMENT,
                                      `account_holder` varchar(31) DEFAULT NULL,
                                      `bank_account` varchar(127) DEFAULT NULL,
                                      `bank_name` varchar(31) DEFAULT NULL,
                                      `user_id` bigint NOT NULL,
                                      PRIMARY KEY (`user_bank_account_id`),
                                      UNIQUE KEY `UK_jle3fonrvg5dksji6e6i2i6m0` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `user_has_regions` (
                                    `user_region_id` bigint NOT NULL AUTO_INCREMENT,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `region_id` varchar(255) NOT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    `user_id` bigint DEFAULT NULL,
                                    PRIMARY KEY (`user_region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `user_refresh_token` (
                                      `user_refresh_token_id` bigint NOT NULL AUTO_INCREMENT,
                                      `created_at` datetime(6) DEFAULT NULL,
                                      `created_at_ip` varchar(255) DEFAULT NULL,
                                      `expired_at` bigint DEFAULT NULL,
                                      `refresh_token` varchar(255) DEFAULT NULL,
                                      `user_id` bigint DEFAULT NULL,
                                      PRIMARY KEY (`user_refresh_token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `user_securities` (
                                   `user_security_id` bigint NOT NULL AUTO_INCREMENT,
                                   `created_at` datetime(6) DEFAULT NULL,
                                   `email` varchar(255) DEFAULT NULL,
                                   `password` varchar(255) DEFAULT NULL,
                                   `provider` varchar(15) DEFAULT NULL,
                                   `social_member_id` varchar(255) DEFAULT NULL,
                                   `updated_at` datetime(6) DEFAULT NULL,
                                   `user_id` bigint DEFAULT NULL,
                                   PRIMARY KEY (`user_security_id`),
                                   UNIQUE KEY `UKn9b5ngdhov2ekh6nlv6kajwcj` (`provider`,`social_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `users` (
                         `user_id` bigint NOT NULL AUTO_INCREMENT,
                         `created_at` datetime(6) DEFAULT NULL,
                         `email` varchar(255) DEFAULT NULL,
                         `phone` varchar(255) DEFAULT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         `user_role` int DEFAULT NULL,
                         `region_id` bigint DEFAULT NULL,
                         PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `users_authorities` (
                                     `user_id` bigint NOT NULL,
                                     `authority_name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;
















