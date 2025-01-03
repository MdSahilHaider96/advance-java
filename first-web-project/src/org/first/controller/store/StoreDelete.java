package org.first.controller.store;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.StoreService;
import java.io.IOException;
import java.sql.Connection;

public class StoreDelete extends HttpServlet {
    private static Connection connection;
    StoreService storeService = new StoreService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try{
            storeService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/storeList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
