package db.dao.impl;

import db.dao.EmployeeDao;
import db.dao.util.ConnectionManager;
import db.dao.util.DatabaseRequests;
import db.entity.Department;
import db.entity.Employee;
import db.entity.Post;
import db.entity.Sex;
import db.exception.QueryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static volatile EmployeeDaoImpl instance;
    private static Connection connection = ConnectionManager.getConnection();

    private static final String ERROR_MESSAGE_UPDATE_EMPLOYEE = "Can't update employee (id = %d)";
    private static final String ERROR_MESSAGE_SELECT_EMPLOYEE_BY_DEPARTMENT = "Can't select employee by department";
    private static final String ERROR_MESSAGE_INSERT_EMPLOYEE = "Unable to perform operation insert employee";
    private static final String ERROR_MESSAGE_SELECT_EMPLOYEE = "Can't select employee(id = %d)";
    private static final String ERROR_MESSAGE_DELETE_EMPLOYEE = "Can't delete employee(id = %d)";
    private static final String ERROR_MESSAGE_SELECT_ALL_EMPLOYEE = "Can't select employees";

    private EmployeeDaoImpl() {

    }

    public static EmployeeDaoImpl getInstance() {
        EmployeeDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (EmployeeDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new EmployeeDaoImpl();
                }
            }
        }
        return localInstance;
    }

    public List<Employee> findAllEmployees()  throws QueryException {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_ALL_EMPLOYEES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                Post post = new Post();
                Department department = new Department();
                employee.setPost(post);
                employee.setDepartment(department);
                employee.setId(resultSet.getLong(1));
                employee.setName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setThirdName(resultSet.getString(4));
                employee.setExperience(resultSet.getInt(5));
                employee.setSex(Sex.valueOf(resultSet.getString(6).toUpperCase()));
                employee.setDateOfBirthday(resultSet.getDate(7));
                employee.setAddress(resultSet.getString(8));
                employee.setTelephone(resultSet.getLong(9));
                employee.setEmail(resultSet.getString(10));

                post.setPostName(resultSet.getString(11));

                department.setDepartmentName(resultSet.getString(12));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw  new QueryException(ERROR_MESSAGE_SELECT_ALL_EMPLOYEE,e);
        }
        return employeeList;
    }

    public List<Employee> findEmployeesByDepartment(int departmentCode)  throws QueryException{
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_EMPLOYEE_BY_DEPARTMENT)) {
            preparedStatement.setInt(1, departmentCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                Post post = new Post();
                Department department = new Department();
                employee.setPost(post);
                employee.setDepartment(department);
                employee.setId(resultSet.getLong(1));
                employee.setName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setThirdName(resultSet.getString(4));
                employee.setExperience(resultSet.getInt(5));
                employee.setSex(Sex.valueOf(resultSet.getString(6).toUpperCase()));
                employee.setDateOfBirthday(resultSet.getDate(7));
                employee.setAddress(resultSet.getString(8));
                employee.setTelephone(resultSet.getLong(9));
                employee.setEmail(resultSet.getString(10));

                post.setPostName(resultSet.getString(11));

                department.setDepartmentName(resultSet.getString(12));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new QueryException(ERROR_MESSAGE_SELECT_EMPLOYEE_BY_DEPARTMENT,e);
        }
        return employeeList;
    }

    public void deleteEmployee(Long id)  throws QueryException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.DELETE_EMPLOYEE)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new QueryException(ERROR_MESSAGE_DELETE_EMPLOYEE, ex);
        }
    }

    public void updateEmployee(String name,String lastName, int exp, String add, Long tel, String email,Long id)
            throws QueryException{
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, exp);
            preparedStatement.setString(4, add);
            preparedStatement.setLong(5, tel);
            preparedStatement.setString(6, email);
            preparedStatement.setLong(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new QueryException(ERROR_MESSAGE_UPDATE_EMPLOYEE, ex);
        }
    }

    public Long createEmployee(Employee employee)  throws QueryException{
        Long id = null;

        ResultSet generatedKeys = null;

        if (employee != null) {
            try (PreparedStatement ps = connection.prepareStatement(DatabaseRequests.INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getLastName());
                ps.setString(3, employee.getThirdName());
                ps.setInt(4, employee.getExperience());
                ps.setString(5, employee.getSex().toString());
                ps.setDate(6, (Date) employee.getDateOfBirthday());
                ps.setString(7, employee.getAddress());
                ps.setLong(8, employee.getTelephone());
                ps.setString(9, employee.getEmail());
                ps.setLong(10, employee.getDepartment().getDepartmentCode());
                ps.setLong(11, employee.getPost().getJobCode());
                ps.executeUpdate();

                generatedKeys = ps.getGeneratedKeys();

                if (null != generatedKeys && generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }

            } catch (SQLException ex) {
                throw new QueryException(ERROR_MESSAGE_INSERT_EMPLOYEE, ex);
            }
        }
        return id;
    }

    @Override
    public Employee getEmployeeById(Long id) throws QueryException {
        Employee e = new Employee();
        Department d = new Department();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                e.setDepartment(d);
                e.setName(resultSet.getString(1));
                e.setLastName(resultSet.getString(2));
                e.setThirdName(resultSet.getString(3));
                e.setExperience(resultSet.getInt(4));
                e.setSex(Sex.valueOf(resultSet.getString(5)));
                e.setDateOfBirthday(resultSet.getDate(6));
                e.setAddress(resultSet.getString(7));
                e.setTelephone(resultSet.getLong(8));
                e.setEmail(resultSet.getString(9));
                d.setDepartmentCode(resultSet.getInt(10));
                e.setId(id);
            }
        } catch (SQLException ex) {
            throw new QueryException(String.format(ERROR_MESSAGE_SELECT_EMPLOYEE, id), ex);
        }
        return e;
    }
}
