DROP DATABASE IF EXISTS solocate;
CREATE DATABASE IF NOT EXISTS solocate;

USE solocate;

DROP TABLE IF EXISTS tprofile;
CREATE TABLE tprofile(
	name VARCHAR(20) NOT NULL PRIMARY KEY, 
	password VARCHAR(20),
	contact INT
	);
LOAD DATA LOCAL INFILE 'soProfile.dat' INTO TABLE tprofile LINES TERMINATED BY '\r\n';

CREATE TABLE tcontact(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	firstName VARCHAR(20),
	middleName VARCHAR(20),
	lastName VARCHAR(20),
	gender VARCHAR(20),
	groupLabel VARCHAR(20),
	picture VARCHAR(20),
	profile VARCHAR(20)
	);
LOAD DATA LOCAL INFILE 'soContact.dat' INTO TABLE tcontact LINES TERMINATED BY '\r\n';

CREATE TABLE taddress(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	street VARCHAR(30),
	zipCode VARCHAR(20),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	contact INT
	);
LOAD DATA LOCAL INFILE 'soAddress.dat' INTO TABLE taddress LINES TERMINATED BY '\r\n';

CREATE TABLE tnum(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	num VARCHAR(20),
	description VARCHAR(30),
	contact INT
	);
LOAD DATA LOCAL INFILE 'soNum.dat' INTO TABLE tnum LINES TERMINATED BY '\r\n';

CREATE TABLE temail(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(20),
	description VARCHAR(30),
	contact INT
	);
LOAD DATA LOCAL INFILE 'soEmail.dat' INTO TABLE temail LINES TERMINATED BY '\r\n';

CREATE TABLE ttarget(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	target VARCHAR(20),
	description VARCHAR(60),
	profile INT
	);
LOAD DATA LOCAL INFILE 'soTarget.dat' INTO TABLE ttarget LINES TERMINATED BY '\r\n';

SHOW TABLES;