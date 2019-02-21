package service;

import db.entity.Employee;
import db.entity.Sex;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public List<Employee> allEmployee(int id);

    public void deleteEmployee(Long id);

    public void addEmployee(String name, String lastName, String thirdName, int experience,
                            Sex sex, Date date,String address, String tel, String email, int depCode, int jobCode);

    public void updateEmployee(String name, String lastName, int exp, String add, Long tel, String email,Long id);

    Employee getEmployeeById(Long id);
}
