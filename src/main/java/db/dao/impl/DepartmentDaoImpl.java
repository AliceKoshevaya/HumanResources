package db.dao.impl;

import db.dao.DepartmentDao;
import db.dao.util.ConnectionManager;
import db.dao.util.DatabaseRequests;
import db.entity.Department;
import db.entity.Employee;
import db.exception.QueryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static volatile DepartmentDaoImpl instance;
    private static Connection connection = ConnectionManager.getConnection();

    private static final String ERROR_MESSAGE_UPDATE_DEPARTMENT = "Can't update department (id = %d)";
    private static final String ERROR_MESSAGE_SELECT_ALL_DEPARTMENT = "Can't select departments";
    private static final String ERROR_MESSAGE_INSERT_DEPARTMENT = "Unable to perform operation insert department";
    private static final String ERROR_MESSAGE_SELECT_DEPARTMENT = "Can't select department(id = %d)";
    private static final String ERROR_MESSAGE_DELETE_DEPARTMENT = "Can't delete department(id = %d)";


    private DepartmentDaoImpl() {

    }

    public static DepartmentDaoImpl getInstance() {
        DepartmentDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (DepartmentDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DepartmentDaoImpl();
                }
            }
        }
        return localInstance;
    }

    public List<Department> findAllDepartment() throws QueryException {
        List<Department> departmentList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_ALL_DEPARTMENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = Department.builder()
                        .id(resultSet.getLong(1))
                        .departmentCode(resultSet.getInt(2))
                        .departmentName(resultSet.getNString(3))
                        .build();
                departmentList.add(department);
            }
        } catch (SQLException e) {
            throw new QueryException(ERROR_MESSAGE_SELECT_ALL_DEPARTMENT,e);
        }
        return departmentList;
    }

    public void deleteDepartment(Long id) throws QueryException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.DELETE_DEPARTMENT)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new QueryException(String.format(ERROR_MESSAGE_DELETE_DEPARTMENT, id), ex);
        }
    }

    public Long createDepartment(Department department) throws QueryException{
        Long id = null;

        ResultSet generatedKeys = null;

        if (department != null) {
            try (PreparedStatement ps = connection.prepareStatement(DatabaseRequests.INSERT_DEPARTMENT, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, department.getDepartmentCode());
                ps.setString(2, department.getDepartmentName());
                ps.executeUpdate();

                generatedKeys = ps.getGeneratedKeys();

                if (null != generatedKeys && generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }

            } catch (SQLException ex) {
                throw new QueryException(String.format(ERROR_MESSAGE_INSERT_DEPARTMENT, id), ex);
            }
        }
        return id;
    }

    public void updateDepartment(int code, String name, Long id) throws QueryException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.UPDATE_DEPARTMENT)) {
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new QueryException(String.format(ERROR_MESSAGE_UPDATE_DEPARTMENT, id), ex);
        }
    }

    public Department getDepartmentById(Long id) throws QueryException {
        Department d = new Department();

        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.GET_DEPARTMENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                d.setId(id);
                d.setDepartmentCode(resultSet.getInt(2));
                d.setDepartmentName(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            throw new QueryException(String.format(ERROR_MESSAGE_SELECT_DEPARTMENT, id), ex);
        }
        return d;
    }

    @Override
    public Department getDepartmentByCode(int code) throws QueryException {
        Department d = null;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DatabaseRequests.SELECT_DEPARTMENT_BY_CODE)) {
            preparedStatement.setInt(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                d = new Department();
                d.setId(resultSet.getLong(1));
                d.setDepartmentCode(code);
                d.setDepartmentName(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return d;
    }
}
