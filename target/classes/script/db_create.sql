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
  employee_name VARCHAR(20),
  lastname VARCHAR(20),
  third_name VARCHAR(20),
  experience INT,
  sex enum('WOMAN','MAN'),
  DOB Date,
  address VARCHAR(50),
  telephone long,
  email VARCHAR(30) unique,
  department_code INT NOT NULL REFERENCES department(department_code),
  job_code INT NOT NULL REFERENCES post(job_code)
  ON DELETE CASCADE
);