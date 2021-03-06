package db.dao.util;

public class DatabaseRequests {
    public static final String SELECT_ALL_POST = "SELECT p.job_code, p.post_name, p.salary FROM post as p";
    public static final String SELECT_POST_BY_CODE = "SELECT job_code,job_code,post_name FROM post where job_code=?";
    public static final String SELECT_ALL_DEPARTMENTS = "SELECT d.id, d.department_code, d.department_name FROM department AS d";
    public static final String SELECT_ALL_EMPLOYEES = "SELECT e.id, e.employee_name,e.lastname,e.third_name, e.experience,e.sex,e.DOB,e.address,e.telephone,\n" +
            "e.email,d.department_name,p.post_name\n" +
            " FROM employees AS e INNER JOIN department AS d ON e.department_code = d.department_code INNER JOIN post\n" +
            " AS p ON e.job_code = p.job_code";
    public static final String SELECT_EMPLOYEE_BY_DEPARTMENT = "SELECT e.id, e.employee_name,e.lastname,e.third_name, e.experience,e.sex,e.DOB,e.address,e.telephone, e.email,d.department_name,p.post_name\n" +
            "            FROM employees AS e INNER JOIN department AS d ON d.department_code = e.department_code INNER JOIN post " +
            "AS p ON e.job_code = p.job_code WHERE e.department_code=?";
    public static final String INSERT_DEPARTMENT = "INSERT into department VALUES (DEFAULT,?,?)";
    public static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE id=?";
    public static final String UPDATE_DEPARTMENT = "UPDATE department SET department_code =?, department_name =? WHERE id=?";
    public static final String SELECT_DEPARTMENT_BY_CODE = "SELECT id,department_code,department_name FROM department where department_code =?";
    public static final String GET_DEPARTMENT_BY_ID = "SELECT id, department_code, department_name FROM department WHERE id=?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id=?";
    public static final String INSERT_EMPLOYEE = "INSERT into employees VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employees SET employee_name = ?, lastname =?, experience =?, address=?, telephone=?, email=? WHERE id=?";
    public static final String SELECT_EMPLOYEE_BY_ID  = "SELECT employee_name,lastname,third_name,experience,sex,DOB,address,telephone,email,department_code,job_code FROM\n" +
            "employees WHERE id =?";
}
