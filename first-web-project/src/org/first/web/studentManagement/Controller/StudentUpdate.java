package org.first.web.studentManagement.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
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
        boolean isfNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
        if (!isfNamevalid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/student-management/student-update.jsp");
            return;
        }
        String middleName = req.getParameter("middleName");
        boolean isMNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, middleName);
        if (!isMNamevalid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/student-management/student-update.jsp");
            return;
        }
        String surName = req.getParameter("surName");
        boolean isSNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, surName);
        if (!isSNamevalid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/student-management/student-update.jsp");
            return;
        }
        String email = req.getParameter("email");
        boolean isEmailValid = JavaUtil.validateField(Constants.EMAIL_REGEX, email);
        if (!isEmailValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/student-management/student-update.jsp");
            return;
        }
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        int rollNo = Integer.parseInt(req.getParameter("rollNo"));
        boolean isRollValid = JavaUtil.validateField(Constants.NUMBER_REGEX, String.valueOf(rollNo));
        if (!isRollValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/student-management/student-update.jsp");
            return;
        }
        int standard = Integer.parseInt(req.getParameter("standard"));
        String fatherName = req.getParameter("fatherName");
        String schoolName = req.getParameter("schoolName");
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
