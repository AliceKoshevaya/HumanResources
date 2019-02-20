package service;

import db.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    void addDepartment(int code, String name);

    void deleteDepartment(Long id);
}
