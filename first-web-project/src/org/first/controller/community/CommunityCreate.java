package org.first.controller.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.service.CommunityService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class CommunityCreate extends HttpServlet {
    private static Connection connection;
      //id , firstName , lastName , address , gender , contactNo
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination ="/WEB-INF/jsps/community/community-create.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommunityService communityService = new CommunityService();
        //
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String firstName = req.getParameter("firstName");
            boolean isNameValid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
            if (!isNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-create.jsp");
                return;
            }
            String lastName = req.getParameter("lastName");
            boolean islNameValid = JavaUtil.validateField(Constants.NAME_REGEX, lastName);
            if (!islNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-create.jsp");
                return;
            }
            String address = req.getParameter("address");
            String gender = req.getParameter("gender");
            String contactNo = req.getParameter("contactNo");
            boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, contactNo);
            if (!isNumberValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/community/community-create.jsp");
                return;
            }
            communityService.create(firstName, lastName, address , gender , contactNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/first-web-project/communityList");
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}