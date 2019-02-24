package controller;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteEmployee"})
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringId = request.getParameter("Id");
        Long id = Long.valueOf(stringId);
        String scode = request.getParameter("code");
        Long code = Long.valueOf(scode);
        employeeService.deleteEmployee(id);
        response.sendRedirect("/employeesList?Id=" + code);
    }
}
