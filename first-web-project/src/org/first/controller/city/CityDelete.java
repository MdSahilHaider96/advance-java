package org.first.controller.city;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.CityService;
import java.io.IOException;
import java.sql.Connection;

public class CityDelete extends HttpServlet {
    private static Connection connection;
    CityService cityService = new CityService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try{
            cityService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/cityList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);

    }
}
