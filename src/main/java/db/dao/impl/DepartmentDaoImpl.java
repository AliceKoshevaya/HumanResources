package db.dao.impl;

import db.dao.DepartmentDao;
import db.dao.util.ConnectionManager;
import db.dao.util.DatabaseRequests;
import db.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static volatile DepartmentDaoImpl instance;
    private static Connection connection = ConnectionManager.getConnection();

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

    public static void main(String[] args) {
        DepartmentDaoImpl departmentDao = DepartmentDaoImpl.getInstance();
        Connection connection = ConnectionManager.getConnection();
        System.out.println(departmentDao.findAllDepartment());
        departmentDao.deleteDepartment( 6l);
        System.out.println(departmentDao.findAllDepartment());
        Department d = new Department();
        d.setDepartmentName("rrr");
        d.setDepartmentCode(13);
        departmentDao.createDepartment(d);
        System.out.println(departmentDao.findAllDepartment());
        departmentDao.updateDepartment(8, "update", 7l);
        System.out.println(departmentDao.findAllDepartment());
        ConnectionManager.closeConnection(connection);
    }

    public List<Department> findAllDepartment() {
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
            e.printStackTrace();
        }
        return departmentList;
    }

    public void deleteDepartment(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.DELETE_DEPARTMENT)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Long createDepartment(Department department) {
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
                ex.getMessage();
            }
        }
        return id;
    }

    public void updateDepartment(int code, String name, Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.UPDATE_DEPARTMENT)) {
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
}
