package service;

import db.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    Long addDepartment(int code, String name);

    void deleteDepartment(Long id);

    void updateDepartment(int code, String name, Long id);

    Department getDepartmentById(Long id);

    Department getDepartmentByCode(int code);
}
