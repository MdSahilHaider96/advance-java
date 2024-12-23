package org.first.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.sql.util.SqlUtil;

import java.io.IOException;

public class FirstServlet extends HttpServlet  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String destination = "/WEB-INF/jsps/result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        requestDispatcher.forward(request, response);

        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
