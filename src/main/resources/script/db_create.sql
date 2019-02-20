use human_resources;

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS post;

CREATE TABLE post (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
  job_code INT,
  post_name VARCHAR(30),
  salary DOUBLE
);

CREATE TABLE department (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
  department_code INT,
  department_name VARCHAR(30) unique
);

CREATE TABLE employees (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
  employeу_name VARCHAR(20),
  latname VARCHAR(20),
  third_name VARCHAR(20),
  experience INT,
  sex enum,
  DOB Date,
  address VARCHAR(50),
  telephone LONG,
  email VARCHAR(30) unique,
  department_code INT NOT NULL REFERENCES department(department_code),
  job_code INT NOT NULL REFERENCES post(job_code)
    ON DELETE CASCADE
);