/* Ref data : Roles */
insert into Role(id, name) values (1, 'mentor');
insert into Role(id, name) values (2, 'mentee');
insert into Role(id, name) values (3, 'curator');
insert into Role(id, name) values (4, 'lector');

/* Ref data : Statuses */
insert into Status(id, name) values (1, 'initiation');
insert into Status(id, name) values (2, 'in progress');
insert into Status(id, name) values (3, 'finished ');
insert into Status(id, name) values (4, 'cancelled');

/* Test users */
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (1, 'Іван', 'Іванов', '1990-02-25', 'L2', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (2, 'Bill', 'Gates', '1955-10-28', 'L5', 'Java', 'Y');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (3, 'Kurt', 'Cobain', '1967-02-20', 'L2', 'JavaScript', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (4, 'Bart', 'Simpson', '1997-12-02', 'T2', 'Java', 'N');

insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (5, 'Shaldon', 'Cooper', '1987-07-22', 'L5', 'Java', 'Y');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (6, 'Hovard', 'Wolowitz', '1988-04-13', 'L5', 'Java', 'Y');

insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (7, 'Leonard', 'Hofsteder', '1985-05-07', 'L1', 'Java 8', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (8, 'Barry', 'Allen', '1991-11-27', 'L3', 'Java', 'N');

insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (9, 'User1 First', 'User 1 Last', '1967-02-11', 'L1', 'JavaScript', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (10, 'Empl2 First', 'Empl2 Last', '1993-01-19', 'L1', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (11, 'User3', 'User3 Last Name', '1989-12-17', 'L3', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (12, 'User4', 'User4', '1995-08-22', 'L1', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (13, 'User5', 'User5', '1985-02-11', 'D2', 'Java', 'Y');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (14, 'Foo', 'Bar', '1977-10-14', 'L4', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (15, 'Student', 'Student1', '1994-08-20', 'L2', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (16, 'Orange', 'Juice', '1990-05-13', 'L2', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (17, 'Ggggg', 'Bbbbb', '1991-07-07', 'L1', 'Java', 'N');

/* Mentorship Programs */
insert into MTProgram VALUES (1, 'JAVA 16W', 'LVIV', '2016-10-20', '2016-12-23', 'test_user', '2016-10-18', 'test_user', '2016-10-18');
insert into MTProgram VALUES (2, 'JavaScript 16-2', 'LVIV', '2016-11-01', '2016-12-05', 'admin', '2016-10-28', 'admin', '2016-10-28');
insert into MTProgram VALUES (3, '.NET_MP_16', 'LVIV', '2016-09-05', '2016-12-10', 'admin', '2016-09-03', 'admin', '2016-09-05');

insert into MTProgram VALUES (4, 'JaMP 16', 'KYIV', '2016-10-01', '2016-12-28', 'user4', '2016-09-29', 'user4', '2016-09-29');
insert into MTProgram VALUES (5, 'PhpMP 16', 'KYIV', '2016-10-01', '2016-12-28', 'admin', '2016-09-29', 'admin', '2016-09-29');

insert into MTProgram VALUES (6, 'JAVA', 'VINNYTSYA', '2016-08-29', '2016-12-28', 'user4', '2016-08-29', 'user4', '2016-08-29');

insert into Phase VALUES (1, 'P1', 1, '2016-10-20', '2016-11-22');
insert into Phase VALUES (2, 'P2', 1, '2016-12-03', '2016-12-23');

insert into Phase VALUES (3, 'JS Main Phase', 2, '2016-11-01', '2016-12-05');

insert into Phase VALUES (4, 'JS Main Phase', 3, '2016-09-05', '2016-11-04');
insert into Phase VALUES (5, 'JS Main Phase', 3, '2016-11-08', '2016-12-10');

insert into Phase VALUES (6, 'P1', 4, '2016-10-01', '2016-12-28');

insert into Phase VALUES (7, 'PhP Main', 5, '2016-10-01', '2016-12-28');

insert into Phase VALUES (8, 'J_part1', 6, '2016-08-29', '2016-09-25');
insert into Phase VALUES (9, 'J_part2', 6, '2016-10-01', '2016-11-15');
insert into Phase VALUES (10, 'J_part3', 6, '2016-11-21', '2016-12-28');

/* insert into PhasePartisipAssignments VALUES (id INT PRIMARY KEY, employee_id INT NOT NULL, role_id INT NOT NULL, phase_id INT NOT NULL, status VARCHAR(15)); */

insert into PhasePartisipAssignments VALUES (1111, 1, 2, 1, 'approved');
insert into PhasePartisipAssignments VALUES (1112, 3, 2, 1, 'approved');
insert into PhasePartisipAssignments VALUES (1113, 2, 1, 1, 'approved');

insert into MtGroup VALUES (1111, 2, 1, '2016-10-22', '2016-11-22', NULL, NULL, 1, 12);
insert into MtGroup VALUES (1112, 2, 3, '2016-10-22', '2016-11-22', NULL, NULL, 1, 15);

/* CREATE TABLE MtGroup(id INT PRIMARY KEY, mentor_id INT NOT NULL, mentee_id INT NOT NULL, planned_start DATE NOT NULL, planned_end DATE NOT NULL, actual_start DATE, actual_end DATE, status_id INT); */

insert into PhasePartisipAssignments VALUES (1114, 9, 2, 2, 'approved');
insert into PhasePartisipAssignments VALUES (1115, 5, 1, 2, 'approved');

insert into MtGroup VALUES (1113, 5, 9, '2016-12-03', '2016-12-23', NULL, NULL, 1, 22);
insert into MtGroup VALUES (1114, 2, 9, '2015-12-03', '2015-12-23', NULL, NULL, 1, 48);


