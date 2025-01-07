package org.first.controller.teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
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
            boolean isfNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
            if (!isfNamevalid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/teacher/teacher-create.jsp");
                return;
            }
        String middleName = req.getParameter("middleName");
            boolean isMNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, middleName);
            if (!isMNamevalid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/teacher/teacher-create.jsp");
                return;
            }
        String surName = req.getParameter("surName");
            boolean isSNamevalid = JavaUtil.validateField(Constants.NAME_REGEX, surName);
            if (!isSNamevalid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/teacher/teacher-create.jsp");
                return;
            }
        String emailId = req.getParameter("emailId");
            boolean isEmailValid = JavaUtil.validateField(Constants.NUMBER_REGEX, emailId);
            if (!isEmailValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/teacher/teacher-create.jsp");
                return;
            }
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
