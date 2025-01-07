package org.first.controller.city;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.service.CityService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class CityCreate extends HttpServlet {
    private static Connection connection;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination ="/WEB-INF/jsps/city/city-create.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityService  cityService = new CityService();
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String name = req.getParameter("name");
            boolean isFieldValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
            if (!isFieldValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/city/city-create.jsp");
                return;
            }
            String state = req.getParameter("state");
            int pinCode = Integer.parseInt(req.getParameter("pinCode"));
            boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, String.valueOf(pinCode));
            if (!isNumberValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/city/city-create.jsp");
                return;
            }
            cityService.create(name, state, pinCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/first-web-project/cityList");
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}