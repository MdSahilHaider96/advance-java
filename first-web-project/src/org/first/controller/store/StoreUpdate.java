package org.first.controller.store;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.common.util.Constants;
import org.first.common.util.JavaUtil;
import org.first.model.Store;
import org.first.service.StoreService;
import org.first.sql.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StoreUpdate extends HttpServlet {
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService  storeService = new StoreService();
        Store store = null;
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
           store =   storeService.findById(id);
           req.setAttribute("store" , store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/WEB-INF/jsps/store/store-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService storeService = new StoreService();
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //    // String firstName, String lastName, String email, String address, String phnNo, String totalBill
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        String firstName = req.getParameter("firstName");
        boolean isfNameValid = JavaUtil.validateField(Constants.NAME_REGEX, firstName);
        if (!isfNameValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-update.jsp");
            return;
        }
        String lastName = req.getParameter("lastName");
        boolean isLNameValid = JavaUtil.validateField(Constants.NAME_REGEX, lastName);
        if (!isLNameValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-update.jsp");
            return;
        }
        String email = req.getParameter("email");
        boolean isEmailValid = JavaUtil.validateField(Constants.EMAIL_REGEX, email);
        if (!isEmailValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-update.jsp");
            return;
        }
        String address = req.getParameter("address");
        String phnNo = req.getParameter("phnNo");
        boolean isNumberValid = JavaUtil.validateField(Constants.NUMBER_REGEX, phnNo);
        if (!isNumberValid) {
            JavaUtil.setJspPage(req, resp,"/WEB-INF/jsps/store/store-update.jsp");
            return;
        }
        String totalBill = req.getParameter("totalBill");
        try {
            storeService.updateById(id , firstName ,lastName , email , address , phnNo , totalBill);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String destination = "/first-web-project/storeList";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        resp.sendRedirect(destination);
   }
}
