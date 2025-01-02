package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Teachers;
import org.first.service.TeachersService;
import org.first.sql.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class TeachersList extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherList.doGet");
        TeachersService teachersService = new TeachersService();
        try{
            ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            List<Teachers> teachersList = teachersService.findAll();
            req.setAttribute("teachersList",teachersList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/teachers/teachers-list.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp );
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
        // Create
        TeachersService teachersService = new TeachersService();
        String firstName = req.getParameter("firstName");
        String midddleName = req.getParameter("midddleName");
        String surName = req.getParameter("surName");
        String emailId = req.getParameter("emailId");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String specialisation = req.getParameter("specialisation");
        String schoolName = req.getParameter("schoolName");
        System.out.println("DoPost");
        try {
            connection= ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            teachersService.create(firstName,  midddleName,  surName,  emailId,  age,  gender,  specialisation,  schoolName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            List<Teachers> teachersList = teachersService.findAll();
            teachersList.forEach(System.out::println);
            System.out.println(teachersList);
            req.setAttribute("teachersList" , teachersList);
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
