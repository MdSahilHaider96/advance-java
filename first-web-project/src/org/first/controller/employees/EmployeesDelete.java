package org.first.controller.employees;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.CityService;
import org.first.service.EmployeesService;

import java.io.IOException;
import java.sql.Connection;

public class EmployeesDelete extends HttpServlet {
    private static Connection connection;
    EmployeesService employeesService = new EmployeesService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EmployeesDelete.POST");
        String id = req.getParameter("id");
        System.out.println("EmmployeesDelete.GET "+id);
        try{
            employeesService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/employeesList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
