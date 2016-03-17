CREATE DATABASE myappdb;
USE myappdb;

CREATE TABLE employee
(
	empid INTEGER NOT NULL,
	empuhnumber VARCHAR(8) NOT NULL,
	empfirstname VARCHAR(40) NOT NULL,
	emplastname VARCHAR(40) NOT NULL,
	emprole VARCHAR(1) NOT NULL,
	empdivision VARCHAR(150) NOT NULL,
	empstatus VARCHAR(1) NOT NULL,
	primary key (empid)
)
;
CREATE TABLE empmanager
(
	empid INTEGER NOT NULL,
	division VARCHAR(150),
	foreign key (empid) references employee(empid)
)
;
CREATE TABLE absent
(
	empid INTEGER NOT NULL,
	absid INTEGER NOT NULL,
	absdate DATETIME NOT NULL,
	abstype VARCHAR(1) NOT NULL,
	absnotes LONGTEXT,
	absdeleted BIT(1) NOT NULL,
	primary key (absid),
	foreign key (empid) references employee(empid)
)
;
CREATE TABLE absentlog
(
	empid INTEGER NOT NULL,
	absid INTEGER NOT NULL,
	logdate DATETIME NOT NULL,
	logversionid INTEGER DEFAULT 1 NOT NULL,
	lognotes LONGTEXT,
	foreign key (empid) references employee(empid),
	foreign key (absid) references absent(absid)
)
;
