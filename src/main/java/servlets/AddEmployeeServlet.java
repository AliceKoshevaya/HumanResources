package servlets;

import db.entity.Sex;
import service.DepartmentService;
import service.EmployeeService;
import service.PostService;
import service.impl.DepartmentServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

@WebServlet(urlPatterns = {"/addEmployee"})
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService = new EmployeeServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("EmpName");
        String lastName = request.getParameter("EmpLname");
        String thirdName = request.getParameter("EmpTname");
        String sExp = request.getParameter("EmpExp");
        int exp = Integer.parseInt(sExp);
        String sDob = request.getParameter("EmpDob");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(sDob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String address = request.getParameter("EmpAdd");
        String tel = request.getParameter("EmpTel");
        Long telephone = Long.parseLong(tel);
        String ssex = request.getParameter("EmpSex");
        Sex sex = Sex.valueOf(ssex);
        String email = request.getParameter("EmpEmail");
        String depCod = request.getParameter("code");
        int depCode = Integer.parseInt(depCod);
        String job = request.getParameter("jobCode");
        int jobCode = Integer.parseInt(job);
        employeeService.addEmployee(name,lastName,thirdName,exp,sex,sqlDate,address,telephone,email,depCode,jobCode);
        response.sendRedirect("/");


    }
}
