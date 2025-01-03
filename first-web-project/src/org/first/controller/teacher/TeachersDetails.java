package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Teachers;
import org.first.service.TeachersService;

import java.io.IOException;

public class TeachersDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         TeachersService teachersService = new TeachersService();
         String  id = req.getParameter("id");
         int teacherid = Integer.parseInt(id);
        Teachers teachers = null;
        try {
            teachers = teachersService.findById(teacherid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("teachersDetails" , teachers);
        String destination = "WEB-INF/jsps/teachers/teachers-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);
    }

}
