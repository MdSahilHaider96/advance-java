package org.first.controller.store;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.service.StoreService;
import org.first.sql.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;

public class StoreCreate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "WEB-INF/jsps/store/store-create.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req , resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService storeService = new StoreService();
  // String firstName, String lastName, String email, String address, String phnNo, String totalBill
        try{
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String firstName = req.getParameter("firstName");
            boolean isfNameValid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
            if (!isfNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-create.jsp");
                return;
            }
            String lastName = req.getParameter("lastName");
            boolean isLNameValid = JavaUtil.validateField(Constants.NAME_REGEX, lastName);
            if (!isLNameValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-create.jsp");
                return;
            }
            String email = req.getParameter("email");
            boolean isEmailValid = JavaUtil.validateField(Constants.EMAIL_REGEX, email);
            if (!isEmailValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-create.jsp");
                return;
            }
            String address = req.getParameter("address");
            String phnNo = req.getParameter("phnNo");
            boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, phnNo);
            if (!isNumberValid) {
                JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-create.jsp");
                return;
            }
            String totalBill = req.getParameter("totalBill");
            storeService.create(firstName,lastName,email,address,phnNo,totalBill);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/first-web-project/storeList");
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
