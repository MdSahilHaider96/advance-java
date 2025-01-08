package org.first.controller.user2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.repository.User2Repo;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User2Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("User2.Create.GET");
        JavaUtil.setJspPage(req, resp,  Constants.USER_2_CREATE);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String name = req.getParameter("name");
        boolean isFieldValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
        if (!isFieldValid) {
            JavaUtil.setJspPage(req, resp, Constants.USER_2_CREATE);
            return;
        }
        String email = req.getParameter("email");
        JavaUtil.validateField(Constants.EMAIL_REGEX, email);
        String dobString = req.getParameter("dob");
        System.out.println("DOBSTRING " + dobString);
        java.sql.Date dob = null;

        try {
            dob = Date.valueOf(dobString);
            System.out.println(dob + " DOB");
            User2Repo.create(name, email, dob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("User2.Create.POST");
        resp.sendRedirect("/first-web-project/user2List");
    }
}
