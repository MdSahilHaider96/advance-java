package org.first.controller.user2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.model.User2;
import org.first.service.User2Service;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class User2Update extends HttpServlet {
    private static Connection connection;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User2Service user2Service = new User2Service();
        User2 user2 = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            user2 =   user2Service.findById(id);
            req.setAttribute("user2" , user2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/user2/user2-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User2Service user2Service = new User2Service();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //user ( id , name , email  , dob)
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = req.getParameter("name");
        boolean isFieldValid = JavaUtil.validateField(Constants.NAME_REGEX, name);
        if (!isFieldValid){
            JavaUtil.setJspPage(req, resp,  Constants.USER_2_CREATE);
            return;
        }
        String email = req.getParameter("email");
        JavaUtil.validateField(Constants.EMAIL_REGEX, email);
        String dobString = req.getParameter("dob");
        Date dob = Date.valueOf(dobString);
        System.out.println("DOB" + dob );
       try {
           user2Service.updateById(id,name,email,dob);
       } catch (Exception e) {
           e.printStackTrace();
       }
        String destination = "/first-web-project/user2List";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}
