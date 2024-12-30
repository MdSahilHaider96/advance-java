package org.first.web.studentManagement.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.Model.Student;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class StudentController extends HttpServlet {
    // String  firstName, String middleName, String surName, String email, int age, String gender, int rollNo, int standard , String fatherName, String schoolName)
    private static Connection connection;
    Statement st;
    PreparedStatement preparedStatement;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentController.doGet");
        StudentService studentService = new StudentService();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?","root","root");
            st = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            List<Student> studentList = studentService.findAll();
            req.setAttribute("studentList" , studentList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/student-management/student-list.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post");
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
        System.out.println("DoPost");
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

        try{
            List<Student> studentList = studentService.findAll();
            req.setAttribute("studentList" , studentList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/student-management/student-list.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);

        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Create

    }
}

