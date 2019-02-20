package servlets;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/editDepartment"})
public class EditDepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentService departmentService = new DepartmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
