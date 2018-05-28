create table course
(
	id_course int auto_increment
		primary key,
	description varchar(250) null,
	code varchar(50) null,
	status enum('ACTIVE', 'DISABLED') null,
	year varchar(250) null,
	remarks varchar(250) null,
	lecturer_id int null,
	grade varchar(250) null,
	constraint course_code_uindex
		unique (code)
)
;

create index course_user_id_user_fk
	on course (lecturer_id)
;

create table course_student
(
	id_course_student int auto_increment
		primary key,
	course_id int null,
	student_id int null,
	constraint course_student_course_id_course_fk
		foreign key (course_id) references course (id_course)
)
;

create index course_student_course_id_course_fk
	on course_student (course_id)
;

create index course_student_user_id_user_fk
	on course_student (student_id)
;

create table exam
(
	id_exam int auto_increment
		primary key,
	description varchar(250) null,
	course_id int null,
	constraint exam_course_course_id_course_fk
		foreign key (course_id) references course (id_course)
)
;

create index exam_course_course_id_course_fk
	on exam (course_id)
;

create table exam_detail_result
(
	id_exam_detail_result int auto_increment
		primary key,
	answer tinyint(1) null,
	exam_question_id int null,
	student_id int null,
	exam_id int null,
	constraint exam_detail_result_exam_id_exam_exam_fk
		foreign key (exam_id) references exam (id_exam)
)
;

create index exam_detail_result_exam_id_exam_exam_fk
	on exam_detail_result (exam_id)
;

create index exam_detail_result_exam_id_exam_fk
	on exam_detail_result (exam_question_id)
;

create index exam_detail_result_user_id_user_fk
	on exam_detail_result (student_id)
;

create table exam_question
(
	id_exam_question int auto_increment
		primary key,
	question text null,
	type_question_mandatory tinyint(1) null,
	answer tinyint(1) null,
	order_item int null,
	visibility tinyint(1) null,
	exam_id int null,
	constraint exam_question_exam_id_exam_fk
		foreign key (exam_id) references exam (id_exam)
)
;

create index exam_question_exam_id_exam_fk
	on exam_question (exam_id)
;

alter table exam_detail_result
	add constraint exam_detail_result_exam_id_exam_fk
		foreign key (exam_question_id) references exam_question (id_exam_question)
;

create table exam_result
(
	id_exam_result int auto_increment
		primary key,
	result varchar(250) null,
	student_id int null,
	exam_end_date datetime null,
	exam_id int null,
	constraint exam_result_exam_id_exam_fk
		foreign key (exam_id) references exam (id_exam)
)
;

create index exam_result_user_id_user_fk
	on exam_result (student_id)
;

create index exam_result_exam_id_exam_fk
	on exam_result (exam_id)
;

create table hibernate_sequence
(
	next_val bigint null
)
;

create table lecturer_detail
(
	id_lecturer_detail int auto_increment
		primary key,
	lecturer_code varchar(250) null,
	address varchar(250) null,
	place_birthday varchar(250) null,
	email varchar(250) null,
	user_id int null
)
;

create index lecturer_detail_user_id_user_fk
	on lecturer_detail (user_id)
;

create table role
(
	id_role int auto_increment
		primary key,
	role_description varchar(50) null
)
comment 'The table of the role for each user'
;

create table student_detail
(
	id_student_detail int auto_increment
		primary key,
	student_code varchar(250) null,
	amza_number varchar(250) null,
	address varchar(250) null,
	place_birthday varchar(250) null,
	religion varchar(250) null,
	email varchar(250) null,
	father_name varchar(250) null,
	mother_name varchar(250) null,
	scholarship varchar(250) null,
	user_id int null
)
;

create index student_detail_user_id_user_fk
	on student_detail (user_id)
;

create table user
(
	id_user int auto_increment comment 'The primary key of the table'
		primary key,
	username varchar(250) not null comment 'Unique column',
	first_name varchar(250) null,
	last_name varchar(250) null,
	email varchar(250) not null,
	password varchar(250) null,
	last_login_date datetime null,
	gender varchar(250) null,
	date_deletion datetime null,
	date_update datetime null,
	date_creation datetime null,
	role_id int null comment 'foreign key of the table role',
	status enum('ACTIVE', 'DISABLED') null,
	date_birthday datetime null,
	phone_number varchar(250) null,
	constraint user_username_uindex
		unique (username),
	constraint user_email_uindex
		unique (email),
	constraint user_role_id_role_fk
		foreign key (role_id) references role (id_role)
)
comment 'The user table'
;

create index user_role_id_role_fk
	on user (role_id)
;

alter table course
	add constraint course_user_id_user_fk
		foreign key (lecturer_id) references user (id_user)
;

alter table course_student
	add constraint course_student_user_id_user_fk
		foreign key (student_id) references user (id_user)
;

alter table exam_detail_result
	add constraint exam_detail_result_user_id_user_fk
		foreign key (student_id) references user (id_user)
;

alter table exam_result
	add constraint exam_result_user_id_user_fk
		foreign key (student_id) references user (id_user)
;

alter table lecturer_detail
	add constraint lecturer_detail_user_id_user_fk
		foreign key (user_id) references user (id_user)
;

alter table student_detail
	add constraint student_detail_user_id_user_fk
		foreign key (user_id) references user (id_user)
;

