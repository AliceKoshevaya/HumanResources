package db.dao;

import db.entity.Department;

import java.sql.Connection;
import java.util.List;

public interface DepartmentDao {

    /**
     * Select all department
     *
     * @return {@link List<Department>}
     */
    List<Department> findAllDepartment();

    /**
     * Create new department
     *
     * @param department
     * @return id
     */
    Long createDepartment(Department department);

    /**
     * Update department
     *
     * @param code
     * @param name
     * @param id
     */
    void updateDepartment(int code, String name, Long id);

    /**
     * Delete department
     *
     * @param id
     */
    public void deleteDepartment(Long id);

    /**
     * Select department by id
     *
     * @param id
     * @return {@Link Department}
     */
    Department getDepartmentById(Long id);

    /**
     * Select department by department id
     *
     * @param code
     * @return {@Link Department}
     */
    Department getDepartmentByCode(int code);
}
