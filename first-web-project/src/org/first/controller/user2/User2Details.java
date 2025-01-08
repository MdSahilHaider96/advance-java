package org.first.controller.user2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Teachers;
import org.first.model.User2;
import org.first.service.TeachersService;
import org.first.service.User2Service;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class User2Details extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         User2Service user2Service = new User2Service();
         String  id = req.getParameter("id");
         int user2id = Integer.parseInt(id);
         User2 user2 = null;
        try {
            user2 = user2Service.findById(user2id);
        } catch (Exception e) {
           e.printStackTrace();
        }
        req.setAttribute("user2Details", user2);
        String destination = "/WEB-INF/jsps/user2/user2-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);
    }

}
