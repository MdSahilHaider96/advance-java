package org.first.controller.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.CommunityService;

import java.io.IOException;
import java.sql.Connection;

public class CommunityDelete extends HttpServlet {
    private static Connection connection;
    CommunityService communityService = new CommunityService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try{
            communityService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/communityList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
