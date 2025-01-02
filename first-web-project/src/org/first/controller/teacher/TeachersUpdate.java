package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Teachers;
import org.first.service.TeachersService;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.Model.Student;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeachersUpdate extends HttpServlet {
    private static Connection connection;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeachersService teachersService = new TeachersService();
        Teachers teachers = null;
        System.out.println("TeachersUpdate.GET");
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            teachers =   teachersService.findById(id);
            req.setAttribute("teachers" , teachers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/teachers/teachers-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TEACHERS UPDATE POST");
        TeachersService teachersService = new TeachersService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
// firstName , middleName , surName ,  emailId , age , gender , specialisation , schoolName
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String surName = req.getParameter("surName");
        String emailId  = req.getParameter("emailId");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String specialisation = req.getParameter("specialisation");
        String schoolName = req.getParameter("schoolName");
        System.out.println(idString);
        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(surName);
        System.out.println(emailId );
        System.out.println(age);
        System.out.println(gender);
        System.out.println(specialisation);
        System.out.println(schoolName);
        try {
            teachersService.updateById(id , firstName , middleName , surName , emailId  , age , gender , specialisation , schoolName ) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/teachers-list";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
