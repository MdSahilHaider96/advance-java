package org.first.controller.company;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.CompanyService;

import java.io.IOException;
import java.sql.Connection;

public class CompanyDelete extends HttpServlet {
    private static Connection connection;
    CompanyService companyService = new CompanyService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("companyDelete.GET");
        try{
            companyService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/companyList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);

    }
}
