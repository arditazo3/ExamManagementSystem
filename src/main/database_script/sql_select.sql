select *  from user  where username = 'ardit' and        password = 'ardit' and        status = 'ACTIVE';

insert into user(username, first_name, last_name, email, password, last_login_date, gender, date_deletion, date_update, date_creation, role_id, status, date_birthday, phone_number) VALUES
  ('ardit', 'ardit', 'ardit', 'ardit', 'ardit', now(), 'M', null, now(), now(), null, 'ACTIVE', NOW(), '123');

insert into course_student(course_id, student_id) VALUES (7, 23);

select * from exam; 

