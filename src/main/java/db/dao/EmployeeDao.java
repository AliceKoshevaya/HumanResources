package db.dao;

import db.entity.Employee;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDao {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesByDepartment(int code);
    void deleteEmployee(Long id);
    void updateEmployee(String lastName, int exp, String add, Long tel, String email,Long id);
    Long createEmployee(Employee employee);
}
