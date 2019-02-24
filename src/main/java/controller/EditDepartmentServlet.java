package controller;

import db.entity.Department;
import org.apache.commons.lang3.StringUtils;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
import util.DepartmentValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = {"/editDepartment"})
public class EditDepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentService departmentService = new DepartmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(Objects.isNull(id)){
            response.sendRedirect("/");
        } else {
            Long idDep = Long.valueOf(id);
            String depName = request.getParameter("depName");
            String depCode = request.getParameter("depCode");
            String errorMessage = DepartmentValidator.validate(id, depCode, depName);
            if (StringUtils.isNotBlank(errorMessage)) {
                request.setAttribute("errorMessage", errorMessage);
                doGet(request, response);
            } else {
                int code = Integer.parseInt(depCode);
                departmentService.updateDepartment(code, depName, idDep);
                response.sendRedirect("/");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(Objects.isNull(id)){
            response.sendRedirect("/");
        }else {
            Long idDep = Long.valueOf(id);
            Department d = departmentService.getDepartmentById(idDep);
            request.setAttribute("dep", d);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/editDepartment.jsp");

            dispatcher.forward(request, response);
        }

    }
}
