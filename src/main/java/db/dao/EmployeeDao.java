package db.dao;

import db.entity.Employee;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDao {
    /**
     * Select all employees
     *
     * @return {@link List<Employee>}
     */
    List<Employee> findAllEmployees();

    /**
     * Select employee by department
     *
     * @param code
     * @return {@link List<Employee>}
     */
    List<Employee> findEmployeesByDepartment(int code);

    /**
     * Delete employee
     *
     * @param id
     */
    void deleteEmployee(Long id);

    /**
     * Update employee
     *
     * @param name
     * @param lastName
     * @param exp
     * @param add
     * @param tel
     * @param email
     * @param id
     */
    void updateEmployee(String name, String lastName, int exp, String add, Long tel, String email,Long id);

    /**
     * Create new employee
     *
     * @param employee
     * @return id
     */
    Long createEmployee(Employee employee);

    /**
     * Select employee by id
     *
     * @param id
     * @return {@link Employee}
     */
    Employee getEmployeeById(Long id);
}
