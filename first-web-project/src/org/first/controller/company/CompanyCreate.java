package org.first.controller.company;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.service.CompanyService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class CompanyCreate extends HttpServlet {
    private static Connection connection;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        //id , name , location , totalEmployees , email ,  contactNo
        String destination ="/WEB-INF/jsps/company/company-create.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyService companyService = new CompanyService();
        //        //id , name , location , totalEmployees , email ,  contactNo

        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String name = req.getParameter("name");
            boolean isNameValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
            if (!isNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-create.jsp");
                return;
            }
            String location = req.getParameter("location");
            String totalEmployees = req.getParameter("totalEmployees");
            String email = req.getParameter("email");
            boolean isEmailValid = JavaUtil.validateField(Constants.EMAIL_REGEX, email);
            if (!isEmailValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-create.jsp");
                return;
            }
            String contactNo = req.getParameter("contactNo");
            boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, contactNo);
            if (!isNumberValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-create.jsp");
                return;
            }
            companyService.create(name, location, totalEmployees , email , contactNo );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/first-web-project/companyList");
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}