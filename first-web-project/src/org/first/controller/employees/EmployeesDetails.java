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

public class EmployeesDetails extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeesService employeesService = new EmployeesService();
        Employees employees = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String id = req.getParameter("id");
        int getId = Integer.parseInt(id);
        System.out.println(getId);
        try {
            employees = employeesService.findById(getId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("employeesDetails" , employees);
        String destination = "/WEB-INF/jsps/employees/employees-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);

        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
