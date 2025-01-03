package org.first.web.studentManagement.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.service.StudentService;
import java.io.IOException;
import java.sql.Connection;


public class CreateStudent extends HttpServlet {
    private static Connection connection;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/WEB-INF/jsps/student-management/create-student.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create
        StudentService studentService = new StudentService();
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String surName = req.getParameter("surName");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        int rollNo = Integer.parseInt(req.getParameter("rollNo"));
        int standard = Integer.parseInt(req.getParameter("standard"));
        String fatherName = req.getParameter("fatherName");
        String schoolName = req.getParameter("schoolName");
        try {
            connection= ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            studentService.create(firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/studentList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
