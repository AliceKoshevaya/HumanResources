package servlets;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/deleteDepartment"})
public class DeleteDepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringId = request.getParameter("Id");
        Long id = Long.valueOf(stringId);
        departmentService.deleteDepartment(id);
        response.sendRedirect("/");
    }
}
