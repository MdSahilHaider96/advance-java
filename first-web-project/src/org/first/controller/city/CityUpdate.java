package org.first.controller.city;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.model.City;
import org.first.service.CityService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CityUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityService cityService = new CityService();
        City city = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            city =   cityService.findById(id);
            req.setAttribute("city" , city);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/city/city-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityService cityService = new CityService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //    // String name , String state , int pinCode
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = req.getParameter("name");
        boolean isFieldValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
        if (!isFieldValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/city/city-update.jsp");
            return;
        }
        String state = req.getParameter("state");
        int pinCode = Integer.parseInt(req.getParameter("pinCode"));
        boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, String.valueOf(pinCode));
        if (!isNumberValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/city/city-update.jsp");
            return;
        }
        try {
            cityService.updateById(id , name , state , pinCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/cityList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}

