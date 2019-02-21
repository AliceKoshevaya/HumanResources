package servlets;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {"/editEmployee"})
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService = new EmployeeServiceImpl();
}
