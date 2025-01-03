package org.first.controller.car;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.CarService;

import java.io.IOException;
import java.sql.Connection;

public class CarDelete extends HttpServlet {
    private static Connection connection;
    //    //car ( id, model, company, engine, color, type )
    CarService carService = new CarService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try{
            carService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/carList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
