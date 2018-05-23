CREATE TABLE roles
(
    id_role INT PRIMARY KEY AUTO_INCREMENT,
    role_description VARCHAR(50)
);
ALTER TABLE roles COMMENT = 'The table of the role for each user';

CREATE TABLE users
(
    id_user INT PRIMARY KEY COMMENT 'The primary key of the table' AUTO_INCREMENT,
    username VARCHAR(250) NOT NULL COMMENT 'Unique column',
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250),
    role_id INT COMMENT 'foreign key of the table roles',
    date_creation DATETIME,
    date_update DATETIME,
    date_deletion DATETIME
);
CREATE UNIQUE INDEX users_username_uindex ON users (username);
CREATE UNIQUE INDEX users_email_uindex ON users (email);
ALTER TABLE users COMMENT = 'The user table';

ALTER TABLE users
    ADD CONSTRAINT users_roles_id_role_fk
FOREIGN KEY (role_id) REFERENCES roles (id_role);