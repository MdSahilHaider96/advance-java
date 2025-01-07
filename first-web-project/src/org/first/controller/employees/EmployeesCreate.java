package org.first.controller.employees;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.service.EmployeesService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class EmployeesCreate extends HttpServlet {
    private static Connection connection;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination ="/WEB-INF/jsps/employees/employees-create.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeesService employeesService = new EmployeesService();
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String firstName = req.getParameter("firstName");
            boolean isfNameValid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
            if (!isfNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/employees/employees-create.jsp");
                return;
            }
            String lastName = req.getParameter("lastName");
            boolean isLNameValid = JavaUtil.validateField(Constants.NAME_REGEX, lastName);
            if (!isLNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/employees/employees-create.jsp");
                return;
            }
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String address = req.getParameter("address");
            String contactNo = req.getParameter("contactNo");
            boolean isNumberValid = JavaUtil.validateField(Constants.NAME_REGEX, contactNo);
            if (!isNumberValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/employees/employees-create.jsp");
                return;
            }
            employeesService.create(firstName , lastName , userName , password , address , contactNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/first-web-project/employeesList");
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}