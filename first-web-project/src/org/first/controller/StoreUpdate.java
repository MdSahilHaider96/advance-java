package org.first.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Store;
import org.first.service.StoreService;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StoreUpdate extends HttpServlet {
    private static Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/WEB-INF/jsps/store/store-update.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
        System.out.println("STORE UPDATE GET");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        StoreService storeService = new StoreService();
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = ConnectionUtil.openConnection();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        //    // String firstName, String lastName, String email, String address, String phnNo, String totalBill
//
//        String id = req.getParameter("id");
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String email = req.getParameter("email");
//        String address = req.getParameter("address");
//        String phnNo = req.getParameter("phnNo");
//        String totalBill = req.getParameter("totalBill");
//        try {
//            storeService.updateById(Integer.parseInt(id));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
////        Store store = new Store(id , firstName , lastName ,email , address ,phnNo ,totalBill);
////        int getId = Integer.parseInt(id);
////        System.out.println(getId);
////        try {
////            storeService.updateById(getId);
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//        String destination = "/StoreList";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
//        requestDispatcher.forward(req , resp);
//        System.out.println("STORE UPDATE POST");
//   }
}
