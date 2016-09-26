/* Create tables using H2 SQL dialect  
   DATE format is yyyy-MM-dd
*/
CREATE TABLE Employee(id INT PRIMARY KEY, first_name VARCHAR(35) NOT NULL, last_name VARCHAR(55) NOT NULL, birth_date DATE NOT NULL, emp_level VARCHAR(3) NOT NULL, prim_skill VARCHAR(15) NOT NULL, is_manager VARCHAR(1) NOT NULL);

/* Mentorship program */
CREATE TABLE MTProgram(id INT PRIMARY KEY, name VARCHAR(30) NOT NULL, office_location VARCHAR(50) NOT NULL, start_date DATE NOT NULL, end_date DATE NOT NULL, created_by VARCHAR(25), creation_date DATE, last_modif_by VARCHAR(25), last_modif_date DATE);

/* Mentorship program phase */
CREATE TABLE Phase(id INT PRIMARY KEY, name VARCHAR(30) NOT NULL, mt_program_id INT NOT NULL, start_date DATE NOT NULL, end_date DATE NOT NULL);

/* Role (e.g.mentor, mentee, curator, lector) */
CREATE TABLE Role(id INT PRIMARY KEY, name VARCHAR(15) NOT NULL);

/* Status */
CREATE TABLE Status(id INT PRIMARY KEY, name VARCHAR(15) NOT NULL);

/* Phase participant assignments */
CREATE TABLE PhasePartisipAssignments(id INT PRIMARY KEY, employee_id INT NOT NULL, role_id INT NOT NULL, status VARCHAR(15) NOT NULL);

/* Groups */
CREATE TABLE MtGroup(id INT PRIMARY KEY, mentor_id INT NOT NULL, mentee_id INT NOT NULL, planned_start DATE NOT NULL, planned_end DATE NOT NULL, actual_start DATE NOT NULL, actual_end DATE NOT NULL, status_id INT NOT NULL);

CREATE TABLE Logs(id INT PRIMARY KEY, method_name VARCHAR(70), params VARCHAR(400), invokation_date DATE);

CREATE SEQUENCE MP_SEQ;
CREATE SEQUENCE PHASE_SEQ;
CREATE SEQUENCE PPA_SEQ;
CREATE SEQUENCE GRP_SEQ;

CREATE SEQUENCE LOG_SEQ;