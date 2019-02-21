package service.impl;

import db.dao.DepartmentDao;
import db.dao.impl.DepartmentDaoImpl;
import db.entity.Department;
import service.DepartmentService;
import java.util.*;


public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();

    public List<Department> getAllDepartment(){
        return departmentDao.findAllDepartment();
    }

    @Override
    public void addDepartment(int code, String name) {
        Department department = new Department();
        department.setDepartmentCode(code);
        department.setDepartmentName(name);
        departmentDao.createDepartment(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentDao.deleteDepartment(id);
    }

    public void updateDepartment(int code, String name, Long id){
        departmentDao.updateDepartment(code,name,id);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentDao.getDepartmentById(id);
    }

    public static void main(String[] args) {
        DepartmentService ds = new DepartmentServiceImpl();
        System.out.println(ds.getAllDepartment());
    }
}
