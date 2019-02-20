package servlets;

import db.entity.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class DepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Department> allDepartment = departmentService.getAllDepartment();
        request.setAttribute("department", allDepartment);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/departments.jsp");
        dispatcher.forward(request, response);
    }


}
