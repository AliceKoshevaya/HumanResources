package servlets;

import db.entity.Department;
import db.entity.Employee;
import db.entity.Sex;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = {"/editEmployee"})
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String sexp = request.getParameter("exp");
        int exp = Integer.parseInt(sexp);
        String address = request.getParameter("add");
        String tel = request.getParameter("tel");
        Long telephone = Long.valueOf(tel);
        String email = request.getParameter("email");
        String sid = request.getParameter("id");
        Long id = Long.valueOf(sid);
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
