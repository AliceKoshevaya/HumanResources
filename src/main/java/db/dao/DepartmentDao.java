package db.dao;

import db.entity.Department;

import java.sql.Connection;
import java.util.List;

public interface DepartmentDao {

    List<Department> findAllDepartment();

    Long createDepartment(Department department);

    void updateDepartment(int code, String name, Long id);

    public void deleteDepartment(Long id);

    Department getDepartmentById(Long id);

    Department getDepartmentByCode(int code);
}
