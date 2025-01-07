package org.first.controller.user2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.TeachersService;
import org.first.service.User2Service;

import java.io.IOException;

public class User2Delete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User2Service user2Service = new User2Service();
        String getId = req.getParameter("id");
        int id = Integer.parseInt(getId);
        try{
            user2Service.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/user2List";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
