package org.first.web.studentManagement.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.web.studentManagement.Model.Student;
import org.first.web.studentManagement.service.StudentService;

import java.io.IOException;
import java.sql.Connection;

public class StudentDetails extends HttpServlet {
    private static Connection connection ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        String  id = req.getParameter("id");
        int studentId = Integer.parseInt(id);
        Student student = null;
        try {
            student = studentService.findById(studentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("studentDetails", student);
        String destination = "/WEB-INF/jsps/student-management/student-details.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);
    }
}
