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
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (1, 'Панас', 'Мирний', '1990-02-25', 'L2', 'Java', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (2, 'Bill', 'Gates', '1955-10-28', 'L5', 'Java', 'Y');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (3, 'Kurt', 'Cobain', '1967-02-20', 'L2', 'JavaScript', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (4, 'Bart', 'Simpson', '1997-12-02', 'T2', 'Java', 'N');

insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (5, 'Shaldon', 'Cooper', '1987-07-22', 'L5', 'Java', 'Y');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (6, 'Hovard', 'Wolowitz', '1988-04-13', 'L5', 'Java', 'Y');

insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (7, 'Leonard', 'Hofsteder', '1985-05-07', 'L1', 'Java 8', 'N');
insert into Employee(id, first_name, last_name, birth_date, emp_level, prim_skill, is_manager) values (8, 'Barry', 'Allen', '1991-11-27', 'L3', 'Java', 'N');