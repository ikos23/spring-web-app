/* Create tables using H2 SQL dialect  
   DATE format is yyyy-MM-dd
*/

/* ================================================================================================================================================================================== */
/*  EMPLOYEE table          | created to store basic information about employee (first/last name, birthDate, level, skill, is manager)                                                */
/* ================================================================================================================================================================================== */
CREATE TABLE Employee(id INT PRIMARY KEY, first_name VARCHAR(35) NOT NULL, last_name VARCHAR(55) NOT NULL, birth_date DATE NOT NULL, emp_level VARCHAR(3) NOT NULL, prim_skill VARCHAR(15) NOT NULL, is_manager VARCHAR(1) NOT NULL);

/* ================================================================================================================================================================================== */
/*  MTProgram table         | Mentorship program (program name, office, start/end date, creation date, created by user, etc)                                                          */
/* ================================================================================================================================================================================== */
CREATE TABLE MTProgram(id INT PRIMARY KEY, name VARCHAR(30) NOT NULL, office_location VARCHAR(50) NOT NULL, start_date DATE NOT NULL, end_date DATE NOT NULL, created_by VARCHAR(25), creation_date DATE, last_modif_by VARCHAR(25), last_modif_date DATE);

/* ================================================================================================================================================================================== */
/*  Phase table             | Mentorship program phase. Mentorship program can consist of several phases, so each phase has an ID of the program it belongs to (mt_program_id)        */
/* ================================================================================================================================================================================== */
CREATE TABLE Phase(id INT PRIMARY KEY, name VARCHAR(30) NOT NULL, mt_program_id INT NOT NULL, start_date DATE NOT NULL, end_date DATE NOT NULL);

/* ================================================================================================================================================================================== */
/*  Role table              | Created to store roles (mentor, mentee, curator, lector). Roles are pre-defined, there is no service to add record to this table                        */
/* ================================================================================================================================================================================== */
CREATE TABLE Role(id INT PRIMARY KEY, name VARCHAR(15) NOT NULL);

/* ================================================================================================================================================================================== */
/*  Status table            | Stores reference data - Statuses (initiation, in progress, finished, cencelled).                                                                        */
/* ================================================================================================================================================================================== */
CREATE TABLE Status(id INT PRIMARY KEY, name VARCHAR(15) NOT NULL);

/* ================================================================================================================================================================================== */
/*  PhasePartisipAssignments| Phase participant assignments - this table is used to store information about employee role in particular phase,                                        */
/*                            status (proposed, approved rm, confirmed cdp, on hold). Example : Foo employee is mentor in some phase                                                  */                                               
/* ================================================================================================================================================================================== */
CREATE TABLE PhasePartisipAssignments(id INT PRIMARY KEY, employee_id INT NOT NULL, role_id INT NOT NULL, phase_id INT NOT NULL, status VARCHAR(15));

/* ================================================================================================================================================================================== */
/*  MtGroup table           | Group - stores information about group. Group is mentor/mentee pair, group has start/end date, etc.                                                     */
/* ================================================================================================================================================================================== */
CREATE TABLE MtGroup(id INT PRIMARY KEY, mentor_id INT NOT NULL, mentee_id INT NOT NULL, planned_start DATE NOT NULL, planned_end DATE NOT NULL, actual_start DATE, actual_end DATE, status_id INT, duration INT);

/* ================================================================================================================================================================================== */
/*  Logs                    | This table is used to store some logs (In particular, some DAO method calls are stored here. )                                                          */
/* ================================================================================================================================================================================== */
CREATE TABLE Logs(id INT PRIMARY KEY, method_name VARCHAR(70), params VARCHAR(400), invokation_date DATE);


CREATE SEQUENCE MP_SEQ START WITH 10000;
CREATE SEQUENCE PHASE_SEQ START WITH 10000;
CREATE SEQUENCE PPA_SEQ START WITH 10000;
CREATE SEQUENCE GRP_SEQ START WITH 10000;
CREATE SEQUENCE LOG_SEQ START WITH 10000;