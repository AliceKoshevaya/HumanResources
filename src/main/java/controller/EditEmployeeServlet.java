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

@WebServlet(urlPatterns = {"/editEmployee"})
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String sExp = request.getParameter("exp");
        int exp = Integer.parseInt(sExp);
        String address = request.getParameter("add");
        String sTelephone = request.getParameter("tel");
        Long telephone = Long.valueOf(sTelephone);
        String email = request.getParameter("email");
        String sId = request.getParameter("id");
        Long id = Long.valueOf(sId);
        employeeService.updateEmployee(name,lastName,exp,address,telephone,email,id);
        response.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringId = request.getParameter("Id");
        Long idEmp = Long.valueOf(stringId);
        Employee e = employeeService.getEmployeeById(idEmp);
        request.setAttribute("emp", e);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/editEmployee.jsp");

        dispatcher.forward(request, response);

    }
}
