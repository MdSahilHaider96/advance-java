package org.first.controller.car;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Car;
import org.first.service.CarService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class CarDetails extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarService carService = new CarService();
        Car car = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String id = req.getParameter("id");
        int getId = Integer.parseInt(id);
        try {
            car = carService.findById(getId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("carDetails" , car);
        String destination = "/WEB-INF/jsps/car/car-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);

        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
