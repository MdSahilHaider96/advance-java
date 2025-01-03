package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.service.TeachersService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class TeacherCreate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/WEB-INF/jsps/teachers/create-teachers.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String firstName, String middleName, String surName, String emailId, int age, int gender, String specialisation, String schoolName
        // Create
        TeachersService teachersService = new TeachersService();
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String surName = req.getParameter("surName");
        String emailId = req.getParameter("emailId");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String specialisation = req.getParameter("specialisation");
        String schoolName = req.getParameter("schoolName");
        try {
            connection= ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
           teachersService.create(firstName,  middleName,  surName,  emailId,  age,  gender,  specialisation,  schoolName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/teachers-list";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
