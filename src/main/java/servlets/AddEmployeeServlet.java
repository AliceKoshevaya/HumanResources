package servlets;

import db.entity.Sex;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        Date docDate = null;
        try {
            docDate= format.parse(sDob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address = request.getParameter("EmpAdd");
        String tel = request.getParameter("EmpTel");
        String ssex = request.getParameter("EmpSex");
        Sex sex = Sex.valueOf(ssex);
        String email = request.getParameter("EmpEmail");
        String depCod = request.getParameter("code");
        int depCode = Integer.parseInt(depCod);
        String job = request.getParameter("jobCode");
        int jobCode = Integer.parseInt(job);
        employeeService.addEmployee(name,lastName,thirdName,exp,sex,docDate,address,tel,email,depCode,jobCode);
        response.sendRedirect("/");


    }
}
