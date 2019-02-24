package service.impl;

import db.dao.DepartmentDao;
import db.dao.EmployeeDao;
import db.dao.PostDao;
import db.dao.impl.DepartmentDaoImpl;
import db.dao.impl.EmployeeDaoImpl;
import db.dao.impl.PostDaoImpl;
import db.entity.Employee;
import db.entity.Sex;
import service.EmployeeService;
import java.sql.*;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();
    private PostDao postDao = PostDaoImpl.getInstance();
    private DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();

    public List<Employee> employeesByDepartment(int id){
        return employeeDao.findEmployeesByDepartment(id);
    }

    public void deleteEmployee(Long id){
        employeeDao.deleteEmployee(id);
    }

    public void addEmployee(String name, String lastName, String thirdName, int experience,
                            Sex sex, Date date, String address, Long phone, String email, int depCode, int jobCode){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setThirdName(thirdName);
        employee.setExperience(experience);
        employee.setSex(sex);
        employee.setTelephone(phone);
        employee.setDateOfBirthday(date);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setDepartment(departmentDao.getDepartmentByCode(depCode));
        employee.setPost(postDao.getPostByCode(jobCode));

        employeeDao.createEmployee(employee);
    }

    public void updateEmployee(String name,String lastName, int exp, String add, Long tel, String email,Long id){
        employeeDao.updateEmployee(name,lastName,exp,add,tel,email,id);

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }
}
