package servlets;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
import util.DepartmentValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addDepartment"})
public class AddDepartmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String depName = request.getParameter("DepName");
        String depCode = request.getParameter("DepCode");
        int code = Integer.parseInt(depCode);
        String errorMessage = DepartmentValidator.validate(code, depName);
        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
//            request.getRequestDispatcher("/").forward(request, response);
        }else {
            departmentService.addDepartment(code, depName);
            response.sendRedirect("/");
        }


    }
}
