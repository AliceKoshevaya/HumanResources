package servlets;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServlet;

public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService = new EmployeeServiceImpl();
}
