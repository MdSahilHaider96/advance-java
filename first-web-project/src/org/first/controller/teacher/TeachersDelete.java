package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.TeachersService;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;

public class TeachersDelete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeachersService teachersService = new TeachersService();
        System.out.println("Teachers.Delete.GET");
        String getId = req.getParameter("id");
        int id = Integer.parseInt(getId);
        System.out.println("teachersDelete.GET "+id);
        try{
            teachersService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/teachers-list";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
