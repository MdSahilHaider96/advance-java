package org.first.web.studentManagement.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Store;
import org.first.service.StoreService;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.Model.Student;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentUpdate extends HttpServlet {
    private static Connection connection;

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       StudentService studentService = new StudentService();
       Student student = null;
       System.out.println("StudentUpdate.GET");
       String idString = req.getParameter("id");
       int id = Integer.parseInt(idString);
       try {
           student =   studentService.findById(id);
           req.setAttribute("student" , student);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       String destination = "/WEB-INF/jsps/student-management/student-update.jsp";
       RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
       requestDispatcher.forward(req, resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("STUDENT UPDATE POST");
        StudentService studentService = new StudentService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//      id, firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
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
        System.out.println(idString);
        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(surName);
        System.out.println(email);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(rollNo);
        System.out.println(standard);
        System.out.println(fatherName);
        System.out.println(schoolName);
        try {
            studentService.updateById(id , firstName ,middleName ,surName , email , age , gender , rollNo , standard , fatherName , schoolName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/studentList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);

    }
}
