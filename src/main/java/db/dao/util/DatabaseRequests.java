package db.dao.util;

public class DatabaseRequests {
    public static final String SELECT_ALL_POST = "SELECT p.id, p.job_code, p.post_name, p.salary FROM post as p";
    public static final String SELECT_ALL_DEPARTMENTS = "SELECT d.id, d.department_code, d.department_name FROM department AS d";
    public static final String SELECT_ALL_EMPLOYEES = "SELECT e.id, e.employee_name,e.lastname, e.experience,e.sex,e.DOB,e.address,e.telephone," +
            "e.email,d.department_name,p.post_name\n" +
            "FROM employees AS e LEFT JOIN department AS d ON e.department_code = d.department_code LEFT JOIN post\n" +
            "AS p ON e.job_code = p.job_code";
    public static final String SELECT_EMPLOYEE_BY_DEPARTMENT = "SELECT e.id, e.employee_name,e.lastname, e.experience,e.sex,e.DOB,e.address,e.email,d.department_name,p.post_name\n" +
            "FROM employees AS e LEFT JOIN department AS d ON d.department_code = e.department_code LEFT JOIN post\n" +
            "AS p ON e.job_code = p.job_code WHERE e.department_code=?";
    public static final String INSERT_DEPARTMENT = "INSERT into department VALUES (DEFAULT,?,?)";
    public static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE id=?";
    public static final String UPDATE_DEPARTMENT = "UPDATE department SET department_code =?, department_name =? WHERE id=?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE department_code=?";
    public static final String INSERT_EMPLOYEE = "INSERT into employees VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employees SET lastname =?, experience =?, address=?, telephone=?, email=? WHERE department_code=?";
}
