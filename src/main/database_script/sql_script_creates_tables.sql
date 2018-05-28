-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
    `id_course` int(11) NOT NULL,
    `description` varchar(250) DEFAULT NULL,
    `code` varchar(50) DEFAULT NULL,
    `status` enum('ACTIVE','DISABLED') DEFAULT NULL,
    `year` varchar(250) DEFAULT NULL,
    `remarks` varchar(250) DEFAULT NULL,
    `lecturer_id` int(11) DEFAULT NULL,
    `grade` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id_course`, `description`, `code`, `status`, `year`, `remarks`, `lecturer_id`, `grade`) VALUES
    (9, 'Java', 'JV', 'ACTIVE', '2018', 'Test on Java', 22, '');

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

CREATE TABLE `course_student` (
    `id_course_student` int(11) NOT NULL,
    `course_id` int(11) DEFAULT NULL,
    `student_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`id_course_student`, `course_id`, `student_id`) VALUES
    (10, 9, 24);

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
    `id_exam` int(11) NOT NULL,
    `description` varchar(250) DEFAULT NULL,
    `course_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id_exam`, `description`, `course_id`) VALUES
    (13, 'Beginner', 9),
    (14, 'Test', 9),
    (15, 'Test', 9),
    (16, 'abc', 9);

-- --------------------------------------------------------

--
-- Table structure for table `exam_detail_result`
--

CREATE TABLE `exam_detail_result` (
    `id_exam_detail_result` int(11) NOT NULL,
    `answer` tinyint(1) DEFAULT NULL,
    `exam_question_id` int(11) DEFAULT NULL,
    `student_id` int(11) DEFAULT NULL,
    `exam_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_detail_result`
--

INSERT INTO `exam_detail_result` (`id_exam_detail_result`, `answer`, `exam_question_id`, `student_id`, `exam_id`) VALUES
    (13, 1, 16, 24, 13),
    (14, 0, 14, 24, 13),
    (15, 1, 13, 24, 13),
    (16, 0, 15, 24, 13);

-- --------------------------------------------------------

--
-- Table structure for table `exam_question`
--

CREATE TABLE `exam_question` (
    `id_exam_question` int(11) NOT NULL,
    `question` text,
    `type_question_mandatory` tinyint(1) DEFAULT NULL,
    `answer` tinyint(1) DEFAULT NULL,
    `order_item` int(11) DEFAULT NULL,
    `visibility` tinyint(1) DEFAULT NULL,
    `exam_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_question`
--

INSERT INTO `exam_question` (`id_exam_question`, `question`, `type_question_mandatory`, `answer`, `order_item`, `visibility`, `exam_id`) VALUES
    (13, '3', NULL, 1, 2, NULL, 13),
    (14, '2', NULL, 0, 1, NULL, 13),
    (15, '4', NULL, 0, 3, NULL, 13),
    (16, '1', NULL, 1, 0, NULL, 13),
    (17, 'Test 2', NULL, 1, 1, NULL, 14),
    (18, 'Test', NULL, 1, 0, NULL, 14),
    (19, 'Test', NULL, 1, 0, NULL, 15),
    (20, 'Test 3', NULL, 1, 2, NULL, 15),
    (21, 'Test 4', NULL, 0, 3, NULL, 15),
    (22, 'Test 2', NULL, 1, 1, NULL, 15),
    (23, '1', NULL, 1, 5, NULL, 16),
    (24, '1', NULL, 1, 3, NULL, 16),
    (25, '1', NULL, 1, 8, NULL, 16),
    (26, '1', NULL, 1, 11, NULL, 16),
    (27, '1', NULL, 1, 12, NULL, 16),
    (28, '1', NULL, 1, 10, NULL, 16),
    (29, '1', NULL, 1, 7, NULL, 16),
    (30, '1', NULL, 1, 1, NULL, 16),
    (31, '1', NULL, 1, 0, NULL, 16),
    (32, '1', NULL, 1, 2, NULL, 16),
    (33, '1', NULL, 1, 6, NULL, 16),
    (34, '1', NULL, 1, 9, NULL, 16),
    (35, '1', NULL, 1, 4, NULL, 16);

-- --------------------------------------------------------

--
-- Table structure for table `exam_result`
--

CREATE TABLE `exam_result` (
    `id_exam_result` int(11) NOT NULL,
    `result` varchar(250) DEFAULT NULL,
    `student_id` int(11) DEFAULT NULL,
    `exam_end_date` datetime DEFAULT NULL,
    `exam_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_result`
--

INSERT INTO `exam_result` (`id_exam_result`, `result`, `student_id`, `exam_end_date`, `exam_id`) VALUES
    (1, '100 %', 24, '2018-05-28 20:24:35', 13);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
    (1),
    (1),
    (1),
    (1);

-- --------------------------------------------------------

--
-- Table structure for table `lecturer_detail`
--

CREATE TABLE `lecturer_detail` (
    `id_lecturer_detail` int(11) NOT NULL,
    `lecturer_code` varchar(250) DEFAULT NULL,
    `address` varchar(250) DEFAULT NULL,
    `place_birthday` varchar(250) DEFAULT NULL,
    `email` varchar(250) DEFAULT NULL,
    `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer_detail`
--

INSERT INTO `lecturer_detail` (`id_lecturer_detail`, `lecturer_code`, `address`, `place_birthday`, `email`, `user_id`) VALUES
    (16, NULL, '', '', 'aa', 22),
    (17, '0QHCPT7OCA', '', '', 'dsa', 25);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
    `id_role` int(11) NOT NULL,
    `role_description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The table of the role for each user';

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `role_description`) VALUES
    (1, 'Administrator'),
    (2, 'Lecturer'),
    (3, 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `student_detail`
--

CREATE TABLE `student_detail` (
    `id_student_detail` int(11) NOT NULL,
    `student_code` varchar(250) DEFAULT NULL,
    `amza_number` varchar(250) DEFAULT NULL,
    `address` varchar(250) DEFAULT NULL,
    `place_birthday` varchar(250) DEFAULT NULL,
    `religion` varchar(250) DEFAULT NULL,
    `email` varchar(250) DEFAULT NULL,
    `father_name` varchar(250) DEFAULT NULL,
    `mother_name` varchar(250) DEFAULT NULL,
    `scholarship` varchar(250) DEFAULT NULL,
    `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_detail`
--

INSERT INTO `student_detail` (`id_student_detail`, `student_code`, `amza_number`, `address`, `place_birthday`, `religion`, `email`, `father_name`, `mother_name`, `scholarship`, `user_id`) VALUES
    (3, NULL, NULL, '', '', NULL, 'bb', '', '', NULL, 24);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
    `id_user` int(11) NOT NULL COMMENT 'The primary key of the table',
    `username` varchar(250) NOT NULL COMMENT 'Unique column',
    `first_name` varchar(250) DEFAULT NULL,
    `last_name` varchar(250) DEFAULT NULL,
    `email` varchar(250) NOT NULL,
    `password` varchar(250) DEFAULT NULL,
    `last_login_date` datetime DEFAULT NULL,
    `gender` varchar(250) DEFAULT NULL,
    `date_deletion` datetime DEFAULT NULL,
    `date_update` datetime DEFAULT NULL,
    `date_creation` datetime DEFAULT NULL,
    `role_id` int(11) DEFAULT NULL COMMENT 'foreign key of the table role',
    `status` enum('ACTIVE','DISABLED') DEFAULT NULL,
    `date_birthday` datetime DEFAULT NULL,
    `phone_number` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The user table';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `first_name`, `last_name`, `email`, `password`, `last_login_date`, `gender`, `date_deletion`, `date_update`, `date_creation`, `role_id`, `status`, `date_birthday`, `phone_number`) VALUES
    (1, 'ardit', 'ardit', 'ardit', 'ardit', 'ardit', '2018-05-28 21:51:10', 'M', NULL, '2018-05-26 01:29:42', '2018-05-26 01:29:42', 1, 'ACTIVE', '2018-05-26 01:29:42', '123'),
    (22, 'aa.aa', 'aa', 'aa', 'aa', 'aa', '2018-05-29 00:15:44', 'Male', NULL, '2018-05-28 21:48:43', '2018-05-28 21:48:43', 2, 'ACTIVE', NULL, '123456'),
    (24, 'bb.bb', 'bb', 'bb', 'bb', 'bb', '2018-05-29 00:19:16', '', NULL, '2018-05-28 21:48:29', '2018-05-28 00:57:55', 3, 'ACTIVE', '1990-11-11 00:00:00', '123'),
    (25, 'dsa.dsa', 'dsa', 'dsa', 'dsa', 'dsa', NULL, '', NULL, '2018-05-28 21:51:21', '2018-05-28 21:51:21', 2, 'ACTIVE', NULL, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
    ADD PRIMARY KEY (`id_course`),
    ADD UNIQUE KEY `course_code_uindex` (`code`),
    ADD KEY `course_user_id_user_fk` (`lecturer_id`);

--
-- Indexes for table `course_student`
--
ALTER TABLE `course_student`
    ADD PRIMARY KEY (`id_course_student`),
    ADD KEY `course_student_course_id_course_fk` (`course_id`),
    ADD KEY `course_student_user_id_user_fk` (`student_id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
    ADD PRIMARY KEY (`id_exam`),
    ADD KEY `exam_course_course_id_course_fk` (`course_id`);

--
-- Indexes for table `exam_detail_result`
--
ALTER TABLE `exam_detail_result`
    ADD PRIMARY KEY (`id_exam_detail_result`),
    ADD KEY `exam_detail_result_exam_id_exam_exam_fk` (`exam_id`),
    ADD KEY `exam_detail_result_exam_id_exam_fk` (`exam_question_id`),
    ADD KEY `exam_detail_result_user_id_user_fk` (`student_id`);

--
-- Indexes for table `exam_question`
--
ALTER TABLE `exam_question`
    ADD PRIMARY KEY (`id_exam_question`),
    ADD KEY `exam_question_exam_id_exam_fk` (`exam_id`);

--
-- Indexes for table `exam_result`
--
ALTER TABLE `exam_result`
    ADD PRIMARY KEY (`id_exam_result`),
    ADD KEY `exam_result_exam_id_exam_fk` (`exam_id`),
    ADD KEY `exam_result_user_id_user_fk` (`student_id`);

--
-- Indexes for table `lecturer_detail`
--
ALTER TABLE `lecturer_detail`
    ADD PRIMARY KEY (`id_lecturer_detail`),
    ADD KEY `lecturer_detail_user_id_user_fk` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
    ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `student_detail`
--
ALTER TABLE `student_detail`
    ADD PRIMARY KEY (`id_student_detail`),
    ADD KEY `student_detail_user_id_user_fk` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id_user`),
    ADD UNIQUE KEY `user_username_uindex` (`username`),
    ADD UNIQUE KEY `user_email_uindex` (`email`),
    ADD KEY `user_role_id_role_fk` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
    MODIFY `id_course` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `course_student`
--
ALTER TABLE `course_student`
    MODIFY `id_course_student` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
    MODIFY `id_exam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `exam_detail_result`
--
ALTER TABLE `exam_detail_result`
    MODIFY `id_exam_detail_result` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `exam_question`
--
ALTER TABLE `exam_question`
    MODIFY `id_exam_question` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `exam_result`
--
ALTER TABLE `exam_result`
    MODIFY `id_exam_result` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lecturer_detail`
--
ALTER TABLE `lecturer_detail`
    MODIFY `id_lecturer_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
    MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student_detail`
--
ALTER TABLE `student_detail`
    MODIFY `id_student_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT COMMENT 'The primary key of the table', AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
    ADD CONSTRAINT `course_user_id_user_fk` FOREIGN KEY (`lecturer_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
    ADD CONSTRAINT `course_student_course_id_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id_course`),
    ADD CONSTRAINT `course_student_user_id_user_fk` FOREIGN KEY (`student_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
    ADD CONSTRAINT `exam_course_course_id_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id_course`);

--
-- Constraints for table `exam_detail_result`
--
ALTER TABLE `exam_detail_result`
    ADD CONSTRAINT `exam_detail_result_exam_id_exam_exam_fk` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id_exam`),
    ADD CONSTRAINT `exam_detail_result_exam_id_exam_fk` FOREIGN KEY (`exam_question_id`) REFERENCES `exam_question` (`id_exam_question`),
    ADD CONSTRAINT `exam_detail_result_user_id_user_fk` FOREIGN KEY (`student_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `exam_question`
--
ALTER TABLE `exam_question`
    ADD CONSTRAINT `exam_question_exam_id_exam_fk` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id_exam`);

--
-- Constraints for table `exam_result`
--
ALTER TABLE `exam_result`
    ADD CONSTRAINT `exam_result_exam_id_exam_fk` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id_exam`),
    ADD CONSTRAINT `exam_result_user_id_user_fk` FOREIGN KEY (`student_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `lecturer_detail`
--
ALTER TABLE `lecturer_detail`
    ADD CONSTRAINT `lecturer_detail_user_id_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `student_detail`
--
ALTER TABLE `student_detail`
    ADD CONSTRAINT `student_detail_user_id_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `user_role_id_role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id_role`);
COMMIT;
