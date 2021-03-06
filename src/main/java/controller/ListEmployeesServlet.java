package controller;

import db.entity.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/employeesList"})
public class ListEmployeesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringId = request.getParameter("Id");
        int departmentId = Integer.parseInt(stringId);
        List<Employee> allEmployees = employeeService.employeesByDepartment(departmentId);
        request.setAttribute("employees", allEmployees);
        request.setAttribute("idJob", departmentId);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/employeesList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
