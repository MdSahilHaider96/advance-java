package org.first.controller.employees;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Employees;
import org.first.service.EmployeesService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeesUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeesService employeesService = new EmployeesService();
        Employees employees = null;
        System.out.println("EmployeesUpdate.GET");
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            employees =   employeesService.findById(id);
            req.setAttribute("employees" , employees);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/employees/emoloyees-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EMPLOYEES UPDATE POST");
        EmployeesService employeesService = new EmployeesService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //    // String name , String state , int pinCode
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contactNo = req.getParameter("contactNo");

        try {
            employeesService.updateById(id , firstName , lastName , userName , password , address , contactNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/employeesList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}

