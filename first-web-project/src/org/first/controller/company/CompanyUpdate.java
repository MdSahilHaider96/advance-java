package org.first.controller.company;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.model.Company;
import org.first.service.CompanyService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompanyUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyService companyService = new CompanyService();
        Company company = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            company =   companyService.findById(id);
            req.setAttribute("company" , company);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/company/company-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyService companyService = new CompanyService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //id , name , location , totalEmployees , email ,  contactNo
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = req.getParameter("name");
        boolean isNameValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
        if (!isNameValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-update.jsp");
            return;
        }
        String location = req.getParameter("location");
        String totalEmployees = req.getParameter("totalEmployees");
        String email = req.getParameter("email");
        boolean isEmailValid = JavaUtil.validateField(Constants.EMAIL_REGEX, email);
        if (!isEmailValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-update.jsp");
            return;
        }
        String contactNo = req.getParameter("contactNo");
        boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, contactNo);
        if (!isNumberValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/company/company-update.jsp");
            return;
        }
        try {
            companyService.updateById(id , name , location , totalEmployees , email , contactNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/companyList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}

