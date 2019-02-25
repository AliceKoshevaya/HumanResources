package controller;

import db.entity.Sex;
import org.apache.commons.lang3.StringUtils;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import util.EmployeeValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        String sDob = request.getParameter("EmpDob");
        String address = request.getParameter("EmpAdd");
        String tel = request.getParameter("EmpTel");
        String ssex = request.getParameter("EmpSex");
        Sex sex = Sex.valueOf(ssex);
        String email = request.getParameter("EmpEmail");
        String depCod = request.getParameter("code");
        int depCode = Integer.parseInt(depCod);
        String job = request.getParameter("jobCode");
        int jobCode = Integer.parseInt(job);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            if(sDob != null) {
                date = simpleDateFormat.parse(sDob);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String errorMessage = EmployeeValidator.validate(name,lastName,thirdName,sExp,address,tel,email,sqlDate);
        if (StringUtils.isNotBlank(errorMessage)) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("eName", name);
            request.setAttribute("eLastName", lastName);
            request.setAttribute("eThirdName", thirdName);
            request.setAttribute("eExp", sExp);
            request.setAttribute("eAddress", address);
            request.setAttribute("eTelephone", tel);
            request.setAttribute("eEmail", email);
            request.getRequestDispatcher("/employeesList?Id=" + depCod).forward(request, response);
        }else {
            int exp = Integer.parseInt(sExp);
            Long telephone = Long.parseLong(tel);
            employeeService.addEmployee(name, lastName, thirdName, exp, sex, sqlDate, address, telephone, email, depCode, jobCode);
            response.sendRedirect("/employeesList?Id=" + depCod);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
