package org.first.controller.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.model.Community;
import org.first.service.CommunityService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommunityUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommunityService communityService = new CommunityService();
        Community community = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            community =   communityService.findById(id);
            req.setAttribute("community" , community);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/community/community-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommunityService communityService = new CommunityService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //    // String name , String state , int pinCode
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String firstName = req.getParameter("firstName");
        boolean isfNameValid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
        if (!isfNameValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-update.jsp");
            return;
        }
        String lastName = req.getParameter("lastName");
        boolean islNameValid = JavaUtil.validateField(Constants.NAME_REGEX, lastName);
        if (!islNameValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-update.jsp");
            return;
        }
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");
        String contactNo = req.getParameter("contactNo");
        boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, firstName);
        if (!isNumberValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-update.jsp");
            return;
        }
        try {
            communityService.updateById(id , firstName , lastName , address , gender , contactNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/communityList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
    }
}

