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
import java.sql.PreparedStatement;

public class CarUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarService carService = new CarService();
        Car car = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            car =   carService.findById(id);
            req.setAttribute("car" , car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/car/car-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarService carService = new CarService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//    //car ( id, model, company, engine, color, type )
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String model = req.getParameter("model");
        String company = req.getParameter("company");
        String engine = req.getParameter("engine");
        String color = req.getParameter("color");
        String type = req.getParameter("type");
        try {
            carService.updateById(id , model , company , engine , color , type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/carList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}

