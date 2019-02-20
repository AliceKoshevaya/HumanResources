package service.impl;

import db.dao.EmployeeDao;
import db.dao.impl.EmployeeDaoImpl;
import db.entity.Employee;
import db.entity.Sex;
import service.EmployeeService;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    public List<Employee> allEmployee(int id){
        return employeeDao.findEmployeesByDepartment(id);
    }

    public void deleteEmployee(Long id){
        employeeDao.deleteEmployee(id);
    }

    public void addEmployee(String name, String lastName, String thirdName, int experience,
                            Sex sex, Date date, String address, String tel, String email, int depCode, int jobCode){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setThirdName(thirdName);
        employee.setExperience(experience);
        employee.setSex(sex);
        employee.setDateOfBirthday(date);
        employee.setAddress(address);
        employee.setEmail(email);
        //добавить поиск
        employeeDao.createEmployee(employee);
    }

    public void updateEmployee(String lastName, int exp, String add, Long tel, String email,Long id){
        employeeDao.updateEmployee(lastName,exp,add,tel,email,id);

    }
}
