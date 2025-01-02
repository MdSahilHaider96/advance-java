package org.first.controller.store;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Store;
import org.first.service.StoreService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class StoreDetails extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService storeService = new StoreService();
        Store store;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String id = req.getParameter("id");
        int getId = Integer.parseInt(id);
        System.out.println(getId);
        try {
            store = storeService.findById(getId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("storeDetails",store);
        String destination = "/WEB-INF/jsps/store/store-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);

        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
